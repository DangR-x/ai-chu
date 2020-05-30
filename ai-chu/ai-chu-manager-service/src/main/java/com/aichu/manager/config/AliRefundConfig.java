package com.aichu.manager.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName AliRefundConfig
 * @Description 支付宝退款信息参数初始化Config
 * @Author Melon
 * @Date 2019/7/19 11:08
 * @Version 1.0.0
 **/
@Configuration
public class AliRefundConfig {

  @Value("${aliConfig.aliAppId}")
  private volatile String aliAppId;

  @Value("${aliConfig.aliPid}")
  private volatile String aliPid;

  @Value("${aliConfig.aliSeller}")
  private volatile String aliSeller;

  @Value("${aliConfig.aliAppPrivateKey}")
  private volatile String aliAppPrivateKey;

  @Value("${aliConfig.aliAppPublicKey}")
  private volatile String aliAppPublicKey;

  public String getAliAppId() {
    return aliAppId;
  }

  public void setAliAppId(String aliAppId) {
    this.aliAppId = aliAppId;
  }

  public String getAliPid() {
    return aliPid;
  }

  public void setAliPid(String aliPid) {
    this.aliPid = aliPid;
  }

  public String getAliAppPrivateKey() {
    return aliAppPrivateKey;
  }

  public void setAliAppPrivateKey(String aliAppPrivateKey) {
    this.aliAppPrivateKey = aliAppPrivateKey;
  }

  public String getAliAppPublicKey() {
    return aliAppPublicKey;
  }

  public void setAliAppPublicKey(String aliAppPublicKey) {
    this.aliAppPublicKey = aliAppPublicKey;
  }

  public String getAliSeller() {
    return aliSeller;
  }

  public void setAliSeller(String aliSeller) {
    this.aliSeller = aliSeller;
  }
}
