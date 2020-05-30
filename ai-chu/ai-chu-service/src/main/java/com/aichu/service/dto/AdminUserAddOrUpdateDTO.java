package com.aichu.service.dto;

import java.util.List;

/**
 * @ClassName AdminUserAddOrUpdateDTO
 * @Author yuan.shuai
 * @Description 管理员新增或修改信息
 * @Date 2019/11/4
 * @Version 1.0.0
 */
public class AdminUserAddOrUpdateDTO {
    /** 管理员用户表ID */
    private Integer id;

    /** 用户账号 */
    private String userName;

    /** 密码 */
    private String password;

    /** 昵称别名 */
    private String aliasName;

    /** 管理员类型（0-管理员，1-开发商，2-商户）*/
    private Integer type;

    /** 管理员头像*/
    private String headImg;

    private List<Integer> roleIdList;

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

    public List<Integer> getRoleIdList() {
        return roleIdList;
    }

    public void setRoleIdList(List<Integer> roleIdList) {
        this.roleIdList = roleIdList;
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
