package com.bjpwernode.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ClusterConsumer {

    public static void main(String[] args) {
        SpringApplication.run(ClusterConsumer.class, args);
    }

}
