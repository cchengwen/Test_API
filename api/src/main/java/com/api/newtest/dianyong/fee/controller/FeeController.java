package com.api.newtest.dianyong.fee.controller;

import com.alibaba.fastjson.JSON;
import com.api.newtest.ResponseResult;
import com.api.newtest.dianyong.fee.pojo.ApplyFee;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fee")
public class FeeController {

    @PostMapping("/get")
    public ResponseResult applyFee(@RequestBody String json){
        ApplyFee applyFee = JSON.parseObject(json, ApplyFee.class);
        System.out.println(applyFee);
        return ResponseResult.success("申请成功，等待审核", null);
    }
}
