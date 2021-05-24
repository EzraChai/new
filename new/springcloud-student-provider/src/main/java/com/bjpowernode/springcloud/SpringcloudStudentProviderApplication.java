package com.bjpowernode.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients //开启Feign客户端调用支持
public class SpringcloudStudentProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudStudentProviderApplication.class, args);
    }

}
