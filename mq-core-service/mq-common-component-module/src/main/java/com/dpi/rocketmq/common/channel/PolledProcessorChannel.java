package com.dpi.rocketmq.common.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @Package com.dpi.rocketmq.consume.channel
 * @ClassName PolledProcessorChannel
 * @Description TODO
 * @Author Ryan
 * @Date 2022/12/29
 */
public interface PolledProcessorChannel {
    String dest = "output";
    String source = "input";

    @Input(source)
    SubscribableChannel source();

    @Output(dest)
    MessageChannel dest();
}
