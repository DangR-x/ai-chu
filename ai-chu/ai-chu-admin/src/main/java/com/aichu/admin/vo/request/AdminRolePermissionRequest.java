package com.aichu.admin.vo.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @ClassName AdminRolePermissionRequest
 * @Author yuan.shuai
 * @Description 角色权限修改
 * @Date 2019/8/2
 * @Version 1.0.0
 */
public class AdminRolePermissionRequest {

    @ApiModelProperty(name = "roleId", value = "角色ID",required = true, hidden = false)
    @NotNull(message = "角色ID不能为空")
    private Integer roleId;

    @ApiModelProperty(name = "jurIds", value = "菜单权限关联表ID", required = true, hidden = false)
    private List<Integer> jurIds;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public List<Integer> getJurIds() {
        return jurIds;
    }

    public void setJurIds(List<Integer> jurIds) {
        this.jurIds = jurIds;
    }
}
