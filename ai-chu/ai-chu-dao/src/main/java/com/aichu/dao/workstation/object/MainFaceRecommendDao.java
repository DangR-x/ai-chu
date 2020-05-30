package com.aichu.dao.workstation.object;

/**
 * @ClassName MainFaceRecommendDao
 * @Description 首页用户系统列表信息响应Dao
 * @Author Melon
 * @Date 2019/7/19 10:41
 * @Version 1.0.0
 **/
public class MainFaceRecommendDao {

  private Integer userId;

  private String userAcId;

  private String userName;

  private Double distance;

  private Integer chartCost;

  private String userSignature;

  private String userPhotoAlbum;

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
