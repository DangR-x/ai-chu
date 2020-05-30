package com.aichu.app.config.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName TokenConfig
 * @Description Token信息初始化工具类
 * @Author Melon
 * @Date 2019/7/18 10:26
 * @Version 1.0.0
 **/
@Component
@ConfigurationProperties(prefix = "jwt")
public class TokenConfig {

    /** base64加密字符串 */
    private String base64Secret;

    /** base64加密字符串 刷新使用 */
    private String refreshBase64Secret;

    /** jwt token过期时间，毫秒 */
    private Integer expiresSecond;

    /** refresh token过期时间 */
    private Integer refreshExpiresSecond;

    /** 是否在每次有效操作后刷新token在redis中的过期时间，是=true，否=false */
    private Boolean flushExpireAfterOperation;

    /** 是否一个用户单对应唯一一个Token，是=true，否=false */
    private Boolean singleTokenWithUser;

    /** redis token过期时间，秒 */
    private Integer tokenExpireSeconds;

    @Override
    public String toString() {
        return "TokenConfig{" +
                "base64Secret='" + base64Secret + '\'' +
                ", refreshBase64Secret='" + refreshBase64Secret + '\'' +
                ", expiresSecond=" + expiresSecond +
                ", refreshExpiresSecond=" + refreshExpiresSecond +
                ", flushExpireAfterOperation='" + flushExpireAfterOperation + '\'' +
                ", singleTokenWithUser='" + singleTokenWithUser + '\'' +
                ", tokenExpireSeconds=" + tokenExpireSeconds +
                '}';
    }

    public String getBase64Secret() {
        return base64Secret;
    }

    public void setBase64Secret(String base64Secret) {
        this.base64Secret = base64Secret;
    }

    public String getRefreshBase64Secret() {
        return refreshBase64Secret;
    }

    public void setRefreshBase64Secret(String refreshBase64Secret) {
        this.refreshBase64Secret = refreshBase64Secret;
    }

    public Integer getExpiresSecond() {
        return expiresSecond;
    }

    public void setExpiresSecond(Integer expiresSecond) {
        this.expiresSecond = expiresSecond;
    }

    public Integer getRefreshExpiresSecond() {
        return refreshExpiresSecond;
    }

    public void setRefreshExpiresSecond(Integer refreshExpiresSecond) {
        this.refreshExpiresSecond = refreshExpiresSecond;
    }

    public Integer getTokenExpireSeconds() {
        return tokenExpireSeconds;
    }

    public void setTokenExpireSeconds(Integer tokenExpireSeconds) {
        this.tokenExpireSeconds = tokenExpireSeconds;
    }

    public Boolean getFlushExpireAfterOperation() {
        return flushExpireAfterOperation;
    }

    public void setFlushExpireAfterOperation(Boolean flushExpireAfterOperation) {
        this.flushExpireAfterOperation = flushExpireAfterOperation;
    }

    public Boolean getSingleTokenWithUser() {
        return singleTokenWithUser;
    }

    public void setSingleTokenWithUser(Boolean singleTokenWithUser) {
        this.singleTokenWithUser = singleTokenWithUser;
    }
}
