package com.example.demo.config;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.nio.charset.Charset;
import java.util.List;

/**
 * @author 蒋加济
 * @email jiangjj5@aisainfo.com
 * @date 2019/8/21 15:58
 */
@Configuration
@ComponentScan(basePackages = "com.example.demo")
public class SpringMvcConfig extends WebMvcConfigurationSupport {

    //<mvc:resources mapping="/**" location="/"/>
    //静态资源解析器
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/");
    }

    //<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
    //    <property name="prefix" value="/WEB-INF/jsp/"/>
    //    <property name="suffix" value=".jsp"/>
    //</bean>
    //视图解析器
    @Override
    protected void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/jsp/",".jsp");
    }

    //<mvc:view-controller path="/hello" view-name="hello" status-code="200"/>
    //这行配置，表示如果用户访问 /hello 这个路径，则直接将名为 hello 的视图返回给用户，
    //并且响应码为 200，这个配置就可以替代 Controller 中的方法。
    //路径映射
    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/hello3").setViewName("hello");
    }

    //<mvc:annotation-driven>
    //    <mvc:message-converters>
    //        <bean class="com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter">
    //        </bean>
    //    </mvc:message-converters>
    //</mvc:annotation-driven>
    //JSON配置
    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        converter.setDefaultCharset(Charset.forName("UTF-8"));
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setCharset(Charset.forName("UTF-8"));
        converter.setFastJsonConfig(fastJsonConfig);
        converters.add(converter);
    }
}

/*
注意，如果不需要在 SpringMVC 中添加其他的额外配置，这样就可以了。
即 视图解析器、JSON 解析、文件上传……等等，如果都不需要配置的话，这样就可以了。
 */



