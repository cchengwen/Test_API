package com.api.kdiniao.instantquery.pojo;

/**
 *   即时查询实体
 */
public class InstantQuery {
    private String OrderCode;  //  订单编号
    private String ShipperCode;  //  快递公司编码
    private String LogisticCode;  //  物流单号

    public String getOrderCode() {
        return OrderCode;
    }

    public void setOrderCode(String orderCode) {
        OrderCode = orderCode;
    }

    public String getShipperCode() {
        return ShipperCode;
    }

    public void setShipperCode(String shipperCode) {
        ShipperCode = shipperCode;
    }

    public String getLogisticCode() {
        return LogisticCode;
    }

    public void setLogisticCode(String logisticCode) {
        LogisticCode = logisticCode;
    }

    @Override
    public String toString() {
        return "InstantQuery{" +
                "OrderCode='" + OrderCode + '\'' +
                ", ShipperCode='" + ShipperCode + '\'' +
                ", LogisticCode='" + LogisticCode + '\'' +
                '}';
    }
}
