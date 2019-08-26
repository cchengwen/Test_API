package com.api.test.shenzhou.pojo;

import java.util.List;

public class Data {
    private String out_trade_number;
    private UserInfo user_info;
    private List<Products> products;
    private List<Express> express;

    public String getOut_trade_number() {
        return out_trade_number;
    }

    public void setOut_trade_number(String out_trade_number) {
        this.out_trade_number = out_trade_number;
    }

    public UserInfo getUser_info() {
        return user_info;
    }

    public void setUser_info(UserInfo user_info) {
        this.user_info = user_info;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    public List<Express> getExpress() {
        return express;
    }

    public void setExpress(List<Express> express) {
        this.express = express;
    }

    @Override
    public String toString() {
        return "Data{" +
                "out_trade_number='" + out_trade_number + '\'' +
                ", user_info=" + user_info +
                ", products=" + products +
                ", express=" + express +
                '}';
    }
}
