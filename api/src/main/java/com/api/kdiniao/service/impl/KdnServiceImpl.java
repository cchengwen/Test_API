package com.api.kdiniao.service.impl;

import com.alibaba.fastjson.JSON;
import com.api.kdiniao.instantquery.pojo.InstantQuery;
import com.api.kdiniao.instantquery.returndata.ResInstantData;
import com.api.kdiniao.kdutils.HttpUtils;
import com.api.kdiniao.monitor.pojo.ResMonitorData;
import com.api.kdiniao.service.KdnService;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class KdnServiceImpl implements KdnService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired private HttpUtils httpUtils;

    @Override
    public ResInstantData getInstanNode() {
        InstantQuery instantQuery = new InstantQuery();
        instantQuery.setShipperCode("SF");
        instantQuery.setOrderCode("SF2019090517256639");
        instantQuery.setLogisticCode("252314540522");
        String json = JSONObject.fromObject(instantQuery).toString();
        logger.info("即时监控json请求参数：[{}]", json);
        String postData = httpUtils.postData(json, "1002");
        return JSON.parseObject(postData, ResInstantData.class);
    }

    @Override
    public ResMonitorData getMonitorNode() {
        InstantQuery instantQuery = new InstantQuery();
        instantQuery.setShipperCode("SF");
        instantQuery.setOrderCode("SF2019090517256639");
        instantQuery.setLogisticCode("252314540522");
        String json = JSONObject.fromObject(instantQuery).toString();
        logger.info("在途监控json请求参数：[{}]", json);
        String postData = httpUtils.postData(json, "8001");
        return JSON.parseObject(postData, ResMonitorData.class);
    }
}
