package com.aichu.dao.workstation.object;

import java.io.Serializable;

/**
 * @ClassName AdminRoleBackSelectDao
 * @Author yuan.shuai
 * @Description
 * @Date 2019/7/31
 * @Version 1.0.0
 */
public class AdminRoleBackSelectDao implements Serializable {

    private static final long serialVersionUID = 1L;

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
