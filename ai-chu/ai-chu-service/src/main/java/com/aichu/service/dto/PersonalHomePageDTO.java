package com.aichu.service.dto;

import java.util.List;

/**
 * @ClassName PersonalHomePageResponse
 * @Description 用户个人中心信息响应Response
 * @Author Melon
 * @Date 2019/7/19 10:41
 * @Version 1.0.0
 **/
public class PersonalHomePageDTO {

  private Integer userId;

  private String userAcId;

  private String userName;

  private String userHead;

  private Integer userSex;

  private String userBirth;

  private Integer userAge;

  private String userHeight;

  private String userWeight;

  private String userWork;

  private String userConstellation;

  private Integer provinceId;

  private Integer cityId;

  private Integer areaId;

  private String userAddress;

  private Integer userChartCost;

  private String userSignature;

  private Integer userFansNum;

  private Integer userLike;

  private Integer isMyselfLike;

  private List<String> userPhotoAlbumList;

  private Double userCommentScore;

  private List<String> userImpressionLabel;

  private Integer isAgency;

  private Integer isAnchor;

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

  public Integer getUserAge() {
    return userAge;
  }

  public void setUserAge(Integer userAge) {
    this.userAge = userAge;
  }

  public String getUserHeight() {
    return userHeight;
  }

  public void setUserHeight(String userHeight) {
    this.userHeight = userHeight;
  }

  public String getUserWeight() {
    return userWeight;
  }

  public void setUserWeight(String userWeight) {
    this.userWeight = userWeight;
  }

  public String getUserWork() {
    return userWork;
  }

  public void setUserWork(String userWork) {
    this.userWork = userWork;
  }

  public String getUserConstellation() {
    return userConstellation;
  }

  public void setUserConstellation(String userConstellation) {
    this.userConstellation = userConstellation;
  }

  public String getUserAddress() {
    return userAddress;
  }

  public void setUserAddress(String userAddress) {
    this.userAddress = userAddress;
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

  public Integer getUserFansNum() {
    return userFansNum;
  }

  public void setUserFansNum(Integer userFansNum) {
    this.userFansNum = userFansNum;
  }

  public Integer getUserLike() {
    return userLike;
  }

  public void setUserLike(Integer userLike) {
    this.userLike = userLike;
  }

  public Integer getIsMyselfLike() {
    return isMyselfLike;
  }

  public void setIsMyselfLike(Integer isMyselfLike) {
    this.isMyselfLike = isMyselfLike;
  }

  public List<String> getUserPhotoAlbumList() {
    return userPhotoAlbumList;
  }

  public void setUserPhotoAlbumList(List<String> userPhotoAlbumList) {
    this.userPhotoAlbumList = userPhotoAlbumList;
  }

  public Double getUserCommentScore() {
    return userCommentScore;
  }

  public void setUserCommentScore(Double userCommentScore) {
    this.userCommentScore = userCommentScore;
  }

  public List<String> getUserImpressionLabel() {
    return userImpressionLabel;
  }

  public void setUserImpressionLabel(List<String> userImpressionLabel) {
    this.userImpressionLabel = userImpressionLabel;
  }

  public String getUserBirth() {
    return userBirth;
  }

  public void setUserBirth(String userBirth) {
    this.userBirth = userBirth;
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

  public Integer getIsAgency() {
    return isAgency;
  }

  public void setIsAgency(Integer isAgency) {
    this.isAgency = isAgency;
  }

  public Integer getIsAnchor() {
    return isAnchor;
  }

  public void setIsAnchor(Integer isAnchor) {
    this.isAnchor = isAnchor;
  }
}
