package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 蒋加济
 * @email jiangjj5@aisainfo.com
 * @date 2019/8/21 10:55
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public Docket buildDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(null)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.demo.com.example.demo.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo buildApiInf() {
        return new ApiInfoBuilder()
                .title("系统RESTful API文档")
                .contact(new Contact("jaign", "https://jagin.site", "jagin@outlook.com"))
                .version("1.0")
                .build();
    }

}
