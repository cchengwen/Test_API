package com.api.wechatpay.mode_two.util;

import org.apache.commons.lang3.StringUtils;

import java.security.MessageDigest;

public class MD5Util {

    private static final String[] hexDigits = {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    public static String MD5Encode(String origin, String charsetName) {
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            if (charsetName.isEmpty() || StringUtils.isBlank(charsetName)) {
                resultString = byteArrayToHexString(md5.digest(resultString.getBytes()));
            }else {
                resultString = byteArrayToHexString(md5.digest(resultString.getBytes(charsetName)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultString;
    }

    /**
     *   字节数组转换成字符串
     * @param bytes  字节数组
     * @return
     */
    private static String byteArrayToHexString(byte[] bytes) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            sb.append(byteToHexString(bytes[i]));
        }
        return sb.toString();
    }

    /**
     *   十六进制转换为字符串
     * @param b
     * @return
     */
    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n += 256;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }


}
