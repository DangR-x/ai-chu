package com.aichu.service.dto;

/**
 * @ClassName LabelDictDTO
 * @Description 字典标签响应DTO
 * @Author Melon
 * @Date 2019/7/19 10:41
 * @Version 1.0.0
 **/
public class LabelDictDTO {

  private Integer labelId;

  private String labelName;

  private String labelCode;

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
