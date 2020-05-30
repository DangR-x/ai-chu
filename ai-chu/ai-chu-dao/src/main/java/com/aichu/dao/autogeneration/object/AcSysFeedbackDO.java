package com.aichu.dao.autogeneration.object;

import java.io.Serializable;
import java.util.Date;

/**
 * 该实体BEAN是由系统生成请勿修改
 *
 * Created by system on 2020/03/10
 */
public class AcSysFeedbackDO implements Serializable {
    /** 主键 */
    private Integer id;

    /** 反馈用户ID */
    private Integer userId;

    /** 反馈内容 */
    private String content;

    /** 反馈图片信息 */
    private String contentImg;

    /** 处理管理员用户ID */
    private Integer dealAdminUserId;

    /** 处理意见 */
    private String comment;

    /** 反馈来源（0-APP） */
    private Integer sourceType;

    /** 反馈信息类型（0-举报，1-意见反馈） */
    private Integer feedbackType;

    /** 处理状态（0-未处理 1-采纳 2-拒绝） */
    private Integer status;

    /** 创建时间 */
    private Date createTime;

    /** 是否删除（0-否，1-是） */
    private Integer isDelete;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContentImg() {
        return contentImg;
    }

    public void setContentImg(String contentImg) {
        this.contentImg = contentImg;
    }

    public Integer getDealAdminUserId() {
        return dealAdminUserId;
    }

    public void setDealAdminUserId(Integer dealAdminUserId) {
        this.dealAdminUserId = dealAdminUserId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getSourceType() {
        return sourceType;
    }

    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }

    public Integer getFeedbackType() {
        return feedbackType;
    }

    public void setFeedbackType(Integer feedbackType) {
        this.feedbackType = feedbackType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", content=").append(content);
        sb.append(", contentImg=").append(contentImg);
        sb.append(", dealAdminUserId=").append(dealAdminUserId);
        sb.append(", comment=").append(comment);
        sb.append(", sourceType=").append(sourceType);
        sb.append(", feedbackType=").append(feedbackType);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", isDelete=").append(isDelete);
        sb.append("]");
        return sb.toString();
    }
}