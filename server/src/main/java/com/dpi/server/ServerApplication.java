package com.dpi.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

/**
 * @Package com.dpi.server
 * @ClassName ServerApplication
 * @Description TODO
 * @Author Ryan
 * @Date 2022/12/22
 */
@MapperScan(basePackages = {"com.dpi.server.mapper.*"})
@SpringBootApplication
@RestController
public class ServerApplication {
    @Autowired
    private Environment environment;


    @GetMapping("server")
    @RolesAllowed("myrealm-user")
    @ResponseBody
    public String hello() {
        return "Hello..." + environment.getProperty("server.port");
    }

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }
}
