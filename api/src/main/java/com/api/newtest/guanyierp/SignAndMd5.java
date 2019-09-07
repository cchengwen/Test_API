package com.api.newtest.guanyierp;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 签名 & MD5加密
 */
public class SignAndMd5 {

    public static String sign(String json, String secret) {
        StringBuilder builder = new StringBuilder();
        builder.append(secret);
        builder.append(json);
        builder.append(secret);
        return encryptMD5(builder.toString());
    }

    /**
     *   MD5加密
     * @param data
     * @return
     */
    public static String encryptMD5(String data) {
        StringBuilder builder = new StringBuilder();
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] digest = md5.digest(data.getBytes("UTF-8"));
            for (int i = 0; i < digest.length; i++) {
                String toHexString = Integer.toHexString(digest[i] & 0xFF);
                if (toHexString.length() == 1){
                    builder.append("0");
                }
                builder.append(toHexString.toUpperCase());
            }
            return builder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
