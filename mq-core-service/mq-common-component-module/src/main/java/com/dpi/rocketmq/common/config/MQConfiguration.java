package com.dpi.rocketmq.common.config;

import com.dpi.rocketmq.common.channel.PolledProcessorChannel;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

/**
 * @Package com.dpi.rocketmq.consume.config
 * @ClassName MQConfiguration
 * @Description TODO
 * @Author Ryan
 * @Date 2022/12/29
 */
@EnableBinding(PolledProcessorChannel.class)
@Configuration
public class MQConfiguration {
}
