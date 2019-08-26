package com.api.newtest.dianyong.part.pojo;

import java.util.List;

/**
 *    申请配件接口
 */
public class PartsAPI {

    private String order_number;
    private String receipt_address;
    private String application_name;
    private String remark;
    private List<Parts> parts;

    public String getOrder_number() {
        return order_number;
    }

    public void setOrder_number(String order_number) {
        this.order_number = order_number;
    }

    public String getReceipt_address() {
        return receipt_address;
    }

    public void setReceipt_address(String receipt_address) {
        this.receipt_address = receipt_address;
    }

    public String getApplication_name() {
        return application_name;
    }

    public void setApplication_name(String application_name) {
        this.application_name = application_name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<Parts> getParts() {
        return parts;
    }

    public void setParts(List<Parts> parts) {
        this.parts = parts;
    }

    @Override
    public String toString() {
        return "PartsAPI{" +
                "order_number='" + order_number + '\'' +
                ", receipt_address='" + receipt_address + '\'' +
                ", application_name='" + application_name + '\'' +
                ", remark='" + remark + '\'' +
                ", parts=" + parts +
                '}';
    }
}
