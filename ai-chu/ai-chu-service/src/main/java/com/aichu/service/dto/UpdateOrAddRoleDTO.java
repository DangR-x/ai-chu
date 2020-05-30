package com.aichu.service.dto;

/**
 * @ClassName UpdateOrAddRoleDTO
 * @Author yuan.shuai
 * @Description 修改或者新增角色
 * @Date 2019/8/1
 * @Version 1.0.0
 */
public class UpdateOrAddRoleDTO {

    private Integer id;

    private String roleCode;

    private String roleName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
