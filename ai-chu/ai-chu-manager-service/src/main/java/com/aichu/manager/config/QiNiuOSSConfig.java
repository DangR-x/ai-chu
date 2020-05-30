package com.aichu.manager.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName QiNiuOSSConfig
 * @Description 七牛对象云存储参数初始化Config
 * @Author Melon
 * @Date 2019/7/19 11:08
 * @Version 1.0.0
 **/
@Configuration
public class QiNiuOSSConfig {

  @Value("${qiNiuOss.qiNiuAccessKey}")
  private volatile String qiNiuAccessKey;

  @Value("${qiNiuOss.qiNiuSecretKey}")
  private volatile String qiNiuSecretKey;

  @Value("${qiNiuOss.qiNiuBucket}")
  private volatile String qiNiuBucket;

  @Value("${qiNiuOss.qiNiuCndDomain}")
  private volatile String qiNiuCndDomain;

  public String getQiNiuAccessKey() {
    return qiNiuAccessKey;
  }

  public void setQiNiuAccessKey(String qiNiuAccessKey) {
    this.qiNiuAccessKey = qiNiuAccessKey;
  }

  public String getQiNiuSecretKey() {
    return qiNiuSecretKey;
  }

  public void setQiNiuSecretKey(String qiNiuSecretKey) {
    this.qiNiuSecretKey = qiNiuSecretKey;
  }

  public String getQiNiuBucket() {
    return qiNiuBucket;
  }

  public void setQiNiuBucket(String qiNiuBucket) {
    this.qiNiuBucket = qiNiuBucket;
  }

  public String getQiNiuCndDomain() {
    return qiNiuCndDomain;
  }

  public void setQiNiuCndDomain(String qiNiuCndDomain) {
    this.qiNiuCndDomain = qiNiuCndDomain;
  }
}
