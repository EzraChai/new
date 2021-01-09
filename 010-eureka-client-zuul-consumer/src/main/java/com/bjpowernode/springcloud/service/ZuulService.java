package com.bjpowernode.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "010-EUREKA-CLIENT-ZUUL-GATEWAY")
public interface ZuulService {

    @RequestMapping("/api-zuul/test?token=123")
    String test(String token);
}
