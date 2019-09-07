package com.api.kdiniao.electron.pojo;

public class ResponseParams {
    private String EBusinessID;  //  用户ID
    private boolean Success;  //  成功与否(true/false)
    private String Reason;  //  失败原因
    private String ResultCode;  //  返回编码

    public String getEBusinessID() {
        return EBusinessID;
    }

    public void setEBusinessID(String EBusinessID) {
        this.EBusinessID = EBusinessID;
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

    public String getResultCode() {
        return ResultCode;
    }

    public void setResultCode(String resultCode) {
        ResultCode = resultCode;
    }

    @Override
    public String toString() {
        return "ResponseParams{" +
                "EBusinessID='" + EBusinessID + '\'' +
                ", Success=" + Success +
                ", Reason='" + Reason + '\'' +
                ", ResultCode='" + ResultCode + '\'' +
                '}';
    }
}
