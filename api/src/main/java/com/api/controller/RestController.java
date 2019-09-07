package com.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RestController {

    @GetMapping("/elect")
    public String electronIndex(){
        return "/tpls/kdniao/ele.html";
    }
}
