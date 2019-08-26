package com.api.newtest.realizeapi.workorder.service;

import com.alibaba.fastjson.JSON;
import com.api.newtest.realizeapi.workorder.pojo.CancelWork;
import com.api.newtest.realizeapi.workorder.pojo.CreateWork;
import com.api.newtest.realizeapi.workorder.pojo.Products;
import com.api.util.aes.AES;
import com.api.util.files.OnloadFiles;
import com.api.util.rsa.RSA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreateWorkService {

    @Autowired private RestTemplate restTemplate;
    @Autowired private OnloadFiles onloadFiles;

    //  批量下单
    public void pushOrder() throws Exception {
        jiamiParams(getParams());
    }


    //  修改工单
    public void updateWork() throws Exception {
        jiamiParams(getParams());
    }

    //  加密数据
    public void jiamiParams(Object object) throws Exception {
        // 转换成json串
        String json = JSON.toJSONString(object);

        //  随机字符串
        String str = RSA.createStr();
        System.out.println("随机字符串："+str);

        //  RSA加密随机串
        String enstr = RSA.encrypt(str, RSA.getPublicKey(onloadFiles.getpublickey1()));
        System.out.println("str加密串："+enstr);
        //  AES加密数据
        String encdata = AES.enctype(json, str);
        System.out.println("数据加密串："+encdata);
    }

    public CreateWork getParams(){
        //   产品信息
        List<Products> productsList = new ArrayList<>();
        Products products = new Products();
        products.setPro_code("KL0011221100");
        products.setPro_brand("美的");
        products.setPro_model("XH1221111");
        products.setPro_spec("BS00000");
        products.setQuantity(1);
        productsList.add(products);

        CreateWork createWork = new CreateWork();
        createWork.setName("张三");
        createWork.setPhone("13154515421");
        createWork.setAddress("广东省-佛山市-顺德区-街道办-00号");
        createWork.setOrder_number("WK201908191719253");
        createWork.setOrder_type(1);
        createWork.setWarranty_type(1);
        createWork.setService_level("加急");
        createWork.setRemark("");
        createWork.setProducts(productsList);
        return createWork;
    }


    //  取消工单
    public void cancelWork() throws Exception {
        CancelWork cancelWork = new CancelWork();
        cancelWork.setOrder_number("WK201908191736352");
        cancelWork.setRemark("超过规定时间未处理");
        jiamiParams(cancelWork);
    }


    //  催单
    public void cuidan() throws Exception {
        CancelWork cancelWork = new CancelWork();
        cancelWork.setOrder_number("WK201908191736352");
        jiamiParams(cancelWork);
    }

    //  取消工单接口
    public void canncelWork() throws Exception {
        CancelWork cancelWork = new CancelWork();
        cancelWork.setOrder_number("WK201908191736352");
        cancelWork.setRemark("长时间未处理，取消");
        jiamiParams(cancelWork);
    }
}
