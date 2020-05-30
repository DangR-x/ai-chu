package com.aichu.service.dto;

import java.util.List;

/**
 * @ClassName AdminRolePermissionDTO
 * @Author yuan.shuai
 * @Description 角色权限DTO
 * @Date 2019/8/2
 * @Version 1.0.0
 */
public class AdminRolePermissionDTO {

    private Integer roleId;

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
