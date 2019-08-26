package com.api.test.kkl.service;

import com.api.test.kkl.pojo.Item;
import com.api.test.kkl.pojo.Kkl;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class KklServiceImpl {

    @Autowired
    private RestTemplate restTemplate;
    private static final String APPKEY = "xyy";
    private static final String APPSECRET = "bb986637211fe6f50a4542af21d35dca";
    private static final String URL = "https://dev.kklgo.com/xyytestapi/b2b/pushOrder";

    public JSONObject getKkl(String workNo) {
        List<Item> items = new ArrayList<>();
        Item item = new Item();
        item.setProductCode("SK555422");
        item.setProductName("利普空调");
        item.setProductSpec("KF-BB254111");
        item.setQty(2);
        items.add(item);

        Kkl kkl = new Kkl();
        kkl.setOrderNo("WK00"+workNo);
        kkl.setUserName("张三");
        kkl.setUserMobile("13156421345");
        kkl.setUserProvince("广东省");
        kkl.setUserCity("佛山市");
        kkl.setUserCounty("顺德区");
        kkl.setUserAddress("大良办事处");
        kkl.setServiceType("上门安装");
        kkl.setWarrantyType("保内");
        kkl.setShopId("11");
        kkl.setStatus(1L);
        kkl.setIssueBy("李四");
        kkl.setItems(items);

        JSONObject json = JSONObject.fromObject(kkl);
        System.out.println(json);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/json"));
        headers.add("appKey", "b2bTest");
        headers.add("appSecret", "cc03e747a6afbbcbf8be7668acfebee5");

        HttpEntity<Object> entity = new HttpEntity<>(json, headers);

        JSONObject jsonObject = restTemplate.postForObject(URL, entity, JSONObject.class);
        return jsonObject;
    }
}
