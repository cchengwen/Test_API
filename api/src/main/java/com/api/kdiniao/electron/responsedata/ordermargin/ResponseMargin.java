package com.api.kdiniao.electron.responsedata.ordermargin;


import com.api.kdiniao.electron.pojo.ResponseParams;

/**
 *   余量返回参数实体
 */
public class ResponseMargin extends ResponseParams {

    private ResMarginEorderBalance EorderBalance;  //  余量数量

    public ResMarginEorderBalance getEorderBalance() {
        return EorderBalance;
    }

    public void setEorderBalance(ResMarginEorderBalance eorderBalance) {
        EorderBalance = eorderBalance;
    }

    @Override
    public String toString() {
        return "ResponseMargin{" +
                "EorderBalance=" + EorderBalance +
                '}';
    }
}
