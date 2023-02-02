package com.dpi.rocketmq.consume;

import com.dpi.rocketmq.common.channel.PolledProcessorChannel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.support.MessageBuilder;

/**
 * @Package com.dpi.rocketmq.consume
 * @ClassName RocketmqConsumeApplicationTests
 * @Description TODO
 * @Author Ryan
 * @Date 2022/12/29
 */
@SpringBootTest
public class RocketmqConsumeApplicationTests {
    @Autowired
    private PolledProcessorChannel polledProcessorChannel;

    @Test
    public void testPolledProcessorChannel() {
        polledProcessorChannel.dest().send(
                MessageBuilder.withPayload("test consume message").build());
    }
}
