package com.aichu.app.vo.response;

import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName PreferentialCardResponse
 * @Description 优惠卡信息列表信息响应Response
 * @Author Melon
 * @Date 2019/7/19 10:41
 * @Version 1.0.0
 **/
public class PreferentialCardResponse {

  @ApiModelProperty(name = "cardId", value = "优惠卡ID")
  private Integer cardId;

  @ApiModelProperty(name = "cardName", value = "优惠卡名称")
  private String cardName;

  @ApiModelProperty(name = "cardOriginalPrice", value = "优惠卡原价（单位：分）")
  private Integer cardOriginalPrice;

  @ApiModelProperty(name = "cardSalePrice", value = "优惠卡现价（单位：分）")
  private Integer cardSalePrice;

  @ApiModelProperty(name = "cardDetail", value = "优惠卡描述")
  private String cardDetail;

  @ApiModelProperty(name = "everyDayFreeCoin", value = "每天领取金币数值")
  private Integer everyDayFreeCoin;

  @ApiModelProperty(name = "totalFreeCoin", value = "总共可领取金币数值")
  private Integer totalFreeCoin;

  @ApiModelProperty(name = "signTime", value = "可签到次数")
  private Integer signTime;

  @ApiModelProperty(name = "cardType", value = "优惠卡类型（0-周卡，1-月卡）")
  private Integer cardType;

  @ApiModelProperty(name = "cardSaleNum", value = "优惠卡卖出数量")
  private Integer cardSaleNum;

  @ApiModelProperty(name = "cardTotalNum", value = "优惠卡总数")
  private Integer cardTotalNum;

  public Integer getCardId() {
    return cardId;
  }

  public void setCardId(Integer cardId) {
    this.cardId = cardId;
  }

  public String getCardName() {
    return cardName;
  }

  public void setCardName(String cardName) {
    this.cardName = cardName;
  }

  public Integer getCardOriginalPrice() {
    return cardOriginalPrice;
  }

  public void setCardOriginalPrice(Integer cardOriginalPrice) {
    this.cardOriginalPrice = cardOriginalPrice;
  }

  public Integer getCardSalePrice() {
    return cardSalePrice;
  }

  public void setCardSalePrice(Integer cardSalePrice) {
    this.cardSalePrice = cardSalePrice;
  }

  public String getCardDetail() {
    return cardDetail;
  }

  public void setCardDetail(String cardDetail) {
    this.cardDetail = cardDetail;
  }

  public Integer getEveryDayFreeCoin() {
    return everyDayFreeCoin;
  }

  public void setEveryDayFreeCoin(Integer everyDayFreeCoin) {
    this.everyDayFreeCoin = everyDayFreeCoin;
  }

  public Integer getTotalFreeCoin() {
    return totalFreeCoin;
  }

  public void setTotalFreeCoin(Integer totalFreeCoin) {
    this.totalFreeCoin = totalFreeCoin;
  }

  public Integer getSignTime() {
    return signTime;
  }

  public void setSignTime(Integer signTime) {
    this.signTime = signTime;
  }

  public Integer getCardType() {
    return cardType;
  }

  public void setCardType(Integer cardType) {
    this.cardType = cardType;
  }

  public Integer getCardSaleNum() {
    return cardSaleNum;
  }

  public void setCardSaleNum(Integer cardSaleNum) {
    this.cardSaleNum = cardSaleNum;
  }

  public Integer getCardTotalNum() {
    return cardTotalNum;
  }

  public void setCardTotalNum(Integer cardTotalNum) {
    this.cardTotalNum = cardTotalNum;
  }
}
