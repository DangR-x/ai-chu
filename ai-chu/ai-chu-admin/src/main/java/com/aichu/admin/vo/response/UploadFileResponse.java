package com.aichu.admin.vo.response;

import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName UploadFileResponse
 * @Description 文件上传信息响应Response
 * @Author Melon
 * @Date 2019/7/19 10:41
 * @Version 1.0.0
 **/
public class UploadFileResponse {

  @ApiModelProperty(name = "qiuNiuOSSUploadCertificate", value = "七牛云文件上传凭证")
  private String qiuNiuOSSUploadCertificate;

  @ApiModelProperty(name = "qiuNiuOSSUploadUrl", value = "七牛云文件上传域名地址")
  private String qiuNiuOSSUploadUrl;

  public String getQiuNiuOSSUploadCertificate() {
    return qiuNiuOSSUploadCertificate;
  }

  public void setQiuNiuOSSUploadCertificate(String qiuNiuOSSUploadCertificate) {
    this.qiuNiuOSSUploadCertificate = qiuNiuOSSUploadCertificate;
  }

  public String getQiuNiuOSSUploadUrl() {
    return qiuNiuOSSUploadUrl;
  }

  public void setQiuNiuOSSUploadUrl(String qiuNiuOSSUploadUrl) {
    this.qiuNiuOSSUploadUrl = qiuNiuOSSUploadUrl;
  }
}
