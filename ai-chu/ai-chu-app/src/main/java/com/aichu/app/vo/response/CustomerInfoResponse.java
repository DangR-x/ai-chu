package com.aichu.app.vo.response;

import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName CustomerInfoResponse
 * @Description 用户客服信息响应Response
 * @Author Melon
 * @Date 2019/7/19 10:41
 * @Version 1.0.0
 **/
public class CustomerInfoResponse {

  @ApiModelProperty(name = "keys", value = "关键词KEY")
  private String keys;

  @ApiModelProperty(name = "keyName", value = "关键词名称")
  private String keyName;

  @ApiModelProperty(name = "keyValue", value = "关键词值")
  private String keyValue;

  @ApiModelProperty(name = "keyComment", value = "关键词信息")
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
