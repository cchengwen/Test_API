package com.api.test.map.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class MapServiceImpl {

    private RestTemplate restTemplate = new RestTemplate();

    private static final String MAP_AK = "TK4YpPx8Vi8XweKt6CHhcAi1puo6KIHQ";

    public String resultsList() {
        String url = "http://api.map.baidu.com/place/v2/search?query=ATM机&tag=银行&region=容县&output=json&ak="+MAP_AK;
        String forObject = restTemplate.getForObject(url, String.class);

//        String forObject = restTemplate.getForObject("http://192.168.1.156:8080/test", String.class);
        return forObject;

    }


}
