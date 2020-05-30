package com.aichu.app.vo.response;

import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName UserVideoRecordResponse
 * @Description 用户视频通话记录列表响应Response
 * @Author Melon
 * @Date 2019/7/19 10:41
 * @Version 1.0.0
 **/
public class UserVideoRecordResponse {

  @ApiModelProperty(name = "userId", value = "用户ID")
  private Integer userId;

  @ApiModelProperty(name = "userAcUid", value = "用户爱触UID")
  private String userAcUid;

  @ApiModelProperty(name = "userName", value = "用户昵称")
  private String userName;

  @ApiModelProperty(name = "userHead", value = "用户头像")
  private String userHead;

  @ApiModelProperty(name = "telTime", value = "通话时长")
  private String telTime;

  @ApiModelProperty(name = "telCreateTime", value = "通话发起时间")
  private String telCreateTime;

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public String getUserAcUid() {
    return userAcUid;
  }

  public void setUserAcUid(String userAcUid) {
    this.userAcUid = userAcUid;
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

  public String getTelTime() {
    return telTime;
  }

  public void setTelTime(String telTime) {
    this.telTime = telTime;
  }

  public String getTelCreateTime() {
    return telCreateTime;
  }

  public void setTelCreateTime(String telCreateTime) {
    this.telCreateTime = telCreateTime;
  }
}
