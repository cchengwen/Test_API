package com.api.util.softwarelic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    //   当前时间
    public static String currenttime = format.format(new Date());

    //   验证日期
    public static boolean authorize_date(String date) {
        if (compare_date(currenttime, date) == 1 || compare_date(currenttime, date) == 0) {
            return true;
        }
        return false;
    }

    //   比较日期
    private static int compare_date(String data1, String data2) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date d1 = df.parse(data1);
            Date d2 = df.parse(data2);
            if (d1.getTime() > d2.getTime()) {
                return 1;
            } else if (d1.getTime() < d2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }


















    public static void main(String[] args) {
        boolean b = authorize_date("2018-07-24 20:00:59");
        System.out.println(b);
    }
}
