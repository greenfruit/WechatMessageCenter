package com.fruit.chat.message.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

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
@Controller
@RequestMapping("/")
public class IndexController {

    /**
     * 跳转主页面
     * @author zhangshouzheng
     * @date:2016年4月9日 下午2:48:24
     */
    @RequestMapping(value = "welcome", method = RequestMethod.GET)
    public ModelAndView welcome(Model model) {
        Map<String, Object> model1 = new HashMap();
        model1.put("dynaCondList", "hello,kitty!");
        return new ModelAndView("index/welcome", model1);
    }
}
