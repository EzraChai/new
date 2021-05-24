package com.bjpowernode.springboot.api.service;

import com.bjpowernode.springboot.api.twilio.SmsRequest;
import com.bjpowernode.springboot.api.twilio.SmsSender;
import com.bjpowernode.springboot.api.twilio.impl.TwilioSmsSenderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@org.springframework.stereotype.Service
public class Service {

    private final SmsSender smsSender;

    @Autowired
    public Service(@Qualifier("twilio") TwilioSmsSenderImpl smsSender) {
        this.smsSender = smsSender;
    }

    public void SendSMS(SmsRequest smsRequest){
        smsSender.sendSms(smsRequest );
    }
}
