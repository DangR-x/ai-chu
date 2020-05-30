package com.aichu.admin.vo.response;

/**
 * @ClassName AdminRoleSelectResponse
 * @Author yuan.shuai
 * @Description 角色查询条件
 * @Date 2019/7/31
 * @Version 1.0.0
 */
public class AdminRoleSelectResponse {

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
