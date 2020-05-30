package com.aichu.service.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName AppVersionInfoResponse
 * @Description App版本信息响应Response
 * @Author Melon
 * @Date 2019/7/19 10:41
 * @Version 1.0.0
 **/
public class AppVersionInfoDTO {

  private Integer isUpdate;

  private Integer isCompelUpdate;

  private String loadUrl;

  public Integer getIsUpdate() {
    return isUpdate;
  }

  public void setIsUpdate(Integer isUpdate) {
    this.isUpdate = isUpdate;
  }

  public String getLoadUrl() {
    return loadUrl;
  }

  public void setLoadUrl(String loadUrl) {
    this.loadUrl = loadUrl;
  }

  public Integer getIsCompelUpdate() {
    return isCompelUpdate;
  }

  public void setIsCompelUpdate(Integer isCompelUpdate) {
    this.isCompelUpdate = isCompelUpdate;
  }
}
