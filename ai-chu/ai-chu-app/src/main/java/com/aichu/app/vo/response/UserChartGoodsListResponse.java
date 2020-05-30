package com.aichu.app.vo.response;

import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName UserChartGoodsListResponse
 * @Description 聊天商品信息列表信息响应Response
 * @Author Melon
 * @Date 2019/7/19 10:41
 * @Version 1.0.0
 **/
public class UserChartGoodsListResponse {

  @ApiModelProperty(name = "goodsId", value = "商品ID")
  private Integer goodsId;

  @ApiModelProperty(name = "goodsName", value = "商品名称")
  private String goodsName;

  @ApiModelProperty(name = "goodsImage", value = "商品头像")
  private String goodsImage;

  @ApiModelProperty(name = "goodsMoney", value = "商品价格")
  private Integer goodsMoney;

  @ApiModelProperty(name = "functionDes", value = "功能描述")
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
