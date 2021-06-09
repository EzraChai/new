package com.bjpowernode.springcloud.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface messageSink {

    String INPUT = "myInput";

    @Input(messageSink.INPUT)
    SubscribableChannel input();
}
