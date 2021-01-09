package com.bjpowernode.springcloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatewayController {

    @RequestMapping("/api/local")
    public String test(){
        return "网关服务自己的控制类方法";
    }
}
