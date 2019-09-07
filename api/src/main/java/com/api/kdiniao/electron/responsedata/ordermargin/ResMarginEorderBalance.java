package com.api.kdiniao.electron.responsedata.ordermargin;

/**
 *   余量参数返回实体之剩余余量数量
 */
public class ResMarginEorderBalance {
    private Integer AvailableNum;  //  剩余可用量
    private Integer TotalNum;  //  累计充值数量，电子面单总量(包含已使用/未使用)

    public Integer getAvailableNum() {
        return AvailableNum;
    }

    public void setAvailableNum(Integer availableNum) {
        AvailableNum = availableNum;
    }

    @Override
    public String toString() {
        return "ResMarginEorderBalance{" +
                "AvailableNum=" + AvailableNum +
                ", TotalNum=" + TotalNum +
                '}';
    }
}
