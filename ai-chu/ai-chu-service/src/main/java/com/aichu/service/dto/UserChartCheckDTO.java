package com.aichu.service.dto;

/**
 * @ClassName UserChartCheckDTO
 * @Description 用户钱包信息响应DTO
 * @Author Melon
 * @Date 2019/7/19 10:41
 * @Version 1.0.0
 **/
public class UserChartCheckDTO {

  private Integer chartCost;

  private Integer userAmount;

  private Integer canChartTime;

  private Integer warmChartTime;

  public Integer getChartCost() {
    return chartCost;
  }

  public void setChartCost(Integer chartCost) {
    this.chartCost = chartCost;
  }

  public Integer getUserAmount() {
    return userAmount;
  }

  public void setUserAmount(Integer userAmount) {
    this.userAmount = userAmount;
  }

  public Integer getCanChartTime() {
    return canChartTime;
  }

  public void setCanChartTime(Integer canChartTime) {
    this.canChartTime = canChartTime;
  }

  public Integer getWarmChartTime() {
    return warmChartTime;
  }

  public void setWarmChartTime(Integer warmChartTime) {
    this.warmChartTime = warmChartTime;
  }
}
