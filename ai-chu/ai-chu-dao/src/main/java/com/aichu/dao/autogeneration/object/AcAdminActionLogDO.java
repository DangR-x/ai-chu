package com.aichu.dao.autogeneration.object;

import java.io.Serializable;
import java.util.Date;

/**
 * 该实体BEAN是由系统生成请勿修改
 *
 * Created by system on 2020/03/10
 */
public class AcAdminActionLogDO implements Serializable {
    /** 主键ID */
    private Integer id;

    /** 管理员用户ID */
    private Integer adminUserId;

    /** 操作IP */
    private String actionIp;

    /** 操作模块 */
    private String actionModel;

    /** 操作内容 */
    private String actionLog;

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

    public Integer getAdminUserId() {
        return adminUserId;
    }

    public void setAdminUserId(Integer adminUserId) {
        this.adminUserId = adminUserId;
    }

    public String getActionIp() {
        return actionIp;
    }

    public void setActionIp(String actionIp) {
        this.actionIp = actionIp;
    }

    public String getActionModel() {
        return actionModel;
    }

    public void setActionModel(String actionModel) {
        this.actionModel = actionModel;
    }

    public String getActionLog() {
        return actionLog;
    }

    public void setActionLog(String actionLog) {
        this.actionLog = actionLog;
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
        sb.append(", adminUserId=").append(adminUserId);
        sb.append(", actionIp=").append(actionIp);
        sb.append(", actionModel=").append(actionModel);
        sb.append(", actionLog=").append(actionLog);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}