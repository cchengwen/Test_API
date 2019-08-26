package com.api.test.shenzhou.service;

import com.alibaba.fastjson.JSON;
import com.api.test.shenzhou.res.ShenZhouReturnData;

public class ShenTestMain {
    static String json = "{\n" +
            "  \"error_code\": 1,\n" +
            "  \"error_msg\": \"\",\n" +
            "  \"data\": {\n" +
            "    \"data_list\": [\n" +
            "      {\n" +
            "        \"code\": \"376vW3bKl85\",\n" +
            "        \"name\": \"BCD249EMA\",\n" +
            "        \"category_code\": \"a7EydP2L57Y\",\n" +
            "        \"standard_code\": \"wlnz4QkJovG\",\n" +
            "        \"brand_code\": \"96oPbw1K0qz\",\n" +
            "        \"category_name\": \"新飞家用冰箱、冰柜\",\n" +
            "        \"standard_name\": \"容积>250L\",\n" +
            "        \"brand_name\": \"新飞\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"code\": \"nM915a4K9gv\",\n" +
            "        \"name\": \"BCD193G\",\n" +
            "        \"category_code\": \"a7EydP2L57Y\",\n" +
            "        \"standard_code\": \"wlnz4QkJovG\",\n" +
            "        \"brand_code\": \"96oPbw1K0qz\",\n" +
            "        \"category_name\": \"新飞家用冰箱、冰柜\",\n" +
            "        \"standard_name\": \"容积>250L\",\n" +
            "        \"brand_name\": \"新飞\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"code\": \"nM60QX4El1q\",\n" +
            "        \"name\": \"BCD189VC\",\n" +
            "        \"category_code\": \"a7EydP2L57Y\",\n" +
            "        \"standard_code\": \"wlnz4QkJovG\",\n" +
            "        \"brand_code\": \"96oPbw1K0qz\",\n" +
            "        \"category_name\": \"新飞家用冰箱、冰柜\",\n" +
            "        \"standard_name\": \"容积>250L\",\n" +
            "        \"brand_name\": \"新飞\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"code\": \"nq9K5rLRlD2\",\n" +
            "        \"name\": \"BCD128QLKT2C\",\n" +
            "        \"category_code\": \"a7EydP2L57Y\",\n" +
            "        \"standard_code\": \"wlnz4QkJovG\",\n" +
            "        \"brand_code\": \"96oPbw1K0qz\",\n" +
            "        \"category_name\": \"新飞家用冰箱、冰柜\",\n" +
            "        \"standard_name\": \"容积>250L\",\n" +
            "        \"brand_name\": \"新飞\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"code\": \"anl3ZQ456zk\",\n" +
            "        \"name\": \"BCD177CHBY\",\n" +
            "        \"category_code\": \"a7EydP2L57Y\",\n" +
            "        \"standard_code\": \"wlnz4QkJovG\",\n" +
            "        \"brand_code\": \"96oPbw1K0qz\",\n" +
            "        \"category_name\": \"新飞家用冰箱、冰柜\",\n" +
            "        \"standard_name\": \"容积>250L\",\n" +
            "        \"brand_name\": \"新飞\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"code\": \"eq6BJex363Y\",\n" +
            "        \"name\": \"BCD182TD\",\n" +
            "        \"category_code\": \"a7EydP2L57Y\",\n" +
            "        \"standard_code\": \"wlnz4QkJovG\",\n" +
            "        \"brand_code\": \"96oPbw1K0qz\",\n" +
            "        \"category_name\": \"新飞家用冰箱、冰柜\",\n" +
            "        \"standard_name\": \"容积>250L\",\n" +
            "        \"brand_name\": \"新飞\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"code\": \"bxNqdVprlB5\",\n" +
            "        \"name\": \"BCD197CHZ\",\n" +
            "        \"category_code\": \"a7EydP2L57Y\",\n" +
            "        \"standard_code\": \"wlnz4QkJovG\",\n" +
            "        \"brand_code\": \"96oPbw1K0qz\",\n" +
            "        \"category_name\": \"新飞家用冰箱、冰柜\",\n" +
            "        \"standard_name\": \"容积>250L\",\n" +
            "        \"brand_name\": \"新飞\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"code\": \"Qq65ZRAwlvR\",\n" +
            "        \"name\": \"BCD126DA\",\n" +
            "        \"category_code\": \"a7EydP2L57Y\",\n" +
            "        \"standard_code\": \"wlnz4QkJovG\",\n" +
            "        \"brand_code\": \"96oPbw1K0qz\",\n" +
            "        \"category_name\": \"新飞家用冰箱、冰柜\",\n" +
            "        \"standard_name\": \"容积>250L\",\n" +
            "        \"brand_name\": \"新飞\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"code\": \"wjNQMXOaN1K\",\n" +
            "        \"name\": \"BCD560WKSR9A\",\n" +
            "        \"category_code\": \"a7EydP2L57Y\",\n" +
            "        \"standard_code\": \"6rdVm05JLbo\",\n" +
            "        \"brand_code\": \"96oPbw1K0qz\",\n" +
            "        \"category_name\": \"新飞家用冰箱、冰柜\",\n" +
            "        \"standard_name\": \" 容积≤250L\",\n" +
            "        \"brand_name\": \"新飞\"\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "}";

    public static void main(String[] args) {
        ShenZhouReturnData s = JSON.parseObject(json, ShenZhouReturnData.class);
        System.out.println(s);

    }
}
