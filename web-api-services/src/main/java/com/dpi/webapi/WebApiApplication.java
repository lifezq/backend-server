package com.dpi.webapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Package com.dpi.webapi
 * @ClassName WebApi2Application
 * @Description TODO
 * @Author Ryan
 * @Date 12/31/2022
 */
@EnableTransactionManagement
@MapperScan(basePackages = {"com.dpi.webapi.mapper.*"})
@ComponentScan(basePackages = {"com.dpi.common.*", "com.dpi.webapi.*"})
@SpringBootApplication
public class WebApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApiApplication.class, args);
    }
}
