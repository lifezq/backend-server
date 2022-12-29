package com.dpi.software;

import com.dpi.rocketmq.provider.service.impl.ProducerMessageProviderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

/**
 * @Package com.dpi.software
 * @ClassName SoftwareMarketApplicationTests
 * @Description TODO
 * @Author Ryan
 * @Date 2022/12/28
 */
@SpringBootTest
public class SoftwareSupermarketApplicationTests {
    @Resource
    private ProducerMessageProviderServiceImpl producerMessageProviderService;

    @Test
    public void testSendMQMessage() {
        producerMessageProviderService.producerMessageProvider(
                MessageBuilder.withPayload("message from software supermarket").build());
    }
}
