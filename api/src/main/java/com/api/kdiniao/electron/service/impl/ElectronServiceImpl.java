package com.api.kdiniao.electron.service.impl;

import com.alibaba.fastjson.JSON;
import com.api.kdiniao.electron.pojo.*;
import com.api.kdiniao.electron.pojo.cancelorder.CancelOrder;
import com.api.kdiniao.electron.pojo.customernumapply.ApplyCustNumber;
import com.api.kdiniao.electron.pojo.customernumpush.PushCustNumber;
import com.api.kdiniao.electron.pojo.eleorder.Receiver;
import com.api.kdiniao.electron.pojo.eleorder.RequestData;
import com.api.kdiniao.electron.pojo.eleorder.Sender;
import com.api.kdiniao.electron.pojo.ordermargin.RequestMargin;
import com.api.kdiniao.electron.responsedata.customernumapply.RespApplyCustNumber;
import com.api.kdiniao.electron.responsedata.customernumpush.RespCustPush;
import com.api.kdiniao.electron.responsedata.ordermargin.ResponseMargin;
import com.api.kdiniao.electron.responsedata.eleorder.RespEleData;
import com.api.kdiniao.electron.service.ElectronService;
import com.api.kdiniao.kdutils.HttpUtils;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ElectronServiceImpl implements ElectronService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired private HttpUtils httpUtils;

    @Override
    public RespEleData pushElectron() {
        RequestData requestData = new RequestData();
        requestData.setOrderCode("SF2019090517256639");
        requestData.setShipperCode("SF");
        requestData.setPayType(1);
        requestData.setExpType(1);
        requestData.setCost(99.3);
        requestData.setOtherCost(99.5);
        requestData.setWeight(1.0);
        requestData.setQuantity(1);
        requestData.setVolume(0.0);
        requestData.setRemark("加急配送");
        requestData.setIsReturnPrintTemplate("1");

        //  收件人信息
        Receiver receiver = new Receiver();
        receiver.setName("王秋红");
        receiver.setMobile("12345678912");
        receiver.setProvinceName("广东省");
        receiver.setCityName("中山市");
        receiver.setExpAreaName("小榄镇");
        receiver.setAddress("XXX路108号");
        requestData.setReceiver(receiver);

        //发件人信息
        Sender send = new Sender();
        send.setName("李涛");
        send.setMobile("88596640226");
        send.setProvinceName("广东省");
        send.setCityName("佛山市");
        send.setExpAreaName("容桂镇");
        send.setAddress("XXX路250号");
        requestData.setSender(send);

        List<Commoditys> commoditysList = new ArrayList<>();
        Commoditys commoditys = new Commoditys();
        commoditys.setGoodsName("漏水空调一个");
        commoditys.setGoodsquantity(1);
        commoditys.setGoodsPrice(999.99);
        commoditysList.add(commoditys);
        requestData.setCommodity(commoditysList);
        //  转为json对象
        String json = JSONObject.fromObject(requestData).toString();
        logger.info("电子面单json参数：[{}]", json);

        RespEleData elereturnData = JSON.parseObject(httpUtils.postData(json, "1007"), RespEleData.class);
        return elereturnData;
    }

    @Override
    public void cancelOrder() {
        CancelOrder cancelOrder = new CancelOrder();
        cancelOrder.setOrderCode("SF2019090517256639");
        cancelOrder.setShipperCode("SF");
        cancelOrder.setExpNo("SF1011329666817");
        //  转json
        String jsonObject = JSONObject.fromObject(cancelOrder).toString();
        String post = httpUtils.postData(jsonObject, "1147");
        System.out.println(post);
    }

    @Override
    public ResponseMargin findMargin() {
        RequestMargin requestMargin = new RequestMargin();
        requestMargin.setShipperCode("SF");
        requestMargin.setCustomerName("80238728");
        requestMargin.setCustomerPwd("c0bfe0ba86b66bae5426303c53db0a81");
        requestMargin.setStationCode("3001");
        requestMargin.setStationName("福田网点");
        String json = JSONObject.fromObject(requestMargin).toString();
        logger.info("余量请求参数：[{}]", json);

        String postData = httpUtils.postData(json, "1127");
        ResponseMargin responseMargin = JSON.parseObject(postData, ResponseMargin.class);
        return responseMargin;
    }

    @Override
    public RespApplyCustNumber applyCustNumber() {
        ApplyCustNumber custNumber = new ApplyCustNumber();
        custNumber.setShipperCode("SF");
        custNumber.setCompany("快递鸟");
        custNumber.setApplyID("1255800");
        custNumber.setName("张三");
        custNumber.setMobile("13145985523");
        custNumber.setProvinceName("广东省");
        custNumber.setProivnceCode("440000");
        custNumber.setCityName("深圳市");
        custNumber.setCityCode("440300");
        custNumber.setExpAreaName("宝安区");
        custNumber.setExpAreaCode("440306");
        custNumber.setAddress("西乡1路");
        custNumber.setStationName("西乡网点");
        custNumber.setStationCode("西乡网点");
        String json = JSONObject.fromObject(custNumber).toString();
        logger.info("申请客户号请求参数：[{}]", json);
        String postData = httpUtils.postData(json, "1127");
        return JSON.parseObject(postData, RespApplyCustNumber.class);
    }

    @Override
    public RespCustPush custPush() {
        PushCustNumber pushCustNumber = new PushCustNumber();
        pushCustNumber.setApplyCode("");
        pushCustNumber.setCustomerName("");
        pushCustNumber.setCustomerPwd("");
        pushCustNumber.setStationCode("");
        pushCustNumber.setStationName("");
        String json = JSONObject.fromObject(pushCustNumber).toString();
        logger.info("客户号推送请求参数：[{}]", json);
        String postData = httpUtils.postData(json, "1117");
        return JSON.parseObject(postData, RespCustPush.class);
    }

}
