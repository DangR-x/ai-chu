package com.aichu.common.util.auth.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName IgnoreAuthorization
 * @Description 接口授权验证忽略注解
 * @Author Melon
 * @Date 2019/7/19 10:15
 * @Version 1.0.0
 **/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IgnoreAuthorization {
}
