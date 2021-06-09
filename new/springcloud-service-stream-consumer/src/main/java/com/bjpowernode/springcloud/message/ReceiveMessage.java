package com.bjpowernode.springcloud.message;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;

import java.util.Date;

@EnableBinding(messageSink.class)
public class ReceiveMessage {

    @StreamListener(messageSink.INPUT)
    public void input(Message message){
        System.out.println("Message <"+message+"> Received at " + new Date());
    }
}
