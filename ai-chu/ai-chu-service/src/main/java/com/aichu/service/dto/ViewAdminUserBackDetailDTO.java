package com.aichu.service.dto;

import java.util.List;

/**
 * @ClassName ViewAdminUserBackDetailDTO
 * @Author yuan.shuai
 * @Description 查看后台管理员详情查询DTO
 * @Date 2019/7/30
 * @Version 1.0.0
 */
public class ViewAdminUserBackDetailDTO {
    private Integer id;

    private String userName;

    private String aliasName;

    private String status;

    private String createTime;

    private Integer type;

    private List<String> roleNameList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
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

    public List<String> getRoleNameList() {
        return roleNameList;
    }

    public void setRoleNameList(List<String> roleNameList) {
        this.roleNameList = roleNameList;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
