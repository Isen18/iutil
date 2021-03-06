package com.isen.util.route.datasource.datasource;

/**
 * @author Isen
 * @date 2019/4/17 23:12
 * @since 1.0
 */
public enum DBKeyEn {
    MASTER("master"),
    SLAVE("slave");

    private String mean;

    DBKeyEn(String mean) {
        this.mean = mean;
    }

    public String getMean() {
        return this.mean;
    }
}

