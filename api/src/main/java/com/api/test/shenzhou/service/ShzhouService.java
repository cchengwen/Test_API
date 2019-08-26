package com.api.test.shenzhou.service;

import com.alibaba.fastjson.JSON;
import com.api.test.shenzhou.pojo.Data;
import com.api.test.shenzhou.pojo.Products;
import com.api.test.shenzhou.pojo.UserInfo;
import com.api.test.shenzhou.pojo.VerifyData;
import com.api.test.shenzhou.res.DataList;
import com.api.test.shenzhou.res.ShenZhouReturnData;
import com.api.util.aes.AES;
import com.api.util.code.Transcode;
import com.api.util.files.OnloadFiles;
import com.api.util.http.Httpclient;
import com.api.util.rsa.RSA;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShzhouService {

    @Autowired private RestTemplate restTemplate;
    @Autowired private OnloadFiles onloadFiles;

    @Value("${LianBaoUrl.ShenZhou}")
    private String SHENZHOU_URL;

    public ShenZhouReturnData shenzhou() throws Exception {
        Map map = new HashMap();

        //  产品信息
        List<Products> productsList = new ArrayList<>();
        Products products = new Products();
        products.setCategory_code("B9LyXPkD5ZQ");
        products.setStandard_code("x2yV1XZJkDN");
        products.setBrand_code("");
        products.setBrand_name("格力");
        products.setModel_code("");
        products.setModel_name("");
        products.setNums("1");
        productsList.add(products);

        // 用户信息
        UserInfo userInfo = new UserInfo();
        userInfo.setContact_type("1");
        userInfo.setContact_number("13712345612");
        userInfo.setContact_name("张三");
        userInfo.setAreas("天津市和平区");
        userInfo.setArea_detail("科技创新中心2座2104");

        //  data 参数
        List<Data> dataList = new ArrayList<>();
        Data data = new Data();
        data.setOut_trade_number("AB929u1412367807");
        data.setUser_info(userInfo);
        data.setProducts(productsList);
        dataList.add(data);

        //    外层对象
        VerifyData verifyData = new VerifyData();
        verifyData.setService_type("107");
        verifyData.setOrder_type("1");
        verifyData.setRemark("");
        verifyData.setData(dataList);

        //  把对象转换为 JSONObject 格式
        net.sf.json.JSONObject jsonObject = net.sf.json.JSONObject.fromObject(verifyData);

        //  生成随机字符串
        String str = RSA.createStr();
        System.out.println("随机字符串 == " + str);

        //   verify_key 加密
        String verify_key = RSA.encrypt(str, RSA.getPublicKey(onloadFiles.getpublickey1()));
        System.out.println("key ==  " + verify_key);

        //    数据加密
        String endata = AES.enctype(jsonObject.toString(), str);
        System.out.println("data == " + endata);

        map.put("verify_key", verify_key);
        map.put("verify_data", endata);
        map.put("platform_code", "XinYingYan@BGzd2NdyOK");
        System.out.println(map);

        ShenZhouReturnData returnData = restTemplate.postForObject(SHENZHOU_URL + "orders", map, ShenZhouReturnData.class);
//        String s = Httpclient.doPost(SHENZHOU_URL + "orders", map);
//        String s1 = Transcode.unicodeToString(s);
        return returnData;
    }



    public void getHttp() throws Exception {
        //  生成随机字符串
        String str = RSA.createStr();
        System.out.println("随机字符串 == " + str);

        //   verify_key 加密
        String verify_key = RSA.encrypt(str, RSA.getPublicKey(onloadFiles.getpublickey1()));
        System.out.println("verify_key ==  " + verify_key);

        //  把对象转换为 JSONObject 格式
        VerifyData verifyData = new VerifyData();
        net.sf.json.JSONObject jsonObject = net.sf.json.JSONObject.fromObject(verifyData);
        //    数据加密
        String endata = AES.enctype(jsonObject.toString(), str);
        System.out.println("verify_data == " + endata);
        //  url数据拼接
        String url = SHENZHOU_URL +"factory/categories?verify_key="+verify_key+"&verify_data="+endata+"&platform_code=XinYingYan@BGzd2NdyOK";
        //  请求接口
        String json = Httpclient.doGetJson(Httpclient.urlEncode(url));
        System.out.println(json);
//        ShenZhouReturnData data = JSON.parseObject(json, ShenZhouReturnData.class);
//        List<DataList> data_list = data.getData().getData_list();
//        for (DataList dataList : data_list) {
//            System.out.println(dataList);
//        }
    }



}
