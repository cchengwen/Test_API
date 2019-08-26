package com.api.test.shenzhou.pojo;

public class Products {
    private String category_code;
    private String standard_code;
    private String brand_code;
    private String brand_name;
    private String model_code;
    private String model_name;
    private String nums;
    private String service_request;

    public String getCategory_code() {
        return category_code;
    }

    public void setCategory_code(String category_code) {
        this.category_code = category_code;
    }

    public String getStandard_code() {
        return standard_code;
    }

    public void setStandard_code(String standard_code) {
        this.standard_code = standard_code;
    }

    public String getBrand_code() {
        return brand_code;
    }

    public void setBrand_code(String brand_code) {
        this.brand_code = brand_code;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public String getModel_code() {
        return model_code;
    }

    public void setModel_code(String model_code) {
        this.model_code = model_code;
    }

    public String getModel_name() {
        return model_name;
    }

    public void setModel_name(String model_name) {
        this.model_name = model_name;
    }

    public String getNums() {
        return nums;
    }

    public void setNums(String nums) {
        this.nums = nums;
    }

    public String getService_request() {
        return service_request;
    }

    public void setService_request(String service_request) {
        this.service_request = service_request;
    }

    @Override
    public String toString() {
        return "Products{" +
                "category_code='" + category_code + '\'' +
                ", standard_code='" + standard_code + '\'' +
                ", brand_code='" + brand_code + '\'' +
                ", brand_name='" + brand_name + '\'' +
                ", model_code='" + model_code + '\'' +
                ", model_name='" + model_name + '\'' +
                ", nums='" + nums + '\'' +
                ", service_request='" + service_request + '\'' +
                '}';
    }
}
