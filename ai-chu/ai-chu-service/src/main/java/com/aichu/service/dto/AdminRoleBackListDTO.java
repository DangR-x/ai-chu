package com.aichu.service.dto;

/**
 * @ClassName AdminRoleBackListDTO
 * @Author yuan.shuai
 * @Description 后台角色DTO
 * @Date 2019/7/31
 * @Version 1.0.0
 */
public class AdminRoleBackListDTO {

    private Integer id;

    private String roleName;

    private String roleCode;

    private String status;

    private String createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
