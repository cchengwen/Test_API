package com.api.img;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/img")
public class ImgController {

    @GetMapping("/get")
    public String getImg(){
        return "/tpls/img/img.html";
    }
}
