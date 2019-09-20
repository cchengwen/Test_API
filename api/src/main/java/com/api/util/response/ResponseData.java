package com.api.util.response;

import java.io.ObjectInputStream;

/**
 *      json  数据响应结果集
 */
public class ResponseData {

    private static final Integer SUCCESS_STATUS = 0;
    private static final Integer ERROR_STATUS = 1;
    private static final String SUCCESS_MESSAGE = "OK";

    private Integer status;
    private String message;
    private Object data;

    public static ResponseData getSuccess(Object data){
        return new ResponseData(SUCCESS_STATUS, SUCCESS_MESSAGE, data);
    }

    public static ResponseData getSuccessMsg(String message, Object data){
        return new ResponseData(SUCCESS_STATUS, message, data);
    }


    public static ResponseData getError(String message){
        return new ResponseData(ERROR_STATUS, message, null);
    }


    private ResponseData(Integer status, String message, Object data){
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
