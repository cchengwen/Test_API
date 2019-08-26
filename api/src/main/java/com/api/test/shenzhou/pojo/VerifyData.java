package com.api.test.shenzhou.pojo;

import java.util.List;

public class VerifyData {
    private String service_type;
    private String order_type;
    private String remark;
    private List<Data> data;

    public String getService_type() {
        return service_type;
    }

    public void setService_type(String service_type) {
        this.service_type = service_type;
    }

    public String getOrder_type() {
        return order_type;
    }

    public void setOrder_type(String order_type) {
        this.order_type = order_type;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "VerifyData{" +
                "service_type='" + service_type + '\'' +
                ", order_type='" + order_type + '\'' +
                ", remark='" + remark + '\'' +
                ", data=" + data +
                '}';
    }
}
