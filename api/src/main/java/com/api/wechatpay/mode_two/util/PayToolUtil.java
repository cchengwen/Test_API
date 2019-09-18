package com.api.wechatpay.mode_two.util;

import java.text.SimpleDateFormat;
import java.util.*;

public class PayToolUtil {

    public static boolean chekcSign(String charset, SortedMap<Object, Object> sortedMap, String API_KEY) {
        StringBuffer sb = new StringBuffer();
        Set set = sortedMap.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            String k = (String) entry.getKey();
            String v = (String) entry.getValue();
            if (!"sign".equals(k) && v != null && !"".equals(v)) {
                sb.append(k + "=" + v + "&");
            }
        }
        sb.append("key="+API_KEY);
        //  算出摘要
        String sgin = MD5Util.MD5Encode(sb.toString(), charset).toLowerCase();
        String paySgin = ((String) sortedMap.get("sign")).toLowerCase();
        return sgin.equals(paySgin);
    }

    /**
     * 将请求参数转换为xml格式的字符串
     *
     * @param params 请求参数
     * @return
     */
    public static String getRequestXml(SortedMap<Object, Object> params) {
        StringBuffer sb = new StringBuffer();
        sb.append("<xml>");
        Set set = params.entrySet();
        Iterator iterator = set.iterator();
        if (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            String k = (String) entry.getKey();
            String v = (String) entry.getValue();
            if ("attach".equalsIgnoreCase(k) || "body".equalsIgnoreCase(k) || "sign".equalsIgnoreCase(k)) {
                sb.append("<" + k + ">" + "<![CDATA[" + v + "]]></" + k + ">");
            } else {
                sb.append("<" + k + ">" + v + "</" + k + ">");
            }
        }
        sb.append("</xml>");
        return sb.toString();
    }

    /**
     * 生成签名
     *
     * @param characterEncoding 编码格式
     * @param params            请求参数
     * @param API_KEY
     * @return
     */
    public static String createSign(String characterEncoding, SortedMap<Object, Object> params, String API_KEY) {
        StringBuffer sb = new StringBuffer();
        Set set = params.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            String key = (String) entry.getKey();
            String value = (String) entry.getValue();
            if (null != value && !"".equals(value) && !"sign".equals(key) && !"key".equals(key)) {
                sb.append(key + "=" + value + "&");
            }
        }
        sb.append("key=" + API_KEY);
        return MD5Util.MD5Encode(sb.toString(), characterEncoding).toUpperCase();
    }

    /**
     * 取出一个指定长度大小的随机正整数
     *
     * @param length
     * @return
     */
    public static int buildRandom(int length) {
        int num = 1;
        double random = Math.random();
        if (random < 0.1) {
            random = random + 0.1;
        }
        for (int i = 0; i < length; i++) {
            num = num * 10;
        }
        return (int) (random * num);
    }

    /**
     * 获取当前时间
     *
     * @return
     */
    public static String getCurrTime() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        return format.format(date);
    }
}
