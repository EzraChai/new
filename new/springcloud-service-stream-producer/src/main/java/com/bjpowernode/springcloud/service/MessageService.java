package com.bjpowernode.springcloud.service;

import com.bjpowernode.springcloud.message.MessageSend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @Autowired
    private MessageSend messageSend;

    public void sendMessage(String message){
        System.out.println("------Service Started------");
        messageSend.publish(message);
        System.out.println("------Service Ended------");
    }
}
