package com.aichu.app.vo.response;

import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName UserAgencyNextUserResponse
 * @Description 用户代理下級用戶列表响应Response
 * @Author Melon
 * @Date 2019/7/19 10:41
 * @Version 1.0.0
 **/
public class UserAgencyNextUserResponse {

  @ApiModelProperty(name = "userId", value = "用户ID")
  private Integer userId;

  @ApiModelProperty(name = "userAcUid", value = "用户爱触UID")
  private String userAcUid;

  @ApiModelProperty(name = "userName", value = "用户昵称")
  private String userName;

  @ApiModelProperty(name = "userHead", value = "用户头像")
  private String userHead;

  @ApiModelProperty(name = "userSex", value = "性别（0-男，1-女）")
  private Integer userSex;

  @ApiModelProperty(name = "createTime", value = "创建时间")
  private String createTime;

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

  public Integer getUserSex() {
    return userSex;
  }

  public void setUserSex(Integer userSex) {
    this.userSex = userSex;
  }

  public String getCreateTime() {
    return createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }
}
