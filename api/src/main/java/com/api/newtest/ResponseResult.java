package com.api.newtest;

/**
 *   数据返回结果
 */
public class ResponseResult {
    private Integer code;
    private String msg;
    private Object data;


    public static ResponseResult success(String msg, Object data){
        return new ResponseResult(0, msg, data);
    }

    private ResponseResult(Integer code, String msg, Object data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


}
