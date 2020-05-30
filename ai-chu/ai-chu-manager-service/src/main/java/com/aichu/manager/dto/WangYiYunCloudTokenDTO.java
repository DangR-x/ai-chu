package com.aichu.manager.dto;

/**
 * @ClassName WangYiYunCloudTokenDTO
 * @Description WangYiYunToken信息响应DTO
 * @Author Melon
 * @Date 2019/7/19 10:41
 * @Version 1.0.0
 **/
public class WangYiYunCloudTokenDTO {

  private String wangYiYunCloudUserToken;

  private String wangYiYunCloudUserAccId;

  private String wangYiYunCloudUserName;

  public String getWangYiYunCloudUserToken() {
    return wangYiYunCloudUserToken;
  }

  public void setWangYiYunCloudUserToken(String wangYiYunCloudUserToken) {
    this.wangYiYunCloudUserToken = wangYiYunCloudUserToken;
  }

  public String getWangYiYunCloudUserAccId() {
    return wangYiYunCloudUserAccId;
  }

  public void setWangYiYunCloudUserAccId(String wangYiYunCloudUserAccId) {
    this.wangYiYunCloudUserAccId = wangYiYunCloudUserAccId;
  }

  public String getWangYiYunCloudUserName() {
    return wangYiYunCloudUserName;
  }

  public void setWangYiYunCloudUserName(String wangYiYunCloudUserName) {
    this.wangYiYunCloudUserName = wangYiYunCloudUserName;
  }
}
