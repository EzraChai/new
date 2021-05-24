package com.bjpowernode.springboot.api.twilio;

public interface SmsSender {
    void sendSms(SmsRequest smsRequest);
}
