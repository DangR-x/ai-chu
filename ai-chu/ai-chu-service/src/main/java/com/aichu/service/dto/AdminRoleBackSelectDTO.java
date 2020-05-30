package com.aichu.service.dto;

/**
 * @ClassName AdminRoleBackSelectDTO
 * @Author yuan.shuai
 * @Description 后台角色检索
 * @Date 2019/7/31
 * @Version 1.0.0
 */
public class AdminRoleBackSelectDTO {

    private Integer id;

    private String roleName;

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
}
