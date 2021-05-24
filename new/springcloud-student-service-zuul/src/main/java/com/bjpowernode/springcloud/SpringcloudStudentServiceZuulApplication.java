package com.bjpowernode.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
//Zuul 网关
@EnableZuulProxy
public class SpringcloudStudentServiceZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudStudentServiceZuulApplication.class, args);
    }

}
