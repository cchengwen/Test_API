package com.api.newtest.realizeapi.workorder.pojo;

public class Products {
    private String pro_code;
    private String pro_brand;
    private String pro_model;
    private String pro_spec;
    private Integer quantity;

    public String getPro_code() {
        return pro_code;
    }

    public void setPro_code(String pro_code) {
        this.pro_code = pro_code;
    }

    public String getPro_brand() {
        return pro_brand;
    }

    public void setPro_brand(String pro_brand) {
        this.pro_brand = pro_brand;
    }

    public String getPro_model() {
        return pro_model;
    }

    public void setPro_model(String pro_model) {
        this.pro_model = pro_model;
    }

    public String getPro_spec() {
        return pro_spec;
    }

    public void setPro_spec(String pro_spec) {
        this.pro_spec = pro_spec;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Products{" +
                "pro_code='" + pro_code + '\'' +
                ", pro_brand='" + pro_brand + '\'' +
                ", pro_model='" + pro_model + '\'' +
                ", pro_spec='" + pro_spec + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
