package com.aichu.admin.vo.response;

import java.util.List;

/**
 * @ClassName ViewAdminUserResponse
 * @Author yuan.shuai
 * @Description 管理员信息（查看详情）
 * @Date 2019/12/17
 * @Version 1.0.0
 */
public class ViewAdminUserResponse {
    private Integer id;

    private String userName;

    private String aliasName;

    private String status;

    private String createTime;

    private String headImg;

    /** 管理员类型（0-管理员，1-开发商，2-商户）*/
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

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
