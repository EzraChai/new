package com.bjpowernode.springcloud.message;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

public interface messageSource {

    String OUTPUT = "myOutput";

    @Output(messageSource.OUTPUT)
    SubscribableChannel output();
}
