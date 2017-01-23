package com.fruit.chat.message.domain.weather;

import java.util.List;

/**
 * <p>DESCRIPTION:  类描述
 * <p>CALLED BY:   zhangshouzheng
 * <p>UPDATE BY:   zhangshouzheng
 * <p>CREATE DATE: 2017/1/23
 * <p>UPDATE DATE: 2017/1/23
 *
 * @version 1.0
 * @since java 1.7.0
 */
public class Results {
    private String currentCity;
    private String pm25;
    private List<Weather> weather_data;
    private List<Index> index;

    public String getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(String currentCity) {
        this.currentCity = currentCity;
    }

    public List<Weather> getWeather_data() {
        return weather_data;
    }

    public void setWeather_data(List<Weather> weather_data) {
        this.weather_data = weather_data;
    }

    public String getPm25() {
        return pm25;
    }

    public void setPm25(String pm25) {
        this.pm25 = pm25;
    }

    public List<Index> getIndex() {
        return index;
    }

    public void setIndex(List<Index> index) {
        this.index = index;
    }
}
