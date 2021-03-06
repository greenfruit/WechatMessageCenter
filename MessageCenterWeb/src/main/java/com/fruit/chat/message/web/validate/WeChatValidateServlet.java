package com.fruit.chat.message.web.validate;

import com.fruit.chat.message.service.MessageService;
import com.fruit.chat.message.web.util.SignUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * <p>DESCRIPTION:  类描述
 * <p>CALLED BY:   zhangshouzheng
 * <p>UPDATE BY:   zhangshouzheng
 * <p>CREATE DATE: 2017/1/20
 * <p>UPDATE DATE: 2017/1/20
 *
 * @version 1.0
 * @since java 1.7.0
 */
public class WeChatValidateServlet extends HttpServlet {
    @Autowired
    private MessageService messageService;

    @Override
    public void init(ServletConfig config) throws ServletException
    {
        //servlet中初始化spring容器管理的实例
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 将请求、响应的编码均设置为UTF-8（防止中文乱码）
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        // 调用核心业务类接收消息、处理消息
        String respMessage = messageService.processRequest(request);

        // 响应消息
        PrintWriter out = response.getWriter();
        out.print(respMessage);
        out.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 微信加密签名
        String signature = request.getParameter("signature");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");
        // 随机字符串
        String echostr = request.getParameter("echostr");

        PrintWriter out = response.getWriter();
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
        if (SignUtil.checkSignature(signature, timestamp, nonce)) {
            out.print(echostr);
        }
        out.close();
        out = null;
    }
}
