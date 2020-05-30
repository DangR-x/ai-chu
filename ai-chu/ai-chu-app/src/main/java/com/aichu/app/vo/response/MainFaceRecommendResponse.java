package com.aichu.app.vo.response;

import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName MainFaceRecommendResponse
 * @Description 首页用户系统列表信息响应Response
 * @Author Melon
 * @Date 2019/7/19 10:41
 * @Version 1.0.0
 **/
public class MainFaceRecommendResponse {

  @ApiModelProperty(name = "userId", value = "用户ID")
  private Integer userId;

  @ApiModelProperty(name = "userAcId", value = "用户AccID")
  private String userAcId;

  @ApiModelProperty(name = "userName", value = "用户名称")
  private String userName;

  @ApiModelProperty(name = "distance", value = "用户距离")
  private Double distance;

  @ApiModelProperty(name = "chartCost", value = "聊天费用（单位：分钟）")
  private Integer chartCost;

  @ApiModelProperty(name = "userSignature", value = "用户个性签名")
  private String userSignature;

  @ApiModelProperty(name = "userPhotoAlbum", value = "用户相册背景")
  private String userPhotoAlbum;

  @ApiModelProperty(name = "impressionLabel", value = "用户印象标签")
  private String impressionLabel;

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public String getUserAcId() {
    return userAcId;
  }

  public void setUserAcId(String userAcId) {
    this.userAcId = userAcId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public Double getDistance() {
    return distance;
  }

  public void setDistance(Double distance) {
    this.distance = distance;
  }

  public Integer getChartCost() {
    return chartCost;
  }

  public void setChartCost(Integer chartCost) {
    this.chartCost = chartCost;
  }

  public String getUserSignature() {
    return userSignature;
  }

  public void setUserSignature(String userSignature) {
    this.userSignature = userSignature;
  }

  public String getUserPhotoAlbum() {
    return userPhotoAlbum;
  }

  public void setUserPhotoAlbum(String userPhotoAlbum) {
    this.userPhotoAlbum = userPhotoAlbum;
  }

  public String getImpressionLabel() {
    return impressionLabel;
  }

  public void setImpressionLabel(String impressionLabel) {
    this.impressionLabel = impressionLabel;
  }
}
