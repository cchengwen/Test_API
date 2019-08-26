package com.api.test.shenzhou.res;

public class ShenZhouReturnData {
    private Integer error_code;
    private String error_msg;
    private Datas data;

    public Integer getError_code() {
        return error_code;
    }

    public void setError_code(Integer error_code) {
        this.error_code = error_code;
    }

    public String getError_msg() {
        return error_msg;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public Datas getData() {
        return data;
    }

    public void setData(Datas data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ShenZhouReturnData{" +
                "error_code=" + error_code +
                ", error_msg='" + error_msg + '\'' +
                ", data=" + data +
                '}';
    }
}
