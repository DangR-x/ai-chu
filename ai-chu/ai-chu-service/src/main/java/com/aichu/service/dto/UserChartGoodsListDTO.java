package com.aichu.service.dto;

/**
 * @ClassName UserChartGoodsListDTO
 * @Description 聊天商品信息列表信息响应DTO
 * @Author Melon
 * @Date 2019/7/19 10:41
 * @Version 1.0.0
 **/
public class UserChartGoodsListDTO {

  private Integer goodsId;

  private String goodsName;

  private String goodsImage;

  private Integer goodsMoney;

  private String functionDes;

  public Integer getGoodsId() {
    return goodsId;
  }

  public void setGoodsId(Integer goodsId) {
    this.goodsId = goodsId;
  }

  public String getGoodsName() {
    return goodsName;
  }

  public void setGoodsName(String goodsName) {
    this.goodsName = goodsName;
  }

  public String getGoodsImage() {
    return goodsImage;
  }

  public void setGoodsImage(String goodsImage) {
    this.goodsImage = goodsImage;
  }

  public Integer getGoodsMoney() {
    return goodsMoney;
  }

  public void setGoodsMoney(Integer goodsMoney) {
    this.goodsMoney = goodsMoney;
  }

  public String getFunctionDes() {
    return functionDes;
  }

  public void setFunctionDes(String functionDes) {
    this.functionDes = functionDes;
  }
}
