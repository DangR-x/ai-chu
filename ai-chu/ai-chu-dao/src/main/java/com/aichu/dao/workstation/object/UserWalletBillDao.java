package com.aichu.dao.workstation.object;

/**
 * @ClassName UserWalletBillDao
 * @Description 用户账单信息响应Dao
 * @Author Melon
 * @Date 2019/7/19 10:41
 * @Version 1.0.0
 **/
public class UserWalletBillDao {

  private String actionDesc;

  private Integer payType;

  private Integer payStatus;

  private Integer consumeType;

  private Integer orderAmount;

  private Integer orderCoin;

  private Integer auditStatus;

  private Integer weekCardPresentedCoin;

  private Integer mouthCardPresentedCoin;

  private Integer chartTime;

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
