package com.aichu.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Arrays;

@SpringBootApplication
@EnableScheduling
@EnableConfigurationProperties
@MapperScan("com.aichu.dao.*.mapper")
@ComponentScan({"com.aichu.service.api","com.aichu.app","com.aichu.common.util","com.aichu.manager"})
public class AiChuAppApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext =  SpringApplication.run(AiChuAppApplication.class, args);

        String[] profiles = applicationContext.getEnvironment().getActiveProfiles();
        String port = applicationContext.getEnvironment().getProperty("server.port");
        System.out.println("当前启动的环境是： " + Arrays.toString(profiles));
        System.out.println("-----------------");
        System.out.println("-----------------");
        System.out.println("-----------------");
        System.out.println("-----------------");
        System.out.println("系统启动成功，点击：http://127.0.0.1:" + port + "/swagger-ui.html 访问API列表");
    }
}
