package com.aichu.admin.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName OperationLog
 * @Author yuan.shuai
 * @Description 自定义操作日志注解类
 * @Date 2019/10/31
 * @Version 1.0.0
 */
@Target(ElementType.METHOD) // 注解目标：方法级别
@Retention(RetentionPolicy.RUNTIME) // 注解运行时间
public @interface OperationLog {
    String value() default "";
}
