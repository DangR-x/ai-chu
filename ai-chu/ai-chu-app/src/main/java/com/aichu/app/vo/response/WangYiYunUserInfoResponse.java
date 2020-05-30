package com.aichu.app.vo.response;

import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName WangYiYunUserInfoResponse
 * @Description WangYiYun用户信息响应Response
 * @Author Melon
 * @Date 2019/7/19 10:41
 * @Version 1.0.0
 **/
public class WangYiYunUserInfoResponse {

  @ApiModelProperty(name = "wangYiYunCloudUserAccId", value = "网易云用户AccID")
  private String wangYiYunCloudUserAccId;

  @ApiModelProperty(name = "wangYiYunCloudUserName", value = "网易云用户昵称")
  private String wangYiYunCloudUserName;

  @ApiModelProperty(name = "wangYiYunCloudUserHeadImg", value = "网易云用户头像")
  private String wangYiYunCloudUserHeadImg;

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

  public String getWangYiYunCloudUserHeadImg() {
    return wangYiYunCloudUserHeadImg;
  }

  public void setWangYiYunCloudUserHeadImg(String wangYiYunCloudUserHeadImg) {
    this.wangYiYunCloudUserHeadImg = wangYiYunCloudUserHeadImg;
  }
}
