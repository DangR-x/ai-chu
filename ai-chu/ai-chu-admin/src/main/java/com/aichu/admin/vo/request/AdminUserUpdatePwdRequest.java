package com.aichu.admin.vo.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

/**
 * @ClassName AdminUserUpdatePwd
 * @Author yuan.shuai
 * @Description 管理员修改密码
 * @Date 2019/8/3
 * @Version 1.0.0
 */
public class AdminUserUpdatePwdRequest {

    @ApiModelProperty(name = "oldPwd", value = "旧密码",required = true, hidden = false)
    @NotBlank(message = "旧密码不能为空")
    private String oldPwd;

    @ApiModelProperty(name = "newPwd", value = "新密码",required = true, hidden = false)
    @NotBlank(message = "新密码不能为空")
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
