package com.aichu.app.vo.response;

import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName UserBlackListInfoResponse
 * @Description WangYiYun用户黑名单列表信息响应Response
 * @Author Melon
 * @Date 2019/7/19 10:41
 * @Version 1.0.0
 **/
public class UserBlackListInfoResponse {

  @ApiModelProperty(name = "userId", value = "用户ID")
  private Integer userId;

  @ApiModelProperty(name = "userAcId", value = "用户AccID")
  private String userAcId;

  @ApiModelProperty(name = "userName", value = "用户名称")
  private String userName;

  @ApiModelProperty(name = "userHead", value = "用户头像")
  private String userHead;

  @ApiModelProperty(name = "userSignature", value = "用户个性签名")
  private String userSignature;

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public String getUserAcId() {
    return userAcId;
  }

  public void setUserAcId(String userAcId) {
    this.userAcId = userAcId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserHead() {
    return userHead;
  }

  public void setUserHead(String userHead) {
    this.userHead = userHead;
  }

  public String getUserSignature() {
    return userSignature;
  }

  public void setUserSignature(String userSignature) {
    this.userSignature = userSignature;
  }
}
