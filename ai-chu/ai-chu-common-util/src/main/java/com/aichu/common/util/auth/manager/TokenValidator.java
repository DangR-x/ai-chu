package com.aichu.common.util.auth.manager;

/**
 * @ClassName TokenValidator
 * @Description Token的验证器
 * @Author Melon
 * @Date 2019/7/18 10:21
 * @Version 1.0.0
 **/
public interface TokenValidator {

    public boolean validate(String token);

}
