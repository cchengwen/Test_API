package com.api.binfatest.xiancheng.controller;

import com.api.binfatest.xiancheng.service.XcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired private XcService xcService;

    @GetMapping("xc")
    public String get(){
        return xcService.adds();
    }
}
