package com.api.kdiniao.kdutils;

import com.sun.org.apache.xml.internal.security.utils.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class KDNiaoUtil {
    private static Logger logger = LoggerFactory.getLogger(KDNiaoUtil.class);

    private static final String CHARSET = "UTF-8";

    /**
     * 生成签名
     *
     * @param content 数据
     * @param appKey
     * @return
     */
    public static String createSign(String content, String appKey) {
        if (!appKey.isEmpty()) {
            String sign1 = base64(MD5(content + appKey));
            logger.info("签名appKey Not Null：[{}]", sign1);
            return sign1;
        }
        String sign2 = base64(MD5(content + appKey));
        logger.info("签名appKey is Null：[{}]", sign2);
        return sign2;
    }

    /**
     * URLEncoder编码
     *
     * @param strData 数据
     * @return
     */
    public static String urlEncode(String strData) {
        try {
            String encode = URLEncoder.encode(strData, CHARSET);
            logger.info("encode编码：[{}]", encode);
            return encode;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * MD5加密
     *
     * @param strData 加密数据
     * @return
     */
    public static String MD5(String strData) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(strData.getBytes(CHARSET));
            byte[] digest = md5.digest();
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < digest.length; i++) {
                int var = digest[i] & 0XFF;
                if (var < 0Xf) {
                    builder.append("0");
                }
                builder.append(Integer.toHexString(var));
            }
            logger.info("md5加密：[{}]", builder.toString());
            return builder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * base64编码
     *
     * @param strData 数据
     * @return
     */
    public static String base64(String strData) {
        try {
            String base64 = Base64.encode(strData.getBytes(CHARSET));
            logger.info("base64编码：[{}]", base64);
            return base64;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * POST请求
     *
     * @param url    请求路径
     * @param params 请求参数
     * @return
     */
    public static String sendPost(String url, Map<String, String> params) {
        OutputStreamWriter out = null;
        BufferedReader in = null;
        StringBuilder result = new StringBuilder();
        try {
            URL sendUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) sendUrl.openConnection();
            //  发送post请求必须发送如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            //  发送post请求
            conn.setRequestMethod("POST");
            //   设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.connect();

            // 获取URLConnection对象对应的输出流
            out = new OutputStreamWriter(conn.getOutputStream(), CHARSET);
            // 发送请求参数
            if (params != null) {
                StringBuilder param = new StringBuilder();
                for (Map.Entry<String, String> stringEntry : params.entrySet()) {
                    if (param.length() > 0) {
                        param.append("&");
                    }
                    param.append(stringEntry.getKey());
                    param.append("=");
                    param.append(stringEntry.getValue());
                }
                out.write(param.toString());
            }
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), CHARSET));

            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    /**
     *   获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址;
     * @param request
     * @return
     */
    public static String getIpAddress(HttpServletRequest request){
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
                ip = request.getHeader("Proxy-Client-IP");
            }
            if (ip== null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if (ip== null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
                ip = request.getHeader("HTTP_CLIENT_IP");
            }
            if (ip== null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            }
            if (ip== null || ip.length() == 0|| "unknown".equalsIgnoreCase(ip)){
                ip = request.getRemoteAddr();
            }
        }else if(ip.length() > 15){
            String[] split = ip.split(",");
            for (int i = 0; i < split.length; i++) {
                if (!"unknown".equalsIgnoreCase(split[i])){
                    ip = split[i];
                    break;
                }
            }
        }
        return ip;
    }

}
