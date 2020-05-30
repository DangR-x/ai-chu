package com.aichu.app.vo.response;

import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName LabelDictResponse
 * @Description 字典标签响应Response
 * @Author Melon
 * @Date 2019/7/19 10:41
 * @Version 1.0.0
 **/
public class LabelDictResponse {

  @ApiModelProperty(name = "labelId", value = "标签ID")
  private Integer labelId;

  @ApiModelProperty(name = "labelName", value = "标签名称")
  private String labelName;

  @ApiModelProperty(name = "labelCode", value = "标签Code")
  private String labelCode;

  @ApiModelProperty(name = "labelType", value = "标签类型(0-身高标签，1-体重标签，2-职业标签，3-星座标签，4-印象标签，5-评论标签)")
  private Integer labelType;

  public Integer getLabelId() {
    return labelId;
  }

  public void setLabelId(Integer labelId) {
    this.labelId = labelId;
  }

  public String getLabelName() {
    return labelName;
  }

  public void setLabelName(String labelName) {
    this.labelName = labelName;
  }

  public String getLabelCode() {
    return labelCode;
  }

  public void setLabelCode(String labelCode) {
    this.labelCode = labelCode;
  }

  public Integer getLabelType() {
    return labelType;
  }

  public void setLabelType(Integer labelType) {
    this.labelType = labelType;
  }
}
