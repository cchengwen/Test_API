package com.api.kdiniao.electron.service;

import com.api.kdiniao.electron.responsedata.customernumapply.RespApplyCustNumber;
import com.api.kdiniao.electron.responsedata.customernumpush.RespCustPush;
import com.api.kdiniao.electron.responsedata.ordermargin.ResponseMargin;
import com.api.kdiniao.electron.responsedata.eleorder.RespEleData;

public interface ElectronService {

    /**
     *   电子面单接口
     * @return
     */
    RespEleData pushElectron();

    /**
     *  取消订单接口
     */
    void cancelOrder();

    /**
     *  查余量接口
     * @return
     */
    ResponseMargin findMargin();

    /**
     *  申请客户号
     * @return
     */
    RespApplyCustNumber applyCustNumber();

    /**
     *   客户号推送
     * @return
     */
    RespCustPush custPush();


}
