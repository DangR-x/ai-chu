package com.aichu.app.vo.response;

import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName ChargeConfigResponse
 * @Description 充值配置信息列表信息响应Response
 * @Author Melon
 * @Date 2019/7/19 10:41
 * @Version 1.0.0
 **/
public class ChargeConfigResponse {

  @ApiModelProperty(name = "chargeId", value = "充值参数ID")
  private Integer chargeId;

  @ApiModelProperty(name = "chargeAmount", value = "充值金额（单位：分）")
  private Integer chargeAmount;

  @ApiModelProperty(name = "chargeCoin", value = "充值金币")
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
