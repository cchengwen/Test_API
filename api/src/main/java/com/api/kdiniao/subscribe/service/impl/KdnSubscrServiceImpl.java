package com.api.kdiniao.subscribe.service.impl;

import com.alibaba.fastjson.JSON;
import com.api.kdiniao.electron.pojo.Commoditys;
import com.api.kdiniao.electron.pojo.eleorder.Receiver;
import com.api.kdiniao.electron.pojo.eleorder.Sender;
import com.api.kdiniao.kdutils.HttpUtils;
import com.api.kdiniao.subscribe.pojo.KdnSubcribe;
import com.api.kdiniao.subscribe.pojo.ResSubcriData;
import com.api.kdiniao.subscribe.service.KdnSubscrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KdnSubscrServiceImpl implements KdnSubscrService {

    @Autowired private HttpUtils httpUtils;

    @Override
    public ResSubcriData subGetOrder() {
        KdnSubcribe kdnSubcribe = new KdnSubcribe();
        kdnSubcribe.setOrderCode("EMS123456789");
        kdnSubcribe.setShipperCode("UC");
        kdnSubcribe.setPayType(1);
        kdnSubcribe.setMonthCode("755305452");
        kdnSubcribe.setExpType(1);
        kdnSubcribe.setCost(1.0);
        kdnSubcribe.setOtherCost(1.0);
        kdnSubcribe.setWeight(2.0);
        kdnSubcribe.setQuantity(1);
        kdnSubcribe.setVolume(0.0);
        kdnSubcribe.setRemark("加急");

        Sender sender = new Sender();
        sender.setName("张三");
        sender.setMobile("13988593612");
        sender.setProvinceName("上海");
        sender.setCityName("上海市");
        sender.setExpAreaName("青浦区");
        sender.setAddress("明珠路66666号");
        kdnSubcribe.setSender(sender);

        Receiver receiver = new Receiver();
        receiver.setName("李四");
        receiver.setMobile("13988599965");
        receiver.setProvinceName("云南省");
        receiver.setCityName("昆明市");
        receiver.setExpAreaName("大理镇");
        receiver.setAddress("卡卡路15号");
        kdnSubcribe.setReceiver(receiver);

        List<Commoditys> commoditysList = new ArrayList<>();
        Commoditys commoditys = new Commoditys();
        commoditys.setGoodsName("空调");
        commoditys.setGoodsPrice(99999.99);
        commoditys.setGoodsCode("KT221100555");
        commoditys.setGoodsWeight(8.8);
        commoditys.setGoodsquantity(1);
        commoditysList.add(commoditys);
        kdnSubcribe.setCommodity(commoditysList);

        System.out.println("参数："+kdnSubcribe);

//        String json = JSONObject.fromObject(kdnSubcribe).toString();
//        System.out.println(json);
        String json = "{\"WarehouseID\":\"9999999\",\"WarehouseAddress\":\"深圳市福田区福田保税区\",\"CallBack\":\"0000012\",\"MemberID\":\"123456\",\"ShipperCode\":\"ZTO\",\"LogisticCode\":\"1234561\",\"OrderCode\":\"1234561\",\"MonthCode\":\"\",\"PayType\":\"1\",\"ExpType\":\"1\",\"Cost\":12,\"OtherCost\":0,\"Receiver\":{\"Company\":\"腾讯科技\",\"Name\":\"张三\",\"Tel\":\"0755-0907283\",\"Mobile\":\"13709076789\",\"PostCode\":\"435100\",\"ProvinceName\":\"广东省\",\"CityName\":\"深圳市\",\"ExpAreaName\":\"福田区\",\"Address\":\"深南大道2009号\"},\"Sender\":{\"Company\":\"快金数据\",\"Name\":\"李四\",\"Tel\":\"0755-1111111\",\"Mobile\":\"13932080778\",\"PostCode\":\"435100\",\"ProvinceName\":\"广东省\",\"CityName\":\"深圳市\",\"ExpAreaName\":\"福田区\",\"Address\":\"福田保税区\"},\"StartDate\":\"\",\"EndDate\":\"\",\"Weight\":3,\"Quantity\":1,\"Volume\":2,\"Remark\":\"\",\"AddService\":[{\"Name\":\"\",\"Value\":\"\",\"CustomerID\":\"\"},{\"Name\":\"\",\"Value\":\"\",\"CustomerID\":\"\"},{\"Name\":\"\",\"Value\":\"\"}],\"Commodity\":[{\"GoodsName\":\"书本\",\"GoodsCode\":\"20398\",\"Goodsquantity\":1,\"GoodsPrice\":100,\"GoodsWeight\":2,\"GoodsVol\":10,\"GoodsDesc\":\"格林童话\"}]}";

        String postData = httpUtils.postData(json, "1001");
        System.out.println(postData);

        return JSON.parseObject(postData, ResSubcriData.class);
    }
}
