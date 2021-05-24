package com.bjpowernode.springboot.api.web;

import com.bjpowernode.springboot.api.service.Service;
import com.bjpowernode.springboot.api.twilio.SmsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ApiController {

    private final Service service;

    @Autowired
    public ApiController(Service service) {
        this.service = service;
    }

    @RequestMapping("/user/login")
    @PostMapping()
    public void sendSMS(@Valid @RequestBody SmsRequest smsRequest){
        service.SendSMS(smsRequest);
    }
}
