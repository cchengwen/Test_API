package com.api.newtest.realizeapi.workorder.pojo;

public class CancelWork {
    private String order_number;
    private String remark;

    public String getOrder_number() {
        return order_number;
    }

    public void setOrder_number(String order_number) {
        this.order_number = order_number;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "CancelWork{" +
                "order_number='" + order_number + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
