package com.api;

import com.api.wechatpay.mode_two.service.WeixinPayService;
import org.jdom.JDOMException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WechatPayTest {

    @Autowired private WeixinPayService weixinPayService;

    @Test
    public void test() throws JDOMException, IOException {
        weixinPayService.weixinPay("225511", "333");
    }
}
