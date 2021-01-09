package com.bjpowernode.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "010-EUREKA-CLIENT-ZUUL-PROVIDER")
public interface TestService {

    @RequestMapping("/test")
    String test();
}
