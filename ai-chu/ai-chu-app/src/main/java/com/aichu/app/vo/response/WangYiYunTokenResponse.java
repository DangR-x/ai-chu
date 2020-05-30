package com.aichu.app.vo.response;

import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName WangYiYunTokenResponse
 * @Description WangYiYunToken信息响应Response
 * @Author Melon
 * @Date 2019/7/19 10:41
 * @Version 1.0.0
 **/
public class WangYiYunTokenResponse {

  @ApiModelProperty(name = "wangYiYunCloudUserToken", value = "网易云用户Token")
  private String wangYiYunCloudUserToken;

  @ApiModelProperty(name = "wangYiYunCloudUserAccId", value = "网易云用户AccID")
  private String wangYiYunCloudUserAccId;

  @ApiModelProperty(name = "wangYiYunCloudUserName", value = "网易云用户昵称")
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
