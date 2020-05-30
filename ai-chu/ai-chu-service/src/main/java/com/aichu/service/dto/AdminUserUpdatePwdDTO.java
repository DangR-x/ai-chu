package com.aichu.service.dto;

/**
 * @ClassName AdminUserUpdatePwdDTO
 * @Author yuan.shuai
 * @Description 后台用户修改密码DTO
 * @Date 2019/8/3
 * @Version 1.0.0
 */
public class AdminUserUpdatePwdDTO {

    private String oldPwd;

    private String newPwd;

    public String getOldPwd() {
        return oldPwd;
    }

    public void setOldPwd(String oldPwd) {
        this.oldPwd = oldPwd;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }
}
