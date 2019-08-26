package com.api.util.date;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间戳与日期格式字符串的互转
 */
public class TimeConver {

    private static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final String WEB_URL = "http://www.tianqi.com";

    /**
     * 时间戳转换成日期格式字符串
     *
     * @param timeStamp 时间戳
     * @param format    转换的格式， 如：yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String timeStampToDateStr(String timeStamp, String format) {
        if (timeStamp == null || timeStamp.isEmpty()) return "";
        if (format == null || format.isEmpty()) format = DEFAULT_FORMAT;
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(Long.valueOf(timeStamp + "000")));
    }


    /**
     *   时间 戳转 Date
     * @param timeStamp
     * @param format
     * @return
     */
    public static Date timeStampToDate(String timeStamp, String format){
        if (timeStamp == null || timeStamp.isEmpty()) return null;
        if (format == null || format.isEmpty()) format = DEFAULT_FORMAT;
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            return sdf.parse(timeStampToDateStr(timeStamp, format));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 日期格式字符串转换成时间戳
     *
     * @param dateStr 日期格式字符串
     * @param format  转换的格式， 如：yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String dateStrToTimeStamp(String dateStr, String format) {
        try {
            if (format == null || format.isEmpty()) format = DEFAULT_FORMAT;
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return String.valueOf(sdf.parse(dateStr).getTime() / 1000);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 日期格式转换成时间戳
     *
     * @param date   日期格式
     * @param format 转换的格式， 如：yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String dateToTimeStamp(Date date, String format) {
        if (date == null) date = getBJTime();
        try {
            if (format == null || format.isEmpty()) format = DEFAULT_FORMAT;
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return String.valueOf(sdf.parse(sdf.format(date)).getTime() / 1000);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 获取北京时间
     *
     * @return
     */
    public static Date getBJTime() {
        try {
            URLConnection con = new URL(WEB_URL).openConnection();
            con.connect();
//            SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_FORMAT);
            return new Date(con.getDate());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *   获取时长
     * @param startDate  开始日期时间
     * @return
     */
    public static String getTimeLength(Date startDate) {
        long date = (getBJTime().getTime() - startDate.getTime()) / (24 * 60 * 60 * 1000); // 天
        long hours = (getBJTime().getTime() - startDate.getTime()) / (60 * 60 * 1000) % 24; // 时
        if (date == 0 && hours == 0) return "";
        return date+"天"+hours+"小时";
    }


    /**
     * 获取当前时间戳
     *
     * @return
     */
    public static String getCurrentTimeStamp() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }


    public static void main(String[] args) throws ParseException {
//        System.out.println("时间戳转日期：" + timeStampToDate("1564021091", "yyyy-MM-dd HH:mm:ss"));
//        System.out.println("时间戳转日期：" + timeStampToDate("1564021091", "yyyy-MM-dd HH:mm"));
//        System.out.println("时间字符串转时间戳：" + dateStrToTimeStamp("2019-07-21 15:23:20", "yyyy-MM-dd HH:mm:ss"));
//        System.out.println("时间转时间戳：" + dateToTimeStamp(null, "yyyy-MM-dd HH:mm:ss"));
//        System.out.println("当前时间戳：" + getCurrentTimeStamp());

//        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_FORMAT);
//        String s = timeStampToDateStr("1559301473", null);
//        Date date = sdf.parse(s);
//        System.out.println(date);  //  2019-05-31 19:17:53

        Date date1 = timeStampToDate("1559301473", null);
        System.out.println(date1);


    }


}
