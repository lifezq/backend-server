package com.dpi.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

/**
 * @Package com.dpi.web.config
 * @ClassName SwaggerConfig
 * @Description TODO
 * @Author Ryan
 * @Date 2022/12/26
 */
@Configuration
public class SwaggerConfig {

    private ApiInfo apiInfo() {
        return new ApiInfo("Web 服务接口文档 Rest APIs",
                "APIs for Web 服务接口文档.",
                "1.0",
                "Web 服务接口",
                new Contact("DPI", "www.dpi.com", "dpi@deltaphone.com"),
                "License of API",
                "API license URL",
                Collections.emptyList());
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }
}
