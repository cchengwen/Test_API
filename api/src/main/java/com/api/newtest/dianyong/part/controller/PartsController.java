package com.api.newtest.dianyong.part.controller;

import com.alibaba.fastjson.JSON;
import com.api.newtest.ResponseResult;
import com.api.newtest.dianyong.part.pojo.PartsAPI;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/part")
public class PartsController {

    @PostMapping("/get")
    public ResponseResult getParts(@RequestBody String json){
        PartsAPI partsAPI = JSON.parseObject(json, PartsAPI.class);
        System.out.println(partsAPI);
        return ResponseResult.success("申请成功,等待客服审核", partsAPI.getOrder_number());
    }
}
