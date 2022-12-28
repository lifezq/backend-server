package com.dpi.rocketmq.service;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

/**
 * @Package com.dpi.rocketmq.service
 * @ClassName RocketmqService
 * @Description TODO
 * @Author Ryan
 * @Date 2022/12/28
 */
@Service
public class RocketmqService {
    @StreamListener(PolledProcessorService.source)
    public void receiveInputMQMessage(String receivedMessage) {
        System.out.println("input receive msg:" + receivedMessage);
    }
}
