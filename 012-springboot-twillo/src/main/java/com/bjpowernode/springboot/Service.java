package com.bjpowernode.springboot;

import com.bjpowernode.springboot.twilio.SmsRequest;
import com.bjpowernode.springboot.twilio.SmsSender;
import com.bjpowernode.springboot.twilio.impl.TwilioSmsSenderImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

@org.springframework.stereotype.Service
public class Service {

    @Resource
    private RedisTemplate redisTemplate;

    private final SmsSender smsSender;

    @Autowired
    public Service(@Qualifier("twilio") TwilioSmsSenderImpl smsSender) {
        this.smsSender = smsSender;
    }

    public void SendSMS(SmsRequest smsRequest){
        smsSender.sendSms(smsRequest );
    }

    public void storeAuthCode(String phoneNumber, Integer authCode){
        redisTemplate.opsForHash().put(" AuthCode " ,phoneNumber,authCode);
    }
}
