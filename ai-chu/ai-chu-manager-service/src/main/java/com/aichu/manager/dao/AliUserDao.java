package com.aichu.manager.dao;


/**
 * @ClassName AliUserDao
 * @Description AliUser信息响应Dao
 * @Author Melon
 * @Date 2019/7/19 10:41
 * @Version 1.0.0
 **/
public class AliUserDao {

  private String nickname;

  private String avatar;

  private String userAuthsId;

  private String email;

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  public String getUserAuthsId() {
    return userAuthsId;
  }

  public void setUserAuthsId(String userAuthsId) {
    this.userAuthsId = userAuthsId;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

}
