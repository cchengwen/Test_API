package com.api.kdiniao.kdutils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class HttpUtils {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${KDNiao.EBusinessID}")
    private String EBusinessID;

    @Value("${KDNiao.APIKey}")
    private String APIKey;

    @Value("${KDNiao.url}")
    private String URL;

    /**
     *
     * @param json  json数据
     * @param requestType  请求指令类型
     * @return
     */
    public String postData(String json, String requestType){
        Map<String, String> params = new HashMap<>();
        params.put("RequestData", KDNiaoUtil.urlEncode(json));
        params.put("EBusinessID", EBusinessID);
        params.put("RequestType", requestType);
        params.put("DataSign", KDNiaoUtil.urlEncode(KDNiaoUtil.createSign(json, APIKey)));
        params.put("DataType", "2");
        logger.info("最终请求参数：[{}]", params);
        return KDNiaoUtil.sendPost(URL, params);
    }
}
