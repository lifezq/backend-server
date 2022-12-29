package com.dpi.rocketmq.provider.service;

import com.dpi.rocketmq.provider.service.impl.ProducerMessageProviderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.support.MessageBuilder;

/**
 * @Package com.dpi.rocketmq.provider.service
 * @ClassName ProducerMessageProviderServiceTests
 * @Description TODO
 * @Author Ryan
 * @Date 2022/12/29
 */
@SpringBootTest(classes = {ProducerMessageProviderApplicationTest.class})
public class ProducerMessageProviderServiceTests {
    @Autowired
    private ProducerMessageProviderServiceImpl producerMessageProviderService;
    
    @Test
    public void testProducerMessageProvider() {
        producerMessageProviderService.producerMessageProvider(
                MessageBuilder.withPayload("test provider message").build());
    }
}
