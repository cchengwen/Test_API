package com.api.newtest.realizeapi.workorder.pojo;

import java.util.List;

public class CreateWork {
    private String name;
    private String phone;
    private String address;
    private String order_number;
    private Integer order_type;
    private Integer warranty_type;
    private String service_level;
    private String remark;
    private List<Products> products;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOrder_number() {
        return order_number;
    }

    public void setOrder_number(String order_number) {
        this.order_number = order_number;
    }

    public Integer getOrder_type() {
        return order_type;
    }

    public void setOrder_type(Integer order_type) {
        this.order_type = order_type;
    }

    public Integer getWarranty_type() {
        return warranty_type;
    }

    public void setWarranty_type(Integer warranty_type) {
        this.warranty_type = warranty_type;
    }

    public String getService_level() {
        return service_level;
    }

    public void setService_level(String service_level) {
        this.service_level = service_level;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "CreateWork{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", order_number='" + order_number + '\'' +
                ", order_type=" + order_type +
                ", warranty_type=" + warranty_type +
                ", service_level='" + service_level + '\'' +
                ", remark='" + remark + '\'' +
                ", products=" + products +
                '}';
    }
}
