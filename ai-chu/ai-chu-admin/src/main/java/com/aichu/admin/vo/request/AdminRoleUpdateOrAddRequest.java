package com.aichu.admin.vo.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

/**
 * @ClassName AdminRoleUpdateOrAddRequest
 * @Author yuan.shuai
 * @Description 角色修改
 * @Date 2019/8/1
 * @Version 1.0.0
 */
public class AdminRoleUpdateOrAddRequest {

    @ApiModelProperty(name = "id", value = "角色ID", hidden = false)
    private Integer id;

    @ApiModelProperty(name = "roleCode", value = "角色Code", required = true, hidden = false)
    @NotBlank(message = "角色Code不能为空")
    private String roleCode;

    @ApiModelProperty(name = "roleName", value = "角色名称", required = true, hidden = false)
    @NotBlank(message = "角色名称不能为空")
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
