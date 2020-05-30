package com.aichu.manager.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MyAliConfig
 * @Description 支付宝信息参数初始化Config
 * @Author Melon
 * @Date 2019/7/19 11:08
 * @Version 1.0.0
 **/
@Configuration
public class AliPayConfig {

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

  @Value("${aliConfig.aliRequestURL}")
  private volatile String aliRequestURL;

  @Value("${aliConfig.aliLoginURI}")
  private volatile String aliLoginURI;

  @Value("${aliConfig.aliAuthorizeURI}")
  private volatile String aliAuthorizeURI;

  @Value("${aliConfig.aliNormalNotifyUrl}")
  private volatile String aliNormalNotifyUrl;

  @Value("${aliConfig.aliFormat}")
  private volatile String aliFormat;

  @Value("${aliConfig.aliCharset}")
  private volatile String aliCharset;

  @Value("${aliConfig.aliSignType}")
  private volatile String aliSignType;

  @Value("${aliConfig.aliScope}")
  private volatile String aliScope;

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

  public String getAliRequestURL() {
    return aliRequestURL;
  }

  public void setAliRequestURL(String aliRequestURL) {
    this.aliRequestURL = aliRequestURL;
  }

  public String getAliLoginURI() {
    return aliLoginURI;
  }

  public void setAliLoginURI(String aliLoginURI) {
    this.aliLoginURI = aliLoginURI;
  }

  public String getAliAuthorizeURI() {
    return aliAuthorizeURI;
  }

  public void setAliAuthorizeURI(String aliAuthorizeURI) {
    this.aliAuthorizeURI = aliAuthorizeURI;
  }

  public String getAliFormat() {
    return aliFormat;
  }

  public void setAliFormat(String aliFormat) {
    this.aliFormat = aliFormat;
  }

  public String getAliCharset() {
    return aliCharset;
  }

  public void setAliCharset(String aliCharset) {
    this.aliCharset = aliCharset;
  }

  public String getAliSignType() {
    return aliSignType;
  }

  public void setAliSignType(String aliSignType) {
    this.aliSignType = aliSignType;
  }

  public String getAliScope() {
    return aliScope;
  }

  public void setAliScope(String aliScope) {
    this.aliScope = aliScope;
  }

  public String getAliSeller() {
    return aliSeller;
  }

  public void setAliSeller(String aliSeller) {
    this.aliSeller = aliSeller;
  }

  public String getAliNormalNotifyUrl() {
    return aliNormalNotifyUrl;
  }

  public void setAliNormalNotifyUrl(String aliNormalNotifyUrl) {
    this.aliNormalNotifyUrl = aliNormalNotifyUrl;
  }
}
