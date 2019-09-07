package com.api.kdiniao.electron.pojo.cancelorder;

/**
 *   取消订单实体
 */
public class CancelOrder {

    private String ShipperCode;  //  快递公司编码
    private String OrderCode;  //  订单编号
    private String ExpNo;  //  快递单号
    private String CustomerName;  //  电子面单客户号
    private String CustomerPwd;  //  电子面单密码

    public String getShipperCode() {
        return ShipperCode;
    }

    public void setShipperCode(String shipperCode) {
        ShipperCode = shipperCode;
    }

    public String getOrderCode() {
        return OrderCode;
    }

    public void setOrderCode(String orderCode) {
        OrderCode = orderCode;
    }

    public String getExpNo() {
        return ExpNo;
    }

    public void setExpNo(String expNo) {
        ExpNo = expNo;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getCustomerPwd() {
        return CustomerPwd;
    }

    public void setCustomerPwd(String customerPwd) {
        CustomerPwd = customerPwd;
    }

    @Override
    public String toString() {
        return "CancelOrder{" +
                "ShipperCode='" + ShipperCode + '\'' +
                ", OrderCode='" + OrderCode + '\'' +
                ", ExpNo='" + ExpNo + '\'' +
                ", CustomerName='" + CustomerName + '\'' +
                ", CustomerPwd='" + CustomerPwd + '\'' +
                '}';
    }
}
