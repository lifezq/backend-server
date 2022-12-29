package com.dpi.rocketmq.consume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Package com.dpi.rocketmq.consume
 * @ClassName RocketmqConsumeApplication
 * @Description TODO
 * @Author Ryan
 * @Date 2022/12/29
 */
@ComponentScan(basePackages = {"com.dpi.rocketmq.common.*", "com.dpi.rocketmq.consume.*"})
@SpringBootApplication
public class RocketmqConsumeApplication {
    public static void main(String[] args) {
        SpringApplication.run(RocketmqConsumeApplication.class, args);
    }
}
