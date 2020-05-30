package com.aichu.service.dto;

/**
 * @ClassName MainFaceAnchorFindDTO
 * @Description 首页搜索用户列表响应DTO
 * @Author Melon
 * @Date 2019/7/19 10:41
 * @Version 1.0.0
 **/
public class MainFaceAnchorFindDTO {

  private Integer userId;

  private String userAcUid;

  private String userName;

  private String userHead;

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
}
