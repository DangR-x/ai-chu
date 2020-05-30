package com.aichu.app.vo.response;

import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName MainFaceAnchorFindResponse
 * @Description 首页搜索用户列表响应Response
 * @Author Melon
 * @Date 2019/7/19 10:41
 * @Version 1.0.0
 **/
public class MainFaceAnchorFindResponse {

  @ApiModelProperty(name = "userId", value = "用户ID")
  private Integer userId;

  @ApiModelProperty(name = "userAcUid", value = "用户爱触UID")
  private String userAcUid;

  @ApiModelProperty(name = "userName", value = "用户昵称")
  private String userName;

  @ApiModelProperty(name = "userHead", value = "用户头像")
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
