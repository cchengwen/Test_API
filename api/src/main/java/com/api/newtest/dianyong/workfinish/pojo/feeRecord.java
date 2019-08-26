package com.api.newtest.dianyong.workfinish.pojo;

public class feeRecord {
    private String fee_name;
    private double fee_price;

    public String getFee_name() {
        return fee_name;
    }

    public void setFee_name(String fee_name) {
        this.fee_name = fee_name;
    }

    public double getFee_price() {
        return fee_price;
    }

    public void setFee_price(double fee_price) {
        this.fee_price = fee_price;
    }

    @Override
    public String toString() {
        return "feeRecord{" +
                "fee_name='" + fee_name + '\'' +
                ", fee_price=" + fee_price +
                '}';
    }
}
