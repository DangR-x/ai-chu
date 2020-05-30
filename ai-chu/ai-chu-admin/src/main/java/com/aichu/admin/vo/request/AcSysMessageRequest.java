package com.aichu.admin.vo.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 该实体BEAN是由系统生成请勿修改
 *
 * Created by system on 2020/02/22
 */
public class AcSysMessageRequest implements Serializable {
    /** 主键ID */
    @ApiModelProperty(name = "id", value = "主键ID",hidden = false)
    private Integer id;

    /** 消息标题 */
    @ApiModelProperty(name = "messageTitle", value = "消息标题",required = true,hidden = false)
    @NotBlank(message = "消息标题不能为空")
    private String messageTitle;

    /** 消息内容 */
    @ApiModelProperty(name = "messageContent", value = "消息内容",required = true,hidden = false)
    @NotBlank(message = "消息内容不能为空")
    private String messageContent;

    /** 标签类型(0-系统消息，1-用户消息) */
    @ApiModelProperty(name = "messageTitle", value = "标签类型(0-系统消息，1-用户消息)",required = true,hidden = false)
    @NotNull(message = "标签类型不能为空")
    private Integer messageType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getMessageType() {
        return messageType;
    }

    public void setMessageType(Integer messageType) {
        this.messageType = messageType;
    }

}