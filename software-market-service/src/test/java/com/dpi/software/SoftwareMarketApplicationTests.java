package com.dpi.software;

import com.dpi.rocketmq.service.PolledProcessorService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;

/**
 * @Package com.dpi.software
 * @ClassName SoftwareMarketApplicationTests
 * @Description TODO
 * @Author Ryan
 * @Date 2022/12/28
 */
@EnableBinding(PolledProcessorService.class)
@SpringBootTest
public class SoftwareMarketApplicationTests {
    @Resource
    private PolledProcessorService polledProcessorService;

    @Test
    public void testSendMQMessage() {
        polledProcessorService.dest().send(MessageBuilder.withPayload("software message").build());
    }
}
