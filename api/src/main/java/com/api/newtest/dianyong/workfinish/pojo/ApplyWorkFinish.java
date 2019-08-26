package com.api.newtest.dianyong.workfinish.pojo;

import java.util.List;

/**
 *   工单完结接口申请
 */
public class ApplyWorkFinish {
    private String order_number;
    private String annex;
    private List<feeRecord> fee_record;

    public String getOrder_number() {
        return order_number;
    }

    public void setOrder_number(String order_number) {
        this.order_number = order_number;
    }

    public String getAnnex() {
        return annex;
    }

    public void setAnnex(String annex) {
        this.annex = annex;
    }

    public List<feeRecord> getFee_record() {
        return fee_record;
    }

    public void setFee_record(List<feeRecord> fee_record) {
        this.fee_record = fee_record;
    }

    @Override
    public String toString() {
        return "ApplyWorkFinish{" +
                "order_number='" + order_number + '\'' +
                ", annex='" + annex + '\'' +
                ", fee_record=" + fee_record +
                '}';
    }
}
