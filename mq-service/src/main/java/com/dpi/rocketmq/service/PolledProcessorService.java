package com.dpi.rocketmq.service;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @Package service
 * @ClassName PolledProcessorService
 * @Description TODO
 * @Author Ryan
 * @Date 2022/12/28
 */
public interface PolledProcessorService {
    String dest = "output";
    String source = "input";

    @Input(source)
    SubscribableChannel source();

    @Output(dest)
    MessageChannel dest();
}
