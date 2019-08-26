package com.api.test.shenzhou.controller;

import com.api.test.shenzhou.res.ShenZhouReturnData;
import com.api.test.shenzhou.service.ShzhouService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shenzhou")
public class ShzhouController {

    @Autowired
    private ShzhouService shzhouService;

    @RequestMapping("/get")
    public ShenZhouReturnData responseData() {
        try {
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
