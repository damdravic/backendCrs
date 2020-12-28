package com.ddv.backendCrs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexControllers {


    @RequestMapping(value = {"/","/index","home"})
    public String index(){
        return "index";
    }


}
