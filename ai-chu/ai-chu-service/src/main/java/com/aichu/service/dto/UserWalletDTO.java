package com.aichu.service.dto;

/**
 * @ClassName UserWalletDTO
 * @Description 用户钱包信息响应DTO
 * @Author Melon
 * @Date 2019/7/19 10:41
 * @Version 1.0.0
 **/
public class UserWalletDTO {

  private Integer userCoin;

  private Integer userWeekSignTime;

  private Integer userMouthSignTime;

  private Integer haveWeekCard;

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
