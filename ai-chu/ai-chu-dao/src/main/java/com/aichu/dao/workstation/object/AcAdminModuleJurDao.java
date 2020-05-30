package com.aichu.dao.workstation.object;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName AcAdminModuleJurDao
 * @Author yuan.shuai
 * @Description 后台菜单角色权限实体
 * @Date 2019/7/20
 * @Version 1.0.0
 */
public class AcAdminModuleJurDao implements Serializable {
    /** 主键ID */
    private Integer id;

    /** 对应菜单模块ID */
    private Integer moduleId;

    /** 名称 */
    private String name;

    /** 访问链接 */
    private String url;

    /** 默认root超级管理员必须访问所有 */
    private String roleCode;

    /** 权限代码 */
    private String permsCode;

    /** 描述 */
    private String description;

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

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getPermsCode() {
        return permsCode;
    }

    public void setPermsCode(String permsCode) {
        this.permsCode = permsCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        sb.append(", moduleId=").append(moduleId);
        sb.append(", name=").append(name);
        sb.append(", url=").append(url);
        sb.append(", roleCode=").append(roleCode);
        sb.append(", permsCode=").append(permsCode);
        sb.append(", description=").append(description);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}