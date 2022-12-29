package com.dpi.rocketmq.provider.service;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Package com.dpi.rocketmq.provider.service
 * @ClassName ProducerMessageProviderApplicationTest
 * @Description TODO
 * @Author Ryan
 * @Date 2022/12/29
 */
@ComponentScan(basePackages = {"com.dpi.rocketmq.common.*", "com.dpi.rocketmq.provider.*"})
@SpringBootApplication
public class ProducerMessageProviderApplicationTest {
}
