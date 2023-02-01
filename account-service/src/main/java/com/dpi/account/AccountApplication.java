package com.dpi.account;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Package com.dpi.account
 * @ClassName AccountApplication
 * @Description TODO
 * @Author Ryan
 * @Date 2023/1/16
 */
@ComponentScan(basePackages = {"com.dpi.common.*", "com.dpi.account.*", "com.dpi.database.*"})
@MapperScan(basePackages = {"com.dpi.database.mapper.*"})
@SpringBootApplication
public class AccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
    }
}
