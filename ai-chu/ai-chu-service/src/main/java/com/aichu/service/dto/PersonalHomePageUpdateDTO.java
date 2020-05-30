package com.aichu.service.dto;

/**
 * @ClassName PersonalHomePageUpdateDTO
 * @Description 用户个人中心信息请求DTO
 * @Author Melon
 * @Date 2019/7/19 10:41
 * @Version 1.0.0
 **/
public class PersonalHomePageUpdateDTO {

  private String userName;

  private String userHead;

  private Integer userSex;

  private String userBirthDate;

  private Integer userHeight;

  private Integer userWeight;

  private Integer userWork;

  private Integer userConstellation;

  private Integer provinceId;

  private Integer cityId;

  private Integer areaId;

  private Integer userChartCost;

  private String userSignature;

  private String userPhotoAlbumStr;

  private String userImpressionStr;

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserHead() {
    return userHead;
  }

  public void setUserHead(String userHead) {
    this.userHead = userHead;
  }

  public Integer getUserSex() {
    return userSex;
  }

  public void setUserSex(Integer userSex) {
    this.userSex = userSex;
  }

  public String getUserBirthDate() {
    return userBirthDate;
  }

  public void setUserBirthDate(String userBirthDate) {
    this.userBirthDate = userBirthDate;
  }

  public Integer getUserHeight() {
    return userHeight;
  }

  public void setUserHeight(Integer userHeight) {
    this.userHeight = userHeight;
  }

  public Integer getUserWeight() {
    return userWeight;
  }

  public void setUserWeight(Integer userWeight) {
    this.userWeight = userWeight;
  }

  public Integer getUserWork() {
    return userWork;
  }

  public void setUserWork(Integer userWork) {
    this.userWork = userWork;
  }

  public Integer getUserConstellation() {
    return userConstellation;
  }

  public void setUserConstellation(Integer userConstellation) {
    this.userConstellation = userConstellation;
  }

  public Integer getProvinceId() {
    return provinceId;
  }

  public void setProvinceId(Integer provinceId) {
    this.provinceId = provinceId;
  }

  public Integer getCityId() {
    return cityId;
  }

  public void setCityId(Integer cityId) {
    this.cityId = cityId;
  }

  public Integer getAreaId() {
    return areaId;
  }

  public void setAreaId(Integer areaId) {
    this.areaId = areaId;
  }

  public Integer getUserChartCost() {
    return userChartCost;
  }

  public void setUserChartCost(Integer userChartCost) {
    this.userChartCost = userChartCost;
  }

  public String getUserSignature() {
    return userSignature;
  }

  public void setUserSignature(String userSignature) {
    this.userSignature = userSignature;
  }

  public String getUserPhotoAlbumStr() {
    return userPhotoAlbumStr;
  }

  public void setUserPhotoAlbumStr(String userPhotoAlbumStr) {
    this.userPhotoAlbumStr = userPhotoAlbumStr;
  }

  public String getUserImpressionStr() {
    return userImpressionStr;
  }

  public void setUserImpressionStr(String userImpressionStr) {
    this.userImpressionStr = userImpressionStr;
  }
}
