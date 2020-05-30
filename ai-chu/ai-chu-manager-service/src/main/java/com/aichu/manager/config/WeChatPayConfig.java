package com.aichu.manager.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MyWxConfig
 * @Description 微信支付信息参数初始化Config
 * @Author Melon
 * @Date 2019/7/19 11:08
 * @Version 1.0.0
 **/
@Configuration
public class WeChatPayConfig {

  @Value("${wxConfig.wxAppId}")
  private volatile String wxAppId;

  @Value("${wxConfig.wxSecret}")
  private volatile String wxSecret;

  @Value("${wxConfig.wxMchId}")
  private volatile String wxMchId;

  @Value("${wxConfig.wxMchKey}")
  private volatile String wxMchKey;

  @Value("${wxConfig.wxNormalNotifyUrl}")
  private volatile String wxNormalNotifyUrl;

  @Value("${wxConfig.wxRefundNotifyUrl}")
  private volatile String wxRefundNotifyUrl;

  public String getWxAppId() {
    return wxAppId;
  }

  public void setWxAppId(String wxAppId) {
    this.wxAppId = wxAppId;
  }

  public String getWxSecret() {
    return wxSecret;
  }

  public void setWxSecret(String wxSecret) {
    this.wxSecret = wxSecret;
  }

  public String getWxMchId() {
    return wxMchId;
  }

  public void setWxMchId(String wxMchId) {
    this.wxMchId = wxMchId;
  }

  public String getWxMchKey() {
    return wxMchKey;
  }

  public void setWxMchKey(String wxMchKey) {
    this.wxMchKey = wxMchKey;
  }

  public String getWxNormalNotifyUrl() {
    return wxNormalNotifyUrl;
  }

  public void setWxNormalNotifyUrl(String wxNormalNotifyUrl) {
    this.wxNormalNotifyUrl = wxNormalNotifyUrl;
  }

  public String getWxRefundNotifyUrl() {
    return wxRefundNotifyUrl;
  }

  public void setWxRefundNotifyUrl(String wxRefundNotifyUrl) {
    this.wxRefundNotifyUrl = wxRefundNotifyUrl;
  }
}
