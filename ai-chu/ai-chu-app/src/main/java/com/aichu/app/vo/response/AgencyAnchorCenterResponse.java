package com.aichu.app.vo.response;

import com.aichu.dao.workstation.object.UserAnchorDao;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @ClassName AgencyAnchorCenterResponse
 * @Description 代理用户代理中心信息响应Response
 * @Author Melon
 * @Date 2019/7/19 10:41
 * @Version 1.0.0
 **/
public class AgencyAnchorCenterResponse {

  @ApiModelProperty(name = "earnTotalCoin", value = "收益余额")
  private Integer earnTotalCoin;

  @ApiModelProperty(name = "totalInviteNum", value = "总邀请人数")
  private Integer totalInviteNum;

  @ApiModelProperty(name = "todayInviteNum", value = "今日邀请人数")
  private Integer todayInviteNum;

  @ApiModelProperty(name = "todayEarnCoin", value = "今日邀请收益")
  private Integer todayEarnCoin;

  @ApiModelProperty(name = "userAnchorNum", value = "用户主播人数")
  private Integer userAnchorNum;

  @ApiModelProperty(name = "todayDeductCoin", value = "今日提成汇总")
  private Integer todayDeductCoin;

  @ApiModelProperty(name = "totalDeductCoin", value = "总提成汇总")
  private Integer totalDeductCoin;

  @ApiModelProperty(name = "userAnchorDaoList", value = "我的主播信息")
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
