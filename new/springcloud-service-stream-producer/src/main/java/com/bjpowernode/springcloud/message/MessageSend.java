package com.bjpowernode.springcloud.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;

import java.util.Date;

@EnableBinding(messageSource.class)
public class MessageSend {

    @Autowired
    private messageSource messageSource;

    public void publish(String message){
        //通过Channel 发送消息
        boolean send = messageSource.output().send(MessageBuilder.withPayload(message).build());
        if (send){
            System.out.println("Message <"+message+"> sent at "+ new Date() +"");
        }
    }
}
