package com.dpi.account.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Package com.dpi.account.config
 * @ClassName WebConfiguration
 * @Description TODO
 * @Author Ryan
 * @Date 2023/1/18
 */
@Configuration
public class WebConfiguration {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
