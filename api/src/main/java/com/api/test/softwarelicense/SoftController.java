package com.api.test.softwarelicense;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SoftController {

    @RequestMapping("/soft")
    public String softLince(){
        return "tpls/softlince/soft.html";
    }
}
