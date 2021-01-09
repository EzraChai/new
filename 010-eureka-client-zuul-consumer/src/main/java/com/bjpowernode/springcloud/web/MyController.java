package com.bjpowernode.springcloud.web;

import com.bjpowernode.springcloud.service.TestService;
import com.bjpowernode.springcloud.service.ZuulService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MyController {

    @Resource
    private TestService testService;

    @Resource
    private ZuulService zuulService;

    @GetMapping("/test")
    public String test(){
        return testService.test();
    }

    @RequestMapping("/test02")
    public String test02(String token){
        return "经过Zuul网关的消费者 -- " + zuulService.test(token);
    }
}
