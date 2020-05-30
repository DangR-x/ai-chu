package com.aichu.app.vo.response;


import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName WxPayAppOrderResultResponse
 * @Description 微信支付参数
 * @Author Melon
 * @Date 2020/2/27 16:33
 **/
public class WxPayAppOrderResultResponse {

  @ApiModelProperty(name = "appid", value = "appid")
  private String appid;

  @ApiModelProperty(name = "partnerid", value = "partnerid")
  private String partnerid;

  @ApiModelProperty(name = "prepayid", value = "prepayid")
  private String prepayid;

  @ApiModelProperty(name = "packageX", value = "packageX")
  private String packageX;

  @ApiModelProperty(name = "noncestr", value = "noncestr")
  private String noncestr;

  @ApiModelProperty(name = "timestamp", value = "timestamp")
  private String timestamp;

  @ApiModelProperty(name = "sign", value = "sign")
  private String sign;

  public String getAppid() {
    return appid;
  }

  public void setAppid(String appid) {
    this.appid = appid;
  }

  public String getPartnerid() {
    return partnerid;
  }

  public void setPartnerid(String partnerid) {
    this.partnerid = partnerid;
  }

  public String getPrepayid() {
    return prepayid;
  }

  public void setPrepayid(String prepayid) {
    this.prepayid = prepayid;
  }

  public String getPackageX() {
    return packageX;
  }

  public void setPackageX(String packageX) {
    this.packageX = packageX;
  }

  public String getNoncestr() {
    return noncestr;
  }

  public void setNoncestr(String noncestr) {
    this.noncestr = noncestr;
  }

  public String getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }

  public String getSign() {
    return sign;
  }

  public void setSign(String sign) {
    this.sign = sign;
  }
}
