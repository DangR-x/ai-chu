package com.aichu.dao.workstation.object;

/**
 * @Description 操作日志
 * @Author yuan.shuai
 * @Date  2019/11/9
 * @Version 1.1.0
 */
public class AcAdminActionLogDao {
    /** 主键ID */
    private Integer id;

    /** 管理员用户ID */
    private Integer adminUserId;

    /** 管理员账号名 */
    private String adminUserName;

    /** 操作IP */
    private String actionIp;

    /** 操作模块 */
    private String actionModel;

    /** 操作内容 */
    private String actionLog;

    /** 是否删除（0-否，1-是） */
    private Integer isDelete;

    /** 创建时间 */
    private String createTime;

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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getAdminUserName() {
        return adminUserName;
    }

    public void setAdminUserName(String adminUserName) {
        this.adminUserName = adminUserName;
    }
}