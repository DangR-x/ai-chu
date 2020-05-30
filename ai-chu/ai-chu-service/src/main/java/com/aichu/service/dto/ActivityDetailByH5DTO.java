package com.aichu.service.dto;

/**
 * @ClassName ActivityDetailDTO
 * @Description 活动详情响应DTO
 * @Author Melon
 * @Date 2019/7/19 10:41
 * @Version 1.0.0
 **/
public class ActivityDetailByH5DTO {

  private Integer activityId;

  private String activityImage;

  private String activityDetailTitle;

  private String activityDetailContent;

  private Long activityStartTime;

  private Long activityEndTime;

  private Long activityApplyStartTime;

  private Long activityApplyEndTime;

  private String activityAddress;

  private Double latitude;

  private Double longitude;

  private Integer activityCost;

  private Integer isSysActivity;

  private Integer isSign;

  public Integer getActivityId() {
    return activityId;
  }

  public void setActivityId(Integer activityId) {
    this.activityId = activityId;
  }

  public String getActivityImage() {
    return activityImage;
  }

  public void setActivityImage(String activityImage) {
    this.activityImage = activityImage;
  }

  public String getActivityDetailTitle() {
    return activityDetailTitle;
  }

  public void setActivityDetailTitle(String activityDetailTitle) {
    this.activityDetailTitle = activityDetailTitle;
  }

  public String getActivityDetailContent() {
    return activityDetailContent;
  }

  public void setActivityDetailContent(String activityDetailContent) {
    this.activityDetailContent = activityDetailContent;
  }

  public Long getActivityStartTime() {
    return activityStartTime;
  }

  public void setActivityStartTime(Long activityStartTime) {
    this.activityStartTime = activityStartTime;
  }

  public Long getActivityEndTime() {
    return activityEndTime;
  }

  public void setActivityEndTime(Long activityEndTime) {
    this.activityEndTime = activityEndTime;
  }

  public Long getActivityApplyStartTime() {
    return activityApplyStartTime;
  }

  public void setActivityApplyStartTime(Long activityApplyStartTime) {
    this.activityApplyStartTime = activityApplyStartTime;
  }

  public Long getActivityApplyEndTime() {
    return activityApplyEndTime;
  }

  public void setActivityApplyEndTime(Long activityApplyEndTime) {
    this.activityApplyEndTime = activityApplyEndTime;
  }

  public String getActivityAddress() {
    return activityAddress;
  }

  public void setActivityAddress(String activityAddress) {
    this.activityAddress = activityAddress;
  }

  public Double getLatitude() {
    return latitude;
  }

  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }

  public Double getLongitude() {
    return longitude;
  }

  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }

  public Integer getActivityCost() {
    return activityCost;
  }

  public void setActivityCost(Integer activityCost) {
    this.activityCost = activityCost;
  }

  public Integer getIsSysActivity() {
    return isSysActivity;
  }

  public void setIsSysActivity(Integer isSysActivity) {
    this.isSysActivity = isSysActivity;
  }

  public Integer getIsSign() {
    return isSign;
  }

  public void setIsSign(Integer isSign) {
    this.isSign = isSign;
  }
}
