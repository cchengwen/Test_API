package com.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RestController {

    @GetMapping("/elect")
    public String electronIndex(){
        return "/tpls/kdniao/ele.html";
    }

    //   数据库安装
    @GetMapping("/soft")
    public String softwareInstall(){
        return "/tpls/software_install/datasource_install.html";
    }

    //  微信支付页面
    @GetMapping("/wxpay")
    public String wxpay(){
        return "/tpls/weixinpay/pay.html";
    }
}
