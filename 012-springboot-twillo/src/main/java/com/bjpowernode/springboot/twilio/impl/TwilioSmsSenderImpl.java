package com.bjpowernode.springboot.twilio.impl;

import com.bjpowernode.springboot.config.TwilioConfiguration;
import com.bjpowernode.springboot.twilio.SmsRequest;
import com.bjpowernode.springboot.twilio.SmsSender;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service("twilio")
public class TwilioSmsSenderImpl implements SmsSender {

    private final TwilioConfiguration twilioConfiguration;

    private final static Logger LOGGER = LoggerFactory.getLogger(TwilioSmsSenderImpl.class);

    @Autowired
    public TwilioSmsSenderImpl(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
    }


    @Override
    public void sendSms(SmsRequest smsRequest) {
        if (isPhoneNumberValid(smsRequest.getPhoneNumber())) {
            PhoneNumber to = new PhoneNumber(smsRequest.getPhoneNumber());
            PhoneNumber from = new PhoneNumber(twilioConfiguration.getTrialNumber());
            String message = smsRequest.getMessage();
            MessageCreator creator = Message.creator(to, from, message);
            creator.create();
            LOGGER.info("Sent SMS {}" , smsRequest);
        } else {
            throw new IllegalArgumentException("Phone Number [" + smsRequest.getPhoneNumber() + "] Invalid");
            
        }
    }

    private boolean isPhoneNumberValid(String phoneNumber) {
        Pattern pattern = Pattern.compile("^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$");
        Matcher matcher = pattern.matcher(phoneNumber);
        boolean matches = matcher.matches();
        return matches;
    }
}
