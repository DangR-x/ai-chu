package com.aichu.service.dto;

/**
 * @ClassName UserVideoRecordDTO
 * @Description 用户视频通话记录列表响应DTO
 * @Author Melon
 * @Date 2019/7/19 10:41
 * @Version 1.0.0
 **/
public class UserVideoRecordDTO {

  private Integer userId;

  private String userAcUid;

  private String userName;

  private String userHead;

  private String telTime;

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
