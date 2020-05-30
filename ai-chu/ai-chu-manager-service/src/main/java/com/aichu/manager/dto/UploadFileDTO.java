package com.aichu.manager.dto;

/**
 * @ClassName UploadFileDTO
 * @Description 文件上传信息响应DTO
 * @Author Melon
 * @Date 2019/7/19 10:41
 * @Version 1.0.0
 **/
public class UploadFileDTO {

  private String qiuNiuOSSUploadCertificate;

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
