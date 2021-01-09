package com.bjpwernode.springcloud.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/test")
    public String test(){
        ResponseEntity<String> result = restTemplate.getForEntity("http://004-EUREKA-CLUSTER-CLIENT-PROVIDER/test",String.class);
        String body = result.getBody();
        return "使用Eureka集群服务消费者------" + body;
    }
}
