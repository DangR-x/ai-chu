package com.aichu.app.vo.response;

import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName UserMessageResponse
 * @Description 用户消息列表响应Response
 * @Author Melon
 * @Date 2019/7/19 10:41
 * @Version 1.0.0
 **/
public class UserMessageResponse {

  @ApiModelProperty(name = "messageId", value = "消息ID")
  private Integer messageId;

  @ApiModelProperty(name = "messageTitle", value = "消息标题")
  private String messageTitle;

  @ApiModelProperty(name = "messageContent", value = "消息内容")
  private String messageContent;

  @ApiModelProperty(name = "messageType", value = "消息类型(0-系统消息，1-用户消息)")
  private String messageType;

  @ApiModelProperty(name = "isRead", value = "阅读状态（0-未读，1-已读）)")
  private Integer isRead;

  @ApiModelProperty(name = "createTime", value = "发布时间")
  private String createTime;

  public Integer getMessageId() {
    return messageId;
  }

  public void setMessageId(Integer messageId) {
    this.messageId = messageId;
  }

  public String getMessageTitle() {
    return messageTitle;
  }

  public void setMessageTitle(String messageTitle) {
    this.messageTitle = messageTitle;
  }

  public String getMessageContent() {
    return messageContent;
  }

  public void setMessageContent(String messageContent) {
    this.messageContent = messageContent;
  }

  public String getMessageType() {
    return messageType;
  }

  public void setMessageType(String messageType) {
    this.messageType = messageType;
  }

  public Integer getIsRead() {
    return isRead;
  }

  public void setIsRead(Integer isRead) {
    this.isRead = isRead;
  }

  public String getCreateTime() {
    return createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }
}
