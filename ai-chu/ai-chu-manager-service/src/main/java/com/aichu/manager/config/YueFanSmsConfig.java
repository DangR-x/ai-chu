package com.aichu.manager.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName YueFanSmsConfig
 * @Description 悦凡短信验参数初始化Config
 * @Author Melon
 * @Date 2019/7/19 11:08
 * @Version 1.0.0
 **/
@Configuration
public class YueFanSmsConfig {

  @Value("${yueFanSms.yueFanSmsAccount}")
  private volatile String yueFanSmsAccount;

  @Value("${yueFanSms.yueFanSmsPassWord}")
  private volatile String yueFanSmsPassWord;

  @Value("${yueFanSms.yueFanSmsType}")
  private volatile String yueFanSmsType;

  @Value("${yueFanSms.yueFanSmsSign}")
  private volatile String yueFanSmsSign;

  @Value("${yueFanSms.yueFanSmsVerifCodeTime}")
  private volatile Integer yueFanSmsVerifCodeTime;

  public String getYueFanSmsAccount() {
    return yueFanSmsAccount;
  }

  public void setYueFanSmsAccount(String yueFanSmsAccount) {
    this.yueFanSmsAccount = yueFanSmsAccount;
  }

  public String getYueFanSmsPassWord() {
    return yueFanSmsPassWord;
  }

  public void setYueFanSmsPassWord(String yueFanSmsPassWord) {
    this.yueFanSmsPassWord = yueFanSmsPassWord;
  }

  public String getYueFanSmsType() {
    return yueFanSmsType;
  }

  public void setYueFanSmsType(String yueFanSmsType) {
    this.yueFanSmsType = yueFanSmsType;
  }

  public String getYueFanSmsSign() {
    return yueFanSmsSign;
  }

  public void setYueFanSmsSign(String yueFanSmsSign) {
    this.yueFanSmsSign = yueFanSmsSign;
  }

  public Integer getYueFanSmsVerifCodeTime() {
    return yueFanSmsVerifCodeTime;
  }

  public void setYueFanSmsVerifCodeTime(Integer yueFanSmsVerifCodeTime) {
    this.yueFanSmsVerifCodeTime = yueFanSmsVerifCodeTime;
  }
}
