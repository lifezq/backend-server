package com.dpi.software;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Package com.dpi.software
 * @ClassName SoftwareMarketApplication
 * @Description TODO
 * @Author Ryan
 * @Date 2022/12/27
 */
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.dpi.software.*", "com.dpi.common.*"})
@SpringBootApplication
public class SoftwareMarketApplication {
    public static void main(String[] args) {
        SpringApplication.run(SoftwareMarketApplication.class, args);
    }
}
