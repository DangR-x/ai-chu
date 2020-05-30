package com.aichu.app.vo.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @ClassName PersonalHomePageUpdateRequest
 * @Description 用户个人中心信息请求Request
 * @Author Melon
 * @Date 2019/7/19 10:41
 * @Version 1.0.0
 **/
public class PersonalHomePageUpdateRequest {

  @ApiModelProperty(name = "userName", value = "用户昵称", required=false, hidden=false)
  private String userName;

  @ApiModelProperty(name = "userHead", value = "用户头像", required=false, hidden=false)
  private String userHead;

  @ApiModelProperty(name = "userSex", value = "用户性别（0-男，1-女）", required=false, hidden=false)
  private Integer userSex;

  @ApiModelProperty(name = "userBirthDate", value = "用户出生日期（年-月-日）", required=false, hidden=false)
  private String userBirthDate;

  @ApiModelProperty(name = "userHeight", value = "用户身高标签ID", required=false, hidden=false)
  private Integer userHeight;

  @ApiModelProperty(name = "userWeight", value = "用户体重标签ID", required=false, hidden=false)
  private Integer userWeight;

  @ApiModelProperty(name = "userWork", value = "用户职业标签ID", required=false, hidden=false)
  private Integer userWork;

  @ApiModelProperty(name = "userConstellation", value = "用户星座标签ID", required=false, hidden=false)
  private Integer userConstellation;

  @ApiModelProperty(name="provinceId",value="省份ID",required=false,hidden=false)
  private Integer provinceId;

  @ApiModelProperty(name="cityId",value="城市ID",required=false,hidden=false)
  private Integer cityId;

  @ApiModelProperty(name="areaId",value="区域ID",required=false,hidden=false)
  private Integer areaId;

  @ApiModelProperty(name = "userChartCost", value = "用户聊天费用（单位：分钟）",required=false,hidden=false)
  private Integer userChartCost;

  @ApiModelProperty(name = "userSignature", value = "用户个性签名",required=false,hidden=false)
  private String userSignature;

  @ApiModelProperty(name = "userPhotoAlbumStr", value = "用户相册墙(地址字符串，逗号分隔)",required=false,hidden=false)
  private String userPhotoAlbumStr;

  @ApiModelProperty(name = "userImpressionStr", value = "用户印象标签(标签ID字符串，逗号分隔)",required=false,hidden=false)
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
