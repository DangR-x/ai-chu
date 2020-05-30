package com.aichu.service.dto;

/**
 * @ClassName UserCommentScoreDTO
 * @Description 用户评论数据模型DTO
 * @Author Melon
 * @Date 2019/7/19 10:52
 * @Version 1.0.0
 **/
public class UserCommentScoreDTO {

    private Integer aimUserId;

    private Integer commentScore;

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
