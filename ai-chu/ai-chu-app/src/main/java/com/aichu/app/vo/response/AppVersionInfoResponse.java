package com.aichu.app.vo.response;

import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName AppVersionInfoResponse
 * @Description App版本信息响应Response
 * @Author Melon
 * @Date 2019/7/19 10:41
 * @Version 1.0.0
 **/
public class AppVersionInfoResponse {

  @ApiModelProperty(name = "isUpdate", value = "是否需要更新（0-否，1-是）")
  private Integer isUpdate;

  @ApiModelProperty(name = "isCompelUpdate", value = "是否需要强制更新（0-否，1-是）")
  private Integer isCompelUpdate;

  @ApiModelProperty(name = "loadUrl", value = "下载地址")
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
