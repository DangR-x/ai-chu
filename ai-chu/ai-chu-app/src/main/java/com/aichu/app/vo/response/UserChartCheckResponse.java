package com.aichu.app.vo.response;

import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName UserWalletResponse
 * @Description 用户钱包信息响应Response
 * @Author Melon
 * @Date 2019/7/19 10:41
 * @Version 1.0.0
 **/
public class UserChartCheckResponse {

  @ApiModelProperty(name = "chartCost", value = "聊天费用（单位：金币/分钟）")
  private Integer chartCost;

  @ApiModelProperty(name = "userAmount", value = "用户金币余额")
  private Integer userAmount;

  @ApiModelProperty(name = "canChartTime", value = "用户可聊时长（预估）")
  private Integer canChartTime;

  @ApiModelProperty(name = "warmChartTime", value = "用户提示充值初始化分钟数（单位：分钟）")
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
