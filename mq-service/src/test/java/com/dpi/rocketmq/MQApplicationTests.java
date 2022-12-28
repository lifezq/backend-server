package com.dpi.rocketmq;

import com.dpi.rocketmq.service.PolledProcessorService;
import org.apache.rocketmq.common.message.MessageConst;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * @Package com.dpi.rocketmq
 * @ClassName TestMQApplication
 * @Description TODO
 * @Author Ryan
 * @Date 2022/12/28
 */
@SpringBootTest
public class MQApplicationTests {
    @Autowired
    private PolledProcessorService output;

    @Test
    public void testSendMQMessage() {
        Map<String, Object> headers = new HashMap<>();
        headers.put(MessageConst.PROPERTY_TAGS, "tagStr");
        Message<String> message = MessageBuilder.createMessage("my mq msg.data", new MessageHeaders(headers));
        output.dest().send(message);
    }

    @Test
    public void testMessageChannel() {
        SubscribableChannel messageChannel = new DirectChannel();
        messageChannel.subscribe(
                message -> System.out.println("receive message:" + message.getPayload()));

        messageChannel.send(MessageBuilder.withPayload("my message data").build());
    }
}
