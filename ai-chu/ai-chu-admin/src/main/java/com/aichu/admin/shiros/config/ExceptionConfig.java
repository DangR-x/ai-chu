package com.aichu.admin.shiros.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Properties;

/**
 * @ClassName ExceptionConfig
 * @Author yuan.shuai
 * @Description 配置Shiro未授权跳转
 * @Date 2019/7/17
 * @Version 1.0.0
 */
@Configuration
public class ExceptionConfig {

    /**
     * @Description 定义无权限跳转地址
     * @Return SimpleMappingExceptionResolver
     * @Author yuan.shuai
     * @Date  2019/7/17
     */
    @Bean
    public SimpleMappingExceptionResolver resolver(){
        SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
        Properties properties = new Properties();
        properties.setProperty("org.apache.shiro.authz.UnauthorizedException","/404");
        resolver.setExceptionMappings(properties);
        return resolver;
    }
}
