package com.bjpowernode.springcloud;

import com.bjpowernode.springcloud.service.MessageService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringcloudServiceStreamApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringcloudServiceStreamApplication.class, args);
        MessageService messageService = (MessageService) run.getBean("messageService");
        messageService.sendMessage("I love no one");
    }

}
