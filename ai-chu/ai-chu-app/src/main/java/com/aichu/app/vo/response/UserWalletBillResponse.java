package com.aichu.app.vo.response;

import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName UserWalletBillResponse
 * @Description 用户账单信息响应Response
 * @Author Melon
 * @Date 2019/7/19 10:41
 * @Version 1.0.0
 **/
public class UserWalletBillResponse {

  @ApiModelProperty(name = "actionDesc", value = "操作行为描述")
  private String actionDesc;

  @ApiModelProperty(name = "payType", value = "支付类型（0-收入，1-支出）")
  private Integer payType;

  @ApiModelProperty(name = "payStatus", value = "订单状态（0-未支付，1-已支付，2，已取消，3-未退款，4-退款中，5-已退款，6-已拒绝，7-已完成）")
  private Integer payStatus;

  @ApiModelProperty(name = "consumeType", value = "消费类型（0-充值，1-提现，2-优惠卡，3-直播打赏，4-直播付费, 5-代理提成）")
  private Integer consumeType;

  @ApiModelProperty(name = "orderAmount", value = "订单金额（单位：分）")
  private Integer orderAmount;

  @ApiModelProperty(name = "orderCoin", value = "订单金币（单位：金币）")
  private Integer orderCoin;

  @ApiModelProperty(name = "auditStatus", value = "提现状态（0-提现中，1-已拒绝，2-提现成功, 3-提现失败）仅当类型为提现时有用")
  private Integer auditStatus;

  @ApiModelProperty(name = "weekCardPresentedCoin", value = "周卡签到赠送金币（单位：金币）仅签到时有用")
  private Integer weekCardPresentedCoin;

  @ApiModelProperty(name = "mouthCardPresentedCoin", value = "月卡签到赠送金币（单位：金币）仅签到时有用")
  private Integer mouthCardPresentedCoin;

  @ApiModelProperty(name = "chartTime", value = "聊天通话时长（单位：秒）")
  private Integer chartTime;

  @ApiModelProperty(name = "createTime", value = "总提成汇总")
  private String createTime;

  public String getActionDesc() {
    return actionDesc;
  }

  public void setActionDesc(String actionDesc) {
    this.actionDesc = actionDesc;
  }

  public Integer getPayType() {
    return payType;
  }

  public void setPayType(Integer payType) {
    this.payType = payType;
  }

  public Integer getConsumeType() {
    return consumeType;
  }

  public void setConsumeType(Integer consumeType) {
    this.consumeType = consumeType;
  }

  public Integer getOrderAmount() {
    return orderAmount;
  }

  public void setOrderAmount(Integer orderAmount) {
    this.orderAmount = orderAmount;
  }

  public Integer getOrderCoin() {
    return orderCoin;
  }

  public void setOrderCoin(Integer orderCoin) {
    this.orderCoin = orderCoin;
  }

  public Integer getAuditStatus() {
    return auditStatus;
  }

  public void setAuditStatus(Integer auditStatus) {
    this.auditStatus = auditStatus;
  }

  public Integer getWeekCardPresentedCoin() {
    return weekCardPresentedCoin;
  }

  public void setWeekCardPresentedCoin(Integer weekCardPresentedCoin) {
    this.weekCardPresentedCoin = weekCardPresentedCoin;
  }

  public Integer getMouthCardPresentedCoin() {
    return mouthCardPresentedCoin;
  }

  public void setMouthCardPresentedCoin(Integer mouthCardPresentedCoin) {
    this.mouthCardPresentedCoin = mouthCardPresentedCoin;
  }

  public Integer getChartTime() {
    return chartTime;
  }

  public void setChartTime(Integer chartTime) {
    this.chartTime = chartTime;
  }

  public String getCreateTime() {
    return createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }

  public Integer getPayStatus() {
    return payStatus;
  }

  public void setPayStatus(Integer payStatus) {
    this.payStatus = payStatus;
  }
}
