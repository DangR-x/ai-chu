package com.aichu.dao.autogeneration.object;

import java.io.Serializable;
import java.util.Date;

/**
 * 该实体BEAN是由系统生成请勿修改
 *
 * Created by system on 2020/03/10
 */
public class AcUserScoreDO implements Serializable {
    /** 主键ID */
    private Integer id;

    /** 目标评论用户ID */
    private Integer aimUserId;

    /** 评分（0-5） */
    private Integer commentLevel;

    /** 评论标签ID字符串 */
    private String commentLableId;

    /** 评论用户ID */
    private Integer commentUserId;

    /** 是否删除（0-否，1-是） */
    private Integer isDelete;

    /** 创建时间 */
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAimUserId() {
        return aimUserId;
    }

    public void setAimUserId(Integer aimUserId) {
        this.aimUserId = aimUserId;
    }

    public Integer getCommentLevel() {
        return commentLevel;
    }

    public void setCommentLevel(Integer commentLevel) {
        this.commentLevel = commentLevel;
    }

    public String getCommentLableId() {
        return commentLableId;
    }

    public void setCommentLableId(String commentLableId) {
        this.commentLableId = commentLableId;
    }

    public Integer getCommentUserId() {
        return commentUserId;
    }

    public void setCommentUserId(Integer commentUserId) {
        this.commentUserId = commentUserId;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", aimUserId=").append(aimUserId);
        sb.append(", commentLevel=").append(commentLevel);
        sb.append(", commentLableId=").append(commentLableId);
        sb.append(", commentUserId=").append(commentUserId);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}