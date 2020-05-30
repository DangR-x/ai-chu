package com.aichu.service.dto;

/**
 * @ClassName CustomerInfoDTO
 * @Description 用户客服信息响应DTO
 * @Author Melon
 * @Date 2019/7/19 10:41
 * @Version 1.0.0
 **/
public class CustomerInfoDTO {

  private String keys;

  private String keyName;

  private String keyValue;

  private String keyComment;

  public String getKeys() {
    return keys;
  }

  public void setKeys(String keys) {
    this.keys = keys;
  }

  public String getKeyName() {
    return keyName;
  }

  public void setKeyName(String keyName) {
    this.keyName = keyName;
  }

  public String getKeyValue() {
    return keyValue;
  }

  public void setKeyValue(String keyValue) {
    this.keyValue = keyValue;
  }

  public String getKeyComment() {
    return keyComment;
  }

  public void setKeyComment(String keyComment) {
    this.keyComment = keyComment;
  }
}
