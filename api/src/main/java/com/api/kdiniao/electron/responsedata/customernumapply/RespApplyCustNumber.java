package com.api.kdiniao.electron.responsedata.customernumapply;

import com.api.kdiniao.electron.pojo.ResponseParams;

/**
 *  申请客户号参数返回结果实体
 */
public class RespApplyCustNumber extends ResponseParams {
    private String ApplyCode;  //   客户编号

    public String getApplyCode() {
        return ApplyCode;
    }

    public void setApplyCode(String applyCode) {
        ApplyCode = applyCode;
    }

    @Override
    public String toString() {
        return "RespApplyCustNumber{" +
                "ApplyCode='" + ApplyCode + '\'' +
                '}';
    }
}
