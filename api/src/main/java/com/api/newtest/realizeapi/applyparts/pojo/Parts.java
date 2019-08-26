package com.api.newtest.realizeapi.applyparts.pojo;

public class Parts {
    private String part_name;  //  申请备件名称
    private Integer quantity;  //  数量
    private String payer;  //  付款方
    private double part_price;  //  申请备件价格(总价) ，没有或者审核不通过可填0
    private Integer review_status;  //  审核状态：0通过、1不通过

    public String getPart_name() {
        return part_name;
    }

    public void setPart_name(String part_name) {
        this.part_name = part_name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    public double getPart_price() {
        return part_price;
    }

    public void setPart_price(double part_price) {
        this.part_price = part_price;
    }

    public Integer getReview_status() {
        return review_status;
    }

    public void setReview_status(Integer review_status) {
        this.review_status = review_status;
    }

    @Override
    public String toString() {
        return "Parts{" +
                "part_name='" + part_name + '\'' +
                ", quantity=" + quantity +
                ", payer='" + payer + '\'' +
                ", part_price=" + part_price +
                ", review_status=" + review_status +
                '}';
    }
}
