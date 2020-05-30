package com.aichu.app.vo.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @ClassName UserCommentScoreRequest
 * @Description 用户评论数据模型Request
 * @Author Melon
 * @Date 2019/7/19 10:52
 * @Version 1.0.0
 **/
public class UserCommentScoreRequest {

    @ApiModelProperty(name="aimUserId",value="目标用户ID",required=true,hidden=false)
    @NotNull(message="目标用户ID不可为空")
    private Integer aimUserId;

    @ApiModelProperty(name="commentScore",value="用户评分",required=true,hidden=false)
    @NotNull(message="用户评分不可为空")
    private Integer commentScore;

    @ApiModelProperty(name="commentScoreLabelId",value="评论标签ID字符串（逗号分割）",required=true,hidden=false)
    @NotBlank(message="评论标签ID字符串不可为空")
    private String commentScoreLabelId;

    public Integer getAimUserId() {
        return aimUserId;
    }

    public void setAimUserId(Integer aimUserId) {
        this.aimUserId = aimUserId;
    }

    public Integer getCommentScore() {
        return commentScore;
    }

    public void setCommentScore(Integer commentScore) {
        this.commentScore = commentScore;
    }

    public String getCommentScoreLabelId() {
        return commentScoreLabelId;
    }

    public void setCommentScoreLabelId(String commentScoreLabelId) {
        this.commentScoreLabelId = commentScoreLabelId;
    }
}
