package com.bjpowernode.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    @LoadBalanced//标记当前标记的restTemplate使用Ribbon的负载均衡访问服务提供者
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
