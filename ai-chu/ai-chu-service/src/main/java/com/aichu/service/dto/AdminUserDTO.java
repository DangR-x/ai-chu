package com.aichu.service.dto;

/**
 * @ClassName AdminUserDTO
 * @Author yuan.shuai
 * @Description 管理员信息DTO
 * @Date 2019/11/4
 * @Version 1.0.0
 */
public class AdminUserDTO {

    /** 管理员用户表ID */
    private Integer id;

    /** 用户账号 */
    private String userName;

    /** 密码 */
    private String password;

    /** 昵称别名 */
    private String aliasName;

    /** 是否删除（0-否，1-是） */
    private Integer isDelete;

    /** 管理员类型（0-管理员，1-开发商，2-商户）*/
    private Integer type;

    /** 创建时间 */
    private String createTime;

    private String headImg;

    private String roleNameList;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getRoleNameList() {
        return roleNameList;
    }

    public void setRoleNameList(String roleNameList) {
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
