package com.api.kdiniao.subscribe.pojo;

/**
 * 预约取件之返回参数实体
 */
public class ResSubcriData {

    private String EBusinessID;  //  用户ID
    private Order Order;  //  订单信息
    private boolean Success;  //  成功与否
    private String ResultCode;  //  结果编码
    private String Reason;  //  失败原因
    private String UniquerRequestNumber;  //  唯一标识

    public String getEBusinessID() {
        return EBusinessID;
    }

    public void setEBusinessID(String EBusinessID) {
        this.EBusinessID = EBusinessID;
    }

    public com.api.kdiniao.subscribe.pojo.Order getOrder() {
        return Order;
    }

    public void setOrder(com.api.kdiniao.subscribe.pojo.Order order) {
        Order = order;
    }

    public boolean isSuccess() {
        return Success;
    }

    public void setSuccess(boolean success) {
        Success = success;
    }

    public String getResultCode() {
        return ResultCode;
    }

    public void setResultCode(String resultCode) {
        ResultCode = resultCode;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String reason) {
        Reason = reason;
    }

    public String getUniquerRequestNumber() {
        return UniquerRequestNumber;
    }

    public void setUniquerRequestNumber(String uniquerRequestNumber) {
        UniquerRequestNumber = uniquerRequestNumber;
    }

    @Override
    public String toString() {
        return "ResSubcriData{" +
                "EBusinessID='" + EBusinessID + '\'' +
                ", Order=" + Order +
                ", Success=" + Success +
                ", ResultCode='" + ResultCode + '\'' +
                ", Reason='" + Reason + '\'' +
                ", UniquerRequestNumber='" + UniquerRequestNumber + '\'' +
                '}';
    }
}
