package com.api.newtest.realizeapi.applyparts.service;

import com.alibaba.fastjson.JSON;
import com.api.newtest.realizeapi.applyparts.pojo.ApplyParts;
import com.api.newtest.realizeapi.applyparts.pojo.Parts;
import com.api.util.aes.AES;
import com.api.util.files.OnloadFiles;
import com.api.util.rsa.RSA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ApplyPartsService {

    @Autowired private OnloadFiles onloadFiles;

    public void applyParts() throws Exception {
        List<Parts> partsList = new ArrayList<>();
        Parts parts = new Parts();
        parts.setPart_name("");
        parts.setPart_price(66.0);
        parts.setPayer("");
        parts.setQuantity(2);
        parts.setReview_status(1);
        partsList.add(parts);

        ApplyParts applyParts = new ApplyParts();
        applyParts.setOrder_number("");
        applyParts.setExpress_company("");
        applyParts.setExpress_order("");
        applyParts.setNeed_return(1);
        applyParts.setPayment(1);
        applyParts.setTime("2019-08-19 22:00:00");
        applyParts.setParts(partsList);
        applyParts.setRemark("");

        //   转换为json字符串
        String json = JSON.toJSONString(applyParts);

        //  随机字符串
        String str = RSA.createStr();
        System.out.println("随机字符串："+str);

        //  RSA加密随机字符串
        String encStr = RSA.encrypt(str, RSA.getPublicKey(onloadFiles.getpublickey1()));
        System.out.println("字符加密串："+encStr);

        //  数据加密串
        String endata = AES.enctype(json, str);
        System.out.println("数据加密串："+endata);

    }

}
