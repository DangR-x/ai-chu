package com.aichu.service.dto;

import java.util.List;

/**
 * @ClassName EditorAdminUserBackDTO
 * @Author yuan.shuai
 * @Description 编辑后台管理员查询DTO
 * @Date 2019/7/30
 * @Version 1.0.0
 */
public class EditorAdminUserBackDTO {
    private Integer id;

    private String userName;

    private String passWord;

    private String aliasName;

    private String createTime;

    private Integer type;

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

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public List<Integer> getRoleIdList() {
        return roleIdList;
    }

    public void setRoleIdList(List<Integer> roleIdList) {
        this.roleIdList = roleIdList;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }
}
