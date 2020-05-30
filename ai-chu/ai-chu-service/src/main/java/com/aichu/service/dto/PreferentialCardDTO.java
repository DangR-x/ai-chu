package com.aichu.service.dto;

/**
 * @ClassName PreferentialCardDTO
 * @Description 优惠卡信息列表信息响应DTO
 * @Author Melon
 * @Date 2019/7/19 10:41
 * @Version 1.0.0
 **/
public class PreferentialCardDTO {

  private Integer cardId;

  private String cardName;

  private Integer cardOriginalPrice;

  private Integer cardSalePrice;

  private String cardDetail;

  private Integer everyDayFreeCoin;

  private Integer totalFreeCoin;

  private Integer signTime;

  private Integer cardType;

  private Integer cardSaleNum;

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
