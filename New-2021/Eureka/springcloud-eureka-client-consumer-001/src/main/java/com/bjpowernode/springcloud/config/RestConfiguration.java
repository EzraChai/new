package com.bjpowernode.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfiguration {

    @LoadBalanced   //使用Ribbon负载均衡的调用
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
