package com.api.test.map.controller;

import com.api.test.map.service.MapServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MapController {

   @Autowired private MapServiceImpl mapService;

    @RequestMapping("/get")
    public String getMap(){
        return mapService.resultsList();
    }

}
