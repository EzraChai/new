package com.bjpowernode.springboot.web;

import com.bjpowernode.springboot.Service;
import com.bjpowernode.springboot.twilio.SmsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/api/v1/sms")
public class WebController {

    private final Service service;

    @Autowired
    public WebController(Service service) {
        this.service = service;
    }

    @PostMapping()
    public void sendSMS(@Valid @RequestBody SmsRequest smsRequest){
        service.SendSMS(smsRequest);
    }
}
