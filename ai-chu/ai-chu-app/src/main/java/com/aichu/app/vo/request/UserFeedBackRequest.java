package com.aichu.app.vo.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @ClassName UserFeedBackRequest
 * @Description 用户举报投訴请求数据模型Request
 * @Author Melon
 * @Date 2019/7/19 10:52
 * @Version 1.0.0
 **/
public class UserFeedBackRequest {

    @ApiModelProperty(name="feedBackType",value="反馈类型（0-举报，1-意见反馈）",required=true,hidden=false)
    @NotNull(message="反馈类型不可为空")
    private Integer feedBackType;

    @ApiModelProperty(name="feedBackContent",value="反馈内容",required=true,hidden=false)
    @NotBlank(message="反馈内容不可为空")
    private String feedBackContent;

    @ApiModelProperty(name="feedBackContentImg",value="反馈内容图片（地址链接字符串）",required=false,hidden=false)
    private String feedBackContentImg;

    public Integer getFeedBackType() {
        return feedBackType;
    }

    public void setFeedBackType(Integer feedBackType) {
        this.feedBackType = feedBackType;
    }

    public String getFeedBackContent() {
        return feedBackContent;
    }

    public void setFeedBackContent(String feedBackContent) {
        this.feedBackContent = feedBackContent;
    }

    public String getFeedBackContentImg() {
        return feedBackContentImg;
    }

    public void setFeedBackContentImg(String feedBackContentImg) {
        this.feedBackContentImg = feedBackContentImg;
    }
}
