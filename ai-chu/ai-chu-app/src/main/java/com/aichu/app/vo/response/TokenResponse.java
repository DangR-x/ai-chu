package com.aichu.app.vo.response;

import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName TokenResponse
 * @Description Token信息响应Response
 * @Author Melon
 * @Date 2019/7/19 10:41
 * @Version 1.0.0
 **/
public class TokenResponse {

  @ApiModelProperty(name = "access_token", value = "access_token")
  private String access_token;

  @ApiModelProperty(name = "im_token", value = "im_token")
  private String im_token;

  @ApiModelProperty(name = "token_type", value = "token_type")
  private String token_type;

  @ApiModelProperty(name = "expires_in", value = "expires_in")
  private long expires_in;

  @ApiModelProperty(name = "refresh_token", value = "refresh_token")
  private String refresh_token;

  @ApiModelProperty(name = "userId", value = "用户ID")
  private Integer userId;

  @ApiModelProperty(name = "userAcId", value = "用户AcID")
  private String userAcId;

  @ApiModelProperty(name = "userHeadImg", value = "用户头像")
  private String userHeadImg;

  @ApiModelProperty(name = "isBindCardId", value = "是否绑定身份证")
  private boolean isBindCardId;

  @ApiModelProperty(name = "isBindPhone", value = "是否手机号")
  private boolean isBindPhone;

  @ApiModelProperty(name = "isBindPassword", value = "是否拥有密码")
  private boolean isBindPassword;

  @ApiModelProperty(name = "isBindPayPassword", value = "是否设置支付密码")
  private boolean isBindPayPassword;

  @ApiModelProperty(name = "phoneNum", value = "手机号号码")
  private String phoneNum;

  @ApiModelProperty(name = "isAuthentication", value = "是否完善资料(0-否，1-是)")
  private Integer isAuthentication;

  @ApiModelProperty(name = "isAgency", value = "是否是代理商(0-否，1-是)")
  private Integer isAgency;

  @ApiModelProperty(name = "isAnchor", value = "是否是主播(0-否，1-是)")
  private Integer isAnchor;

  @ApiModelProperty(name = "signDays", value = "签到天数")
  private Integer signDays;

  @ApiModelProperty(name = "isSign", value = "今日是否签到(0-否，1-是)")
  private Integer isSign;

  public String getAccess_token() {
    return access_token;
  }

  public void setAccess_token(String access_token) {
    this.access_token = access_token;
  }

  public String getToken_type() {
    return token_type;
  }

  public void setToken_type(String token_type) {
    this.token_type = token_type;
  }

  public long getExpires_in() {
    return expires_in;
  }

  public void setExpires_in(long expires_in) {
    this.expires_in = expires_in;
  }

  public String getRefresh_token() {
    return refresh_token;
  }

  public void setRefresh_token(String refresh_token) {
    this.refresh_token = refresh_token;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public boolean isBindCardId() {
    return isBindCardId;
  }

  public void setIsBindCardId(boolean isBindCardId) {
    this.isBindCardId = isBindCardId;
  }

  public boolean isBindPhone() {
    return isBindPhone;
  }

  public void setIsBindPhone(boolean isBindPhone) {
    this.isBindPhone = isBindPhone;
  }

  public boolean isBindPassword() {
    return isBindPassword;
  }

  public void setIsBindPassword(boolean isBindPassword) {
    this.isBindPassword = isBindPassword;
  }

  public String getPhoneNum() {
    return phoneNum;
  }

  public void setPhoneNum(String phoneNum) {
    this.phoneNum = phoneNum;
  }

  public Integer getIsAgency() {
    return isAgency;
  }

  public void setIsAgency(Integer isAgency) {
    this.isAgency = isAgency;
  }

  public boolean isBindPayPassword() {
    return isBindPayPassword;
  }

  public void setIsBindPayPassword(boolean isBindPayPassword) {
    this.isBindPayPassword = isBindPayPassword;
  }

  public String getUserHeadImg() {
    return userHeadImg;
  }

  public void setUserHeadImg(String userHeadImg) {
    this.userHeadImg = userHeadImg;
  }

  public Integer getIsAuthentication() {
    return isAuthentication;
  }

  public void setIsAuthentication(Integer isAuthentication) {
    this.isAuthentication = isAuthentication;
  }

  public String getIm_token() {
    return im_token;
  }

  public void setIm_token(String im_token) {
    this.im_token = im_token;
  }

  public Integer getIsAnchor() {
    return isAnchor;
  }

  public void setIsAnchor(Integer isAnchor) {
    this.isAnchor = isAnchor;
  }

  public Integer getSignDays() {
    return signDays;
  }

  public void setSignDays(Integer signDays) {
    this.signDays = signDays;
  }

  public Integer getIsSign() {
    return isSign;
  }

  public void setIsSign(Integer isSign) {
    this.isSign = isSign;
  }

  public String getUserAcId() {
    return userAcId;
  }

  public void setUserAcId(String userAcId) {
    this.userAcId = userAcId;
  }
}
