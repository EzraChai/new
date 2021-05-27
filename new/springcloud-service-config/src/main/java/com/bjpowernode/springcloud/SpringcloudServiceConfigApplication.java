package com.bjpowernode.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class SpringcloudServiceConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudServiceConfigApplication.class, args);
    }

}
