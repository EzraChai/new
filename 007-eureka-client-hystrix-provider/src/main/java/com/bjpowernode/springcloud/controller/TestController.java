package com.bjpowernode.springcloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping("/test")
    public String test(){
        System.out.println(10/0);
        return "带有熔断机制的服务提供者";
    }

    @RequestMapping("/test02")
    public String test02(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "带有熔断机制的服务提供者延迟操作";
    }

    @RequestMapping("/test03")
    public String test03(){
        return "带有熔断机制的服务提供者延迟操作";
    }

    @RequestMapping("/test04")
    public String test04(){
        System.out.println(10/0);
        return "带有熔断机制的服务提供者test04";
    }
}
