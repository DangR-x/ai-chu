package com.aichu.app.vo.response;

import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName AgencyAnchorResponse
 * @Description 代理用户在线用户信息响应Response
 * @Author Melon
 * @Date 2019/7/19 10:41
 * @Version 1.0.0
 **/
public class AgencyAnchorResponse {

  @ApiModelProperty(name = "userId", value = "用户ID")
  private Integer userId;

  @ApiModelProperty(name = "userAcId", value = "用户爱触ACID")
  private String userAcId;

  @ApiModelProperty(name = "userHead", value = "用户头像")
  private String userHead;

  @ApiModelProperty(name = "userName", value = "用户昵称")
  private String userName;

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

  public String getUserHead() {
    return userHead;
  }

  public void setUserHead(String userHead) {
    this.userHead = userHead;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserSignature() {
    return userSignature;
  }

  public void setUserSignature(String userSignature) {
    this.userSignature = userSignature;
  }
}
