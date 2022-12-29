package com.dpi.rocketmq.provider.service;

import org.springframework.messaging.Message;

/**
 * @Package com.dpi.rocketmq.provider.service
 * @ClassName ProducerMessageProviderService
 * @Description TODO
 * @Author Ryan
 * @Date 2022/12/29
 */
public interface ProducerMessageProviderService {
    void producerMessageProvider(Message message);
}
