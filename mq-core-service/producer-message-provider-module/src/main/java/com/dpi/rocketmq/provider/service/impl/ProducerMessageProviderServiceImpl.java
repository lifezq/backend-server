package com.dpi.rocketmq.provider.service.impl;

import com.dpi.rocketmq.common.channel.PolledProcessorChannel;
import com.dpi.rocketmq.provider.service.ProducerMessageProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

/**
 * @Package com.dpi.rocketmq.provider.service.impl
 * @ClassName ProducerMessageProviderServiceImpl
 * @Description TODO
 * @Author Ryan
 * @Date 2022/12/29
 */
@Service
public class ProducerMessageProviderServiceImpl implements ProducerMessageProviderService {
    @Autowired
    private PolledProcessorChannel polledProcessorChannel;

    @Override
    public void producerMessageProvider(Message message) {
        polledProcessorChannel.dest().send(message);
    }
}
