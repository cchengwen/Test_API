package com.api.util.code;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 编码转换类
 */
public class Transcode {

    /**
     * 汉字字符串与unicode之间的转换
     *
     * @param str
     * @return
     */
    public static String stringToUnicode(String str) {
        StringBuffer sb = new StringBuffer();
        try {
            //   直接获取字符串的unicode的二进制
            byte[] bytes = str.getBytes("unicode");

            //   然后将其 bytes 转换成对应的16进制
            for (int i = 0; i < bytes.length - 1; i += 2) {
                sb.append("\\u");
                String s = Integer.toHexString(bytes[i + 1] & 0xFF);
                for (int j = s.length(); j < 2; j++) {
                    sb.append("0");
                }
                String s1 = Integer.toHexString(bytes[i] & 0xFF);
                sb.append(s1);
                sb.append(s);
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * Unicode转 汉字字符串
     *
     * @param unicode
     * @return
     */
    public static String unicodeToString(String unicode) {
        Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");
        Matcher matcher = pattern.matcher(unicode);
        char ch;
        while (matcher.find()) {
            String group = matcher.group(2);
            ch = (char) Integer.parseInt(group, 16);
            String s = matcher.group(1);
            unicode = unicode.replace(s, ch + "");
        }
        return unicode;
    }







    public static void main(String[] args) {
        //  汉字字符串与unicode之间的转换
        String s = stringToUnicode("水");
        System.out.println(s);

        //   Unicode转 汉字字符串
        String s1 = unicodeToString("\\u8BFB\\u53D6\\u6587\\u4EF6");
        System.out.println(s1);
    }
}
