package com.dpi.rocketmq.config;

import com.dpi.rocketmq.service.PolledProcessorService;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

/**
 * @Package com.dpi.rocketmq.config
 * @ClassName MQConfiguration
 * @Description TODO
 * @Author Ryan
 * @Date 2022/12/28
 */
@EnableBinding(PolledProcessorService.class)
@Configuration
public class MQConfiguration {
}
