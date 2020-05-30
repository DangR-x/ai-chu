package com.aichu.app.authorization.jwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName JwtConfig
 * @Description JWT初始化工具类
 * @Author Melon
 * @Date 2019/7/18 9:41
 * @Version 1.0.0
 **/
@Configuration
public class JwtConfig {

    @Value("${jwt.base64Secret}")
    private String base64Secret;

    @Value("${jwt.refreshBase64Secret}")
    private String refreshBase64Secret;

    @Value("${jwt.expiresSecond}")
    private long expiresSecond;

    @Value("${jwt.refreshExpiresSecond}")
    private long refreshExpiresSecond;

    public String getBase64Secret() {
        return base64Secret;
    }

    public void setBase64Secret(String base64Secret) {
        this.base64Secret = base64Secret;
    }

    public long getExpiresSecond() {
        return expiresSecond;
    }

    public void setExpiresSecond(long expiresSecond) {
        this.expiresSecond = expiresSecond;
    }

    public long getRefreshExpiresSecond() {
        return refreshExpiresSecond;
    }

    public void setRefreshExpiresSecond(long refreshExpiresSecond) {
        this.refreshExpiresSecond = refreshExpiresSecond;
    }

    public String getRefreshBase64Secret() {
        return refreshBase64Secret;
    }

    public void setRefreshBase64Secret(String refreshBase64Secret) {
        this.refreshBase64Secret = refreshBase64Secret;
    }

}
