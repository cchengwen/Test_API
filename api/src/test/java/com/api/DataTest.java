package com.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.api.util.date.TimeConver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataTest {

    @Test
    public void test1(){
        String json = "{\n" +
                "    \"data\":[\n" +
                "        {\n" +
                "            \"order_number\":\"QWE123456\",\n" +
                "            \"warranty_number\":\"197255855663669\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"order_number\":\"QYQ123456\",\n" +
                "            \"warranty_number\":\"192655224663669\"\n" +
                "        },\n" +
                "    ]\n" +
                "}";
        JSONObject object = JSONObject.parseObject(json);
        System.out.println(object);
        JSONArray data = object.getJSONArray("data");
        for (int i = 0; i < data.size(); i++) {
            String order_number = data.getJSONObject(i).getString("order_number");
            String warranty_number = data.getJSONObject(i).getString("warranty_number");
            System.out.println(order_number+" , "+warranty_number);
        }
    }
}
