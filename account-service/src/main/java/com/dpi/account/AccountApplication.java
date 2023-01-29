package com.dpi.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * @Package com.dpi.account
 * @ClassName AccountApplication
 * @Description TODO
 * @Author Ryan
 * @Date 2023/1/16
 */
@ComponentScan(basePackages = {"com.dpi.common.*", "com.dpi.account.*"},
        excludeFilters = {
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = {com.dpi.common.config.SwaggerConfiguration.class})
        })
@SpringBootApplication
public class AccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
    }
}
