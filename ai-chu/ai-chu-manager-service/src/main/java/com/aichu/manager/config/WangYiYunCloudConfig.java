package com.aichu.manager.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName WangYiYunCloudConfig
 * @Description 网易云信息参数初始化Config
 * @Author Melon
 * @Date 2019/7/19 11:08
 * @Version 1.0.0
 **/
@Configuration
public class WangYiYunCloudConfig {

  @Value("${wangYiYunCloud.appKey}")
  private volatile String appKey;

  @Value("${wangYiYunCloud.appSecret}")
  private volatile String appSecret;

  public String getAppKey() {
    return appKey;
  }

  public void setAppKey(String appKey) {
    this.appKey = appKey;
  }

  public String getAppSecret() {
    return appSecret;
  }

  public void setAppSecret(String appSecret) {
    this.appSecret = appSecret;
  }
}
