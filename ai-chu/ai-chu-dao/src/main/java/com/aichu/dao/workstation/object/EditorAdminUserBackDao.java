package com.aichu.dao.workstation.object;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName EditorAdminUserBackDao
 * @Author yuan.shuai
 * @Description
 * @Date 2019/7/30
 * @Version 1.0.0
 */
public class EditorAdminUserBackDao implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String userName;

    private String passWord;

    private String aliasName;

    private String status;

    private String createTime;

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

    public List<Integer> getRoleIdList() {
        return roleIdList;
    }

    public void setRoleIdList(List<Integer> roleIdList) {
        this.roleIdList = roleIdList;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
