package com.api.test.shenzhou.res;

public class DataList {
    private String code; //  型号（产品）代号
    private String name;  //  	型号（产品）名称
    private String category_code;  // 型号（产品）所属分类的代号
    private String category_name;  // 	型号（产品）所属分类的名称
    private String standard_code;  //  型号（产品）所属规格的代号
    private String standard_name;  // 型号（产品）所属规格的名称
    private String brand_code;  //  型号（产品）所属品牌的代号
    private String brand_name;  //  	型号（产品）所属品牌的名称

    public String getBrand_code() {
        return brand_code;
    }

    public void setBrand_code(String brand_code) {
        this.brand_code = brand_code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCategory_code() {
        return category_code;
    }

    public void setCategory_code(String category_code) {
        this.category_code = category_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStandard_name() {
        return standard_name;
    }

    public void setStandard_name(String standard_name) {
        this.standard_name = standard_name;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public String getStandard_code() {
        return standard_code;
    }

    public void setStandard_code(String standard_code) {
        this.standard_code = standard_code;
    }

    @Override
    public String toString() {
        return "ShenPojo{" +
                "brand_code='" + brand_code + '\'' +
                ", code='" + code + '\'' +
                ", category_name='" + category_name + '\'' +
                ", category_code='" + category_code + '\'' +
                ", name='" + name + '\'' +
                ", standard_name='" + standard_name + '\'' +
                ", brand_name='" + brand_name + '\'' +
                ", standard_code='" + standard_code + '\'' +
                '}';
    }
}
