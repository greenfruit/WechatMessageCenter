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
public class Status {
    private String error;
    private String status;
    private String date;
    private List<Results> results;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
