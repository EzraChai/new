package com.bjpowernode.springcloud.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @RequestMapping("/test")
    public String test(){
        return "使用了Zuul服务提供者";
    }
}
