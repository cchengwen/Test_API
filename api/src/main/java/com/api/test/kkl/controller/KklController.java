package com.api.test.kkl.controller;

import com.api.test.kkl.service.KklServiceImpl;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kkl")
public class KklController {

    @Autowired private KklServiceImpl kklService;

    @GetMapping("/get")
    public JSONObject get(String workNo){
        return kklService.getKkl(workNo);
    }
}
