package com.aichu.dao.workstation.object;

/**
 * @ClassName UserAgencyNextUserDao
 * @Description 用户代理下級用戶列表响应Dao
 * @Author Melon
 * @Date 2019/7/19 10:41
 * @Version 1.0.0
 **/
public class UserAgencyNextUserDao {

  private Integer userId;

  private String userAcUid;

  private String userName;

  private String userHead;

  private Integer userSex;

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
