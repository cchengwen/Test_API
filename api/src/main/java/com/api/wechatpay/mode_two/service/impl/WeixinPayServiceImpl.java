package com.api.wechatpay.mode_two.service.impl;

import com.api.wechatpay.mode_two.service.WeixinPayService;
import com.api.wechatpay.mode_two.util.HttpUtil;
import com.api.wechatpay.mode_two.util.PayConfigUtil;
import com.api.wechatpay.mode_two.util.PayToolUtil;
import com.api.wechatpay.mode_two.util.XMLUtil4jdom;
import org.jdom.JDOMException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

@Service
public class WeixinPayServiceImpl implements WeixinPayService {

    private Logger logger = LoggerFactory.getLogger(WeixinPayServiceImpl.class);

    @Override
    public String weixinPay(String userId, String productId) throws JDOMException, IOException {
        String out_trade_no = ""+System.currentTimeMillis(); // 生成订单号
        String appId = PayConfigUtil.APP_ID;  //  账号信息
        String mch_id = PayConfigUtil.MCH_ID;  //  商业号
        String key = PayConfigUtil.API_KEY;

        String currTime = PayToolUtil.getCurrTime();  //  获取当前时间
        //  随机数
        String nonce_str = currTime.substring(8, currTime.length()) + PayToolUtil.buildRandom(4) +"";
        logger.info("随机数 --> nonce_str [{}]", nonce_str);

        //  获取发起电脑ip
        String createIp = PayConfigUtil.CREATE_IP;
        //  回调接口
        String notifyUrl = PayConfigUtil.NOTIFY_URL;
        String trade_type = "NATIVE";

        SortedMap<Object, Object> sortedMap = new TreeMap<>();
        sortedMap.put("appid", appId);
        sortedMap.put("mch_id", mch_id);
        sortedMap.put("nonce_str", nonce_str);
        sortedMap.put("body", "可乐");
        sortedMap.put("out_trade_no", out_trade_no);
        sortedMap.put("total_fee", "100");
        sortedMap.put("spbill_create_ip", createIp);
        sortedMap.put("notify_url", notifyUrl);
        sortedMap.put("trade_type", trade_type);
        String sign = PayToolUtil.createSign("UTF-8", sortedMap, key);
        logger.info("生成签名：sign [{}]", sign);
        sortedMap.put("sign", sign);
        logger.info("请求参数：[{}]", sortedMap);
        //  将请求参数转换为xml格式的字符串
        String requestXml = PayToolUtil.getRequestXml(sortedMap);
        logger.info("xml格式的字符串：[{}]", requestXml);

        String resXml = HttpUtil.postData(PayConfigUtil.UFDODER_URL, requestXml);
        Map map = XMLUtil4jdom.doXMLParse(resXml);
        String urlCode = (String) map.get("code_url");
        logger.info("code_url：[{}]", urlCode);
        return urlCode;
    }
}
