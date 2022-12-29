package com.dpi.rocketmq.consume.service;

import com.dpi.rocketmq.common.channel.PolledProcessorChannel;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

/**
 * @Package com.dpi.rocketmq.consume.service
 * @ClassName RocketmqConsumeService
 * @Description TODO
 * @Author Ryan
 * @Date 2022/12/29
 */
@Service
public class RocketmqConsumeService {
    @StreamListener(PolledProcessorChannel.source)
    public void receiveInputMQMessage(String receivedMessage) {
        System.out.println("input receive msg:" + receivedMessage);
    }
}
