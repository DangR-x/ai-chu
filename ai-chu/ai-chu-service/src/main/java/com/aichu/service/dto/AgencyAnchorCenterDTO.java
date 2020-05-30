package com.aichu.service.dto;

import com.aichu.dao.workstation.object.UserAnchorDao;

import java.util.List;

/**
 * @ClassName AgencyAnchorCenterDTO
 * @Description 代理用户代理中心信息响应DTO
 * @Author Melon
 * @Date 2019/7/19 10:41
 * @Version 1.0.0
 **/
public class AgencyAnchorCenterDTO {

  private Integer earnTotalCoin;

  private Integer totalInviteNum;

  private Integer todayInviteNum;

  private Integer todayEarnCoin;

  private Integer userAnchorNum;

  private Integer todayDeductCoin;

  private Integer totalDeductCoin;

  private List<UserAnchorDao> userAnchorDaoList;

  public Integer getEarnTotalCoin() {
    return earnTotalCoin;
  }

  public void setEarnTotalCoin(Integer earnTotalCoin) {
    this.earnTotalCoin = earnTotalCoin;
  }

  public Integer getTotalInviteNum() {
    return totalInviteNum;
  }

  public void setTotalInviteNum(Integer totalInviteNum) {
    this.totalInviteNum = totalInviteNum;
  }

  public Integer getTodayInviteNum() {
    return todayInviteNum;
  }

  public void setTodayInviteNum(Integer todayInviteNum) {
    this.todayInviteNum = todayInviteNum;
  }

  public Integer getTodayEarnCoin() {
    return todayEarnCoin;
  }

  public void setTodayEarnCoin(Integer todayEarnCoin) {
    this.todayEarnCoin = todayEarnCoin;
  }

  public Integer getUserAnchorNum() {
    return userAnchorNum;
  }

  public void setUserAnchorNum(Integer userAnchorNum) {
    this.userAnchorNum = userAnchorNum;
  }

  public Integer getTodayDeductCoin() {
    return todayDeductCoin;
  }

  public void setTodayDeductCoin(Integer todayDeductCoin) {
    this.todayDeductCoin = todayDeductCoin;
  }

  public Integer getTotalDeductCoin() {
    return totalDeductCoin;
  }

  public void setTotalDeductCoin(Integer totalDeductCoin) {
    this.totalDeductCoin = totalDeductCoin;
  }

  public List<UserAnchorDao> getUserAnchorDaoList() {
    return userAnchorDaoList;
  }

  public void setUserAnchorDaoList(List<UserAnchorDao> userAnchorDaoList) {
    this.userAnchorDaoList = userAnchorDaoList;
  }
}
