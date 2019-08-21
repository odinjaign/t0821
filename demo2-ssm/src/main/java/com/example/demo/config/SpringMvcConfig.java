package com.example.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * @author 蒋加济
 * @email jiangjj5@aisainfo.com
 * @date 2019/8/21 15:58
 */
@Configuration
@ComponentScan(
        basePackages = "com.example.demo",
        useDefaultFilters = false,
        includeFilters = {
                @ComponentScan.Filter(
                        type = FilterType.ANNOTATION,
                        classes = Controller.class
                )
        }
)
public class SpringMvcConfig {
}

/*
注意，如果不需要在 SpringMVC 中添加其他的额外配置，这样就可以了。
即 视图解析器、JSON 解析、文件上传……等等，如果都不需要配置的话，这样就可以了。
 */