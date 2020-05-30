package com.aichu.dao.autogeneration.object;

import java.io.Serializable;
import java.util.Date;

/**
 * 该实体BEAN是由系统生成请勿修改
 *
 * Created by system on 2020/03/10
 */
public class AcSysLabelDO implements Serializable {
    /** 主键ID */
    private Integer id;

    /** 标签名称 */
    private String name;

    /** 标签操作信息 */
    private String actionDesc;

    /** 标签详情操作信息 */
    private String actionDetailDesc;

    /** 标签Code */
    private String code;

    /** 标签类型(0-身高，1-体重标签，2-职业标签，3-星座标签，4-印象标签，5-评论标签，6-签到金币) */
    private Integer type;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActionDesc() {
        return actionDesc;
    }

    public void setActionDesc(String actionDesc) {
        this.actionDesc = actionDesc;
    }

    public String getActionDetailDesc() {
        return actionDetailDesc;
    }

    public void setActionDetailDesc(String actionDetailDesc) {
        this.actionDetailDesc = actionDetailDesc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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
        sb.append(", name=").append(name);
        sb.append(", actionDesc=").append(actionDesc);
        sb.append(", actionDetailDesc=").append(actionDetailDesc);
        sb.append(", code=").append(code);
        sb.append(", type=").append(type);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}