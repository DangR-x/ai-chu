package com.aichu.service.dto;

/**
 * @ClassName AgencyAnchorDTO
 * @Description 代理用户在线用户信息响应DTO
 * @Author Melon
 * @Date 2019/7/19 10:41
 * @Version 1.0.0
 **/
public class AgencyAnchorDTO {

  private Integer userId;

  private String userAcId;

  private String userHead;

  private String userName;

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
