package com.aichu.app.vo.response;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @ClassName PersonalHomePageResponse
 * @Description 用户个人中心信息响应Response
 * @Author Melon
 * @Date 2019/7/19 10:41
 * @Version 1.0.0
 **/
public class PersonalHomePageResponse {

  @ApiModelProperty(name = "userId", value = "用户ID")
  private Integer userId;

  @ApiModelProperty(name = "userAcId", value = "用户内部UID")
  private String userAcId;

  @ApiModelProperty(name = "userName", value = "用户昵称")
  private String userName;

  @ApiModelProperty(name = "userHead", value = "用户头像")
  private String userHead;

  @ApiModelProperty(name = "userSex", value = "用户性别（0-男，1-女）")
  private Integer userSex;

  @ApiModelProperty(name = "userBirth", value = "用户生日")
  private String userBirth;

  @ApiModelProperty(name = "userAge", value = "用户年龄")
  private Integer userAge;

  @ApiModelProperty(name = "userHeight", value = "用户身高")
  private String userHeight;

  @ApiModelProperty(name = "userWeight", value = "用户体重")
  private String userWeight;

  @ApiModelProperty(name = "userWork", value = "用户职业")
  private String userWork;

  @ApiModelProperty(name = "userConstellation", value = "用户星座")
  private String userConstellation;

  @ApiModelProperty(name = "省份ID", value = "省份ID")
  private Integer provinceId;

  @ApiModelProperty(name = "城市ID", value = "城市ID")
  private Integer cityId;

  @ApiModelProperty(name = "区域ID", value = "区域ID")
  private Integer areaId;

  @ApiModelProperty(name = "userAddress", value = "用户地址")
  private String userAddress;

  @ApiModelProperty(name = "userChartCost", value = "用户聊天费用（单位：分钟）")
  private Integer userChartCost;

  @ApiModelProperty(name = "userSignature", value = "用户个性签名")
  private String userSignature;

  @ApiModelProperty(name = "userFansNum", value = "用户粉丝数")
  private Integer userFansNum;

  @ApiModelProperty(name = "userLike", value = "用户关注数")
  private Integer userLike;

  @ApiModelProperty(name = "isMyselfLike", value = "我是否已经关注过当前用户（0-否，1-是）")
  private Integer isMyselfLike;

  @ApiModelProperty(name = "userPhotoAlbumList", value = "用户相册墙列表")
  private List<String> userPhotoAlbumList;

  @ApiModelProperty(name = "userCommentScore", value = "用户评分")
  private Double userCommentScore;

  @ApiModelProperty(name = "userImpressionLabel", value = "用户印象标签")
  private List<String> userImpressionLabel;

  @ApiModelProperty(name = "isAgency", value = "是否是代理商(0-否，1-是)")
  private Integer isAgency;

  @ApiModelProperty(name = "isAnchor", value = "是否是主播(0-否，1-是)")
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
