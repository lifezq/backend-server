package com.dpi.developer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Package com.dpi.developer
 * @ClassName DeveloperCenterApplication
 * @Description TODO
 * @Author Ryan
 * @Date 2022/12/29
 */
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.dpi.common.*", "com.dpi.developer.*"})
@SpringBootApplication
public class DeveloperCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(DeveloperCenterApplication.class, args);
    }
}
