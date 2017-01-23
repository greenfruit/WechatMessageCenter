package com.fruit.chat.message.domain.weather;

/**
 * <p>DESCRIPTION:  生活指数
 * <p>CALLED BY:   zhangshouzheng
 * <p>UPDATE BY:   zhangshouzheng
 * <p>CREATE DATE: 2017/1/23
 * <p>UPDATE DATE: 2017/1/23
 *
 * @version 1.0
 * @since java 1.7.0
 */
public class Index {
    private String des;
    private String tipt;
    private String title;
    private String zs;

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getTipt() {
        return tipt;
    }

    public void setTipt(String tipt) {
        this.tipt = tipt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getZs() {
        return zs;
    }

    public void setZs(String zs) {
        this.zs = zs;
    }
}
