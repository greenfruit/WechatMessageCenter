package com.fruit.chat.message.service.weather;

import com.fruit.chat.message.domain.weather.Index;
import com.fruit.chat.message.domain.weather.Results;
import com.fruit.chat.message.domain.weather.Status;
import com.fruit.chat.message.domain.weather.Weather;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;

/**
 * <p>DESCRIPTION:  类描述
 * <p>CALLED BY:   zhangshouzheng
 * <p>UPDATE BY:   zhangshouzheng
 * <p>CREATE DATE: 2017/1/22
 * <p>UPDATE DATE: 2017/1/22
 *
 * @version 1.0
 * @since java 1.7.0
 */
public class WeatherService {
    private static String api = "http://api.map.baidu.com/telematics/v3/weather?";
    private static String output = "json";
    private static String ak = "369e0a3c0cff22fcbc25f1b1b9ebe65d";

    public static Status getSend(String str){
        //将传进来的城市转码
        try {
            str = URLEncoder.encode(str, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //拼接url
        StringBuffer buf = new StringBuffer();
        buf.append("location=");
        buf.append(str);
        buf.append("&output=");
        buf.append(output);
        buf.append("&ak=");
        buf.append(ak);
        String param = buf.toString();
        //这是接收百度API返回的内容
        String result = "";
        String urlName = api + param;
        URL realUrl;
        try {
            realUrl = new URL(urlName);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            conn.setDoInput(true);
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line = br.readLine();
            while (line != null) {
                result += line;
                line = br.readLine();
            }
            br.close();
            Gson gson = new Gson();
            Status status = gson.fromJson(result, Status.class);
            return status;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;

    }

    /**
     * 获取json对象
     * @param status
     * @return
     */
    public static String resolveJsonResult(Status status){
        StringBuffer content = new StringBuffer();
        Results results =status.getResults().get(0);
        List<Weather>  weatherList= status.getResults().get(0).getWeather_data();
        List<Index> indexList = status.getResults().get(0).getIndex();
        content.append("城市："+results.getCurrentCity()+"\n");
        content.append("PM2.5："+getPMByInt(results.getPm25())+"\n");

        content.append("天气情况：\n");
        for (Weather weather:weatherList) {
            content.append(weather.getDate()+"\n");
            content.append(weather.getWeather()+" "+weather.getTemperature()+" "+weather.getWind()+"\n");
            content.append("\n");
        }
        content.append("\n\n");
        content.append("生活相关指数：\n");
        for (Index index: indexList) {
            content.append("指数："+index.getTipt()+"\n");
            content.append("描述："+index.getDes()+"\n");
            content.append(index.getTitle()+"："+index.getZs()+"\n");
            content.append("\n\n");
        }

        return content.toString();
    }

    /**
     * pm 2.5 返回 空气指数
     * 0~50，一级，优，绿色；
     51~100，二级，良，黄色； 101~150，三级，轻度污染，橙色； 151~200，四级，中度污染 ，红色； 201~300，五级，重度污染 ，紫色； >300，六级，严重污染
     */
    public static String getPMByInt(String pm){
        if(pm == null || pm.equals("")){
            return "0";
        }
        int pmInt = Integer.parseInt(pm);
        StringBuffer ret= new StringBuffer(pm+",");
        if(pmInt>=0 && pmInt <=50){
            ret = ret.append("一级，优");
        }else if(pmInt> 50 && pmInt <=100){
            ret = ret.append("二级，良");
        }else if(pmInt> 100 && pmInt <=150){
            ret = ret.append("三级，轻度污染");
        }else if(pmInt> 150 && pmInt <=200){
            ret = ret.append("四级，中度污染");
        }else if(pmInt> 200 && pmInt <=300){
            ret = ret.append("五级，重度污染");
        }else if(pmInt> 300){
            ret = ret.append("六级，严重污染");
        }
        return ret.toString();
    }


}
