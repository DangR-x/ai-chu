package com.aichu.app.vo.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @ClassName AliPayCreateOrderRequest
 * @Description Ali支付请求参数
 * @Author Melon
 * @Date 2019/9/2 11:48
 * @Version 1.0.0
 **/
public class AliPayCreateOrderRequest implements Serializable {

  @ApiModelProperty(name = "consumeType", value = "消费类型（0-充值，1-购买优惠卡）", required = true, hidden = false)
  @NotNull(message = "消费类型不可为空")
  private Integer consumeType;

  @ApiModelProperty(name = "aimGoodsId", value = "目标商品ID", required = true, hidden = false)
  @NotNull( message = "目标商品ID不可为空")
  private Integer aimGoodsId;

  @ApiModelProperty(name = "preferentialCardType", value = "优惠卡类型（0-周卡，1-月卡）消费类型为 1 时必传", required = false, hidden = false)
  private Integer preferentialCardType;

  public Integer getConsumeType() {
    return consumeType;
  }

  public void setConsumeType(Integer consumeType) {
    this.consumeType = consumeType;
  }

  public Integer getAimGoodsId() {
    return aimGoodsId;
  }

  public void setAimGoodsId(Integer aimGoodsId) {
    this.aimGoodsId = aimGoodsId;
  }

  public Integer getPreferentialCardType() {
    return preferentialCardType;
  }

  public void setPreferentialCardType(Integer preferentialCardType) {
    this.preferentialCardType = preferentialCardType;
  }
}
