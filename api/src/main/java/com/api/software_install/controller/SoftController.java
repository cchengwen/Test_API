package com.api.software_install.controller;

import com.api.software_install.SourceData;
import com.api.software_install.service.SoftServiceImpl;
import com.api.util.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/software")
public class SoftController {

    @Autowired private SoftServiceImpl softService;

    @PostMapping("/update")
    public ResponseData soft(@RequestBody SourceData sourceData){
        System.out.println(sourceData);
        try {
            softService.soft(sourceData);
            return ResponseData.getSuccessMsg("修改成功", null);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return ResponseData.getError("修改失败");
        }

    }
}
