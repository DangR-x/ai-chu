package com.aichu.app.vo.response;

import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName UserWalletResponse
 * @Description 用户钱包信息响应Response
 * @Author Melon
 * @Date 2019/7/19 10:41
 * @Version 1.0.0
 **/
public class UserWalletResponse {

  @ApiModelProperty(name = "userCoin", value = "用户金币余额")
  private Integer userCoin;

  @ApiModelProperty(name = "userWeekSignTime", value = "用户周卡已签到次数")
  private Integer userWeekSignTime;

  @ApiModelProperty(name = "userMouthSignTime", value = "用户月卡已签到次数")
  private Integer userMouthSignTime;

  @ApiModelProperty(name = "haveWeekCard", value = "用户是否购买周卡（0-否，1-是）")
  private Integer haveWeekCard;

  @ApiModelProperty(name = "haveMouthCard", value = "用户是否购买月卡（0-否，1-是）")
  private Integer haveMouthCard;

  public Integer getUserCoin() {
    return userCoin;
  }

  public void setUserCoin(Integer userCoin) {
    this.userCoin = userCoin;
  }

  public Integer getUserWeekSignTime() {
    return userWeekSignTime;
  }

  public void setUserWeekSignTime(Integer userWeekSignTime) {
    this.userWeekSignTime = userWeekSignTime;
  }

  public Integer getUserMouthSignTime() {
    return userMouthSignTime;
  }

  public void setUserMouthSignTime(Integer userMouthSignTime) {
    this.userMouthSignTime = userMouthSignTime;
  }

  public Integer getHaveWeekCard() {
    return haveWeekCard;
  }

  public void setHaveWeekCard(Integer haveWeekCard) {
    this.haveWeekCard = haveWeekCard;
  }

  public Integer getHaveMouthCard() {
    return haveMouthCard;
  }

  public void setHaveMouthCard(Integer haveMouthCard) {
    this.haveMouthCard = haveMouthCard;
  }
}
