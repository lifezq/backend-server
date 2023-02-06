package com.dpi.software;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Package com.dpi.software
 * @ClassName SoftwareMarketApplication
 * @Description TODO
 * @Author Ryan
 * @Date 2022/12/29
 */
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.dpi.common.*", "com.dpi.database.*", "com.dpi.software.*"})
@MapperScan(basePackages = {"com.dpi.database.mapper.*"})
@SpringBootApplication
public class SoftwareSupermarketApplication {
    public static void main(String[] args) {
        SpringApplication.run(SoftwareSupermarketApplication.class, args);
    }
}