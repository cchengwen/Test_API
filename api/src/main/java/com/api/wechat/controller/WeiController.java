package com.api.wechat.controller;

import com.api.util.http.Httpclient;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.UUID;

@Controller
@RequestMapping("/wei")
public class WeiController {
    //  点击微信扫码登录连接
    private static final String WECHAT_URL_LOGIN = "https://open.weixin.qq.com/connect/qrconnect?";
    //  用户授权后，此连接获取 token
    private static final String WECHAT_URL_AUTHORI = "https://api.weixin.qq.com/sns/oauth2/access_token?";

    private static final String APPID = "wx7a5ab729c84a0c99";
    private static final String APPSECRET = "98e41580ac7bb50381d1ea967ff13fe9";
    private static final String REDIRECT_URI = "http://crm.xyingyan.com.cn";

    // 1、 用户点击“微信登录”，这时会向第三方（我方）后台发请求，后台要准备参数如下：
    //  1.1、 appid: 微信平台申请获得
    //  1.2、 redirect_uri  回调域名，
    //  1.3、 scope ?
    //  1.4、 state：防止csrf攻击，后台自动生成
    //以上参数正确后，会重定向到二唯码页面（有待实验确认证实？）
    @RequestMapping("/get")
    public String openWechatLogin() {
        String state = UUID.randomUUID().toString().replace("-", "");
        String param = "appid=" + APPID +
                "&redirect_uri=" + URLEncoder.encode(REDIRECT_URI) +
                "&response_type=code" +
                "&scope=snsapi_userinfo" +
                "&state=" + state +
                "#wechat_redirect";
        System.out.println(WECHAT_URL_LOGIN + param);
        return "redirect:" + WECHAT_URL_LOGIN + param;

    }

    @RequestMapping("/callback")
    public String wechatCallBack(HttpServletRequest request, Model model){
        String code = request.getParameter("code");
        String state = request.getParameter("state");

//        if (StringUtils.isEmpty(code)){
//            System.out.println("code　is null, 为非法参数！");
//            return "code　is null, 为非法参数";
//        }
//        String param = "appid="+APPID +
//                "&secret="+APPSECRET +
//                "&code="+code +
//                "&grant_type=authorization_code";
//
//        JSONObject jsonObject = Httpclient.doGetJson(WECHAT_URL_AUTHORI + param);
//        System.out.println(jsonObject);
//        if (jsonObject.get("errcode") != null){
//            System.out.println("获取 token失败！");
//            return "获取 token失败！";
//        }

        return null;
    }

//    //   授权登录后
//    @RequestMapping("/login")
//    public void WechatLogin(HttpServletRequest request, HttpServletResponse response) {
//        String state = request.getParameter("state");
//        String param = "appid=" + APPID +
//                "&redirect_uri=" + URLEncoder.encode(REDIRECT_URI) +
//                "&response_type=code" +
//                "&scope=snsapi_userinfo" +
//                "&state=" + state +
//                "#wechat_redirect";
//
//        try {
//            System.out.println(WECHAT_URL + param);
//            response.sendRedirect(WECHAT_URL + param);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }



}
