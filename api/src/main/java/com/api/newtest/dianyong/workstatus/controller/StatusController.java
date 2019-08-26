package com.api.newtest.dianyong.workstatus.controller;

import com.alibaba.fastjson.JSON;
import com.api.newtest.ResponseResult;
import com.api.newtest.dianyong.workstatus.pojo.StatusPush;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
public class StatusController {

    @PostMapping("/push")
    public ResponseResult pushStatus(@RequestBody String json){
        StatusPush statusPush = JSON.parseObject(json, StatusPush.class);
        System.out.println(statusPush);
        return ResponseResult.success("成功", statusPush.getOrder_number());
    }
}
