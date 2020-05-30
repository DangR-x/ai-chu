package com.aichu.service.dto;

/**
 * @ClassName ChargeConfigDTO
 * @Description 充值配置信息列表信息响应DTO
 * @Author Melon
 * @Date 2019/7/19 10:41
 * @Version 1.0.0
 **/
public class ChargeConfigDTO {

  private Integer chargeId;

  private Integer chargeAmount;

  private Integer chargeCoin;

  public Integer getChargeId() {
    return chargeId;
  }

  public void setChargeId(Integer chargeId) {
    this.chargeId = chargeId;
  }

  public Integer getChargeAmount() {
    return chargeAmount;
  }

  public void setChargeAmount(Integer chargeAmount) {
    this.chargeAmount = chargeAmount;
  }

  public Integer getChargeCoin() {
    return chargeCoin;
  }

  public void setChargeCoin(Integer chargeCoin) {
    this.chargeCoin = chargeCoin;
  }
}
