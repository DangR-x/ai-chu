package com.aichu.admin.vo.response;

/**
 * @ClassName AdminRoleListResponse
 * @Author yuan.shuai
 * @Description 角色列表
 * @Date 2019/8/1
 * @Version 1.0.0
 */
public class AdminRoleListResponse {

    private Integer id;

    private String roleName;

    private String roleCode;

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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
