package com.bjpowernode.springboot.twilio;

public interface SmsSender {
    void sendSms(SmsRequest smsRequest);
}
