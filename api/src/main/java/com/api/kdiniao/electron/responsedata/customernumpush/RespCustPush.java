package com.api.kdiniao.electron.responsedata.customernumpush;

import com.api.kdiniao.electron.pojo.ResponseParams;

public class RespCustPush extends ResponseParams {
     private String  RequestType; //  接口指令
     private String  Message; //  返回消息

    public String getRequestType() {
        return RequestType;
    }

    public void setRequestType(String requestType) {
        RequestType = requestType;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    @Override
    public String toString() {
        return "RespCustPush{" +
                "RequestType='" + RequestType + '\'' +
                ", Message='" + Message + '\'' +
                '}';
    }
}
