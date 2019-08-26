package com.api.newtest.dianyong.workfinish.controller;

import com.alibaba.fastjson.JSON;
import com.api.newtest.ResponseResult;
import com.api.newtest.dianyong.workfinish.pojo.ApplyWorkFinish;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/finish")
public class workFinishController {

    @RequestMapping("/finish")
    public ResponseResult workFinish(@RequestBody String json){
        ApplyWorkFinish workFinish = JSON.parseObject(json, ApplyWorkFinish.class);
        System.out.println(workFinish);
        return ResponseResult.success("成功", workFinish.getOrder_number());
    }

}
