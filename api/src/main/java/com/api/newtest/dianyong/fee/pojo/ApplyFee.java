package com.api.newtest.dianyong.fee.pojo;

import java.util.List;

/**
 *   费用申请接口
 */
public class ApplyFee {
    private String order_number;
    private List<FeeList> fee_list;

    public String getOrder_number() {
        return order_number;
    }

    public void setOrder_number(String order_number) {
        this.order_number = order_number;
    }

    public List<FeeList> getFee_list() {
        return fee_list;
    }

    public void setFee_list(List<FeeList> fee_list) {
        this.fee_list = fee_list;
    }

    @Override
    public String toString() {
        return "ApplyFee{" +
                "order_number='" + order_number + '\'' +
                ", fee_list=" + fee_list +
                '}';
    }
}
