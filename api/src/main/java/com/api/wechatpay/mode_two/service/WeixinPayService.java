package com.api.wechatpay.mode_two.service;

import org.jdom.JDOMException;

import java.io.IOException;

public interface WeixinPayService {

    String weixinPay(String userId, String productId) throws JDOMException, IOException;
}
