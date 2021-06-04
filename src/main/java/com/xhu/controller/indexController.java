package com.xhu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class indexController {

    @RequestMapping("/admin/welcome")
    public String welcome(){
        return "admin/welcome";
    }
}
