package com.api.kdiniao.publicpojo;

public class ResLogistic {
    private String EBusinessID;  //  用户ID
    private String OrderCode;  //  订单编号
    private String ShipperCode;  //  快递公司编码
    private String LogisticCode;  //   物流运单号
    private boolean Success;  //  成功与否
    private String Reason;  //  失败原因
    private String State;  //  物流状态：2-在途中,3-签收,4-问题件

    public String getEBusinessID() {
        return EBusinessID;
    }

    public void setEBusinessID(String EBusinessID) {
        this.EBusinessID = EBusinessID;
    }

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

    public boolean isSuccess() {
        return Success;
    }

    public void setSuccess(boolean success) {
        Success = success;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String reason) {
        Reason = reason;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    @Override
    public String toString() {
        return "ResLogistic{" +
                "EBusinessID='" + EBusinessID + '\'' +
                ", OrderCode='" + OrderCode + '\'' +
                ", ShipperCode='" + ShipperCode + '\'' +
                ", LogisticCode='" + LogisticCode + '\'' +
                ", Success=" + Success +
                ", Reason='" + Reason + '\'' +
                ", State='" + State + '\'' +
                '}';
    }
}
