package com.aichu.dao.autogeneration.object;

import java.io.Serializable;
import java.util.Date;

/**
 * 该实体BEAN是由系统生成请勿修改
 *
 * Created by system on 2020/03/10
 */
public class AcUserOauthDO implements Serializable {
    /** 主键ID */
    private Integer id;

    /** 用户ID */
    private Integer userId;

    /** 微信OpenId */
    private String openId;

    /** 微信UnionId */
    private String unionId;

    /** 支付宝OpenId */
    private String aliOpenId;

    /** 第三方账户ID */
    private String oauthUserId;

    /** 昵称 */
    private String nickName;

    /** 头像 */
    private String headImg;

    /** 渠道：(0-微信，1-支付宝) */
    private Integer oauthType;

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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public String getAliOpenId() {
        return aliOpenId;
    }

    public void setAliOpenId(String aliOpenId) {
        this.aliOpenId = aliOpenId;
    }

    public String getOauthUserId() {
        return oauthUserId;
    }

    public void setOauthUserId(String oauthUserId) {
        this.oauthUserId = oauthUserId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public Integer getOauthType() {
        return oauthType;
    }

    public void setOauthType(Integer oauthType) {
        this.oauthType = oauthType;
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
        sb.append(", userId=").append(userId);
        sb.append(", openId=").append(openId);
        sb.append(", unionId=").append(unionId);
        sb.append(", aliOpenId=").append(aliOpenId);
        sb.append(", oauthUserId=").append(oauthUserId);
        sb.append(", nickName=").append(nickName);
        sb.append(", headImg=").append(headImg);
        sb.append(", oauthType=").append(oauthType);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}