package com.aichu.admin.vo.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

/**
 * @ClassName Data
 * @Author yuan.shuai
 * @Description 后台登录Request Model
 * @Date 2019/7/19
 * @Version 1.0.0
 */
public class BackLoginRequest {
    @ApiModelProperty(name="userName",value="后台用户名",required=true,hidden=false)
    @NotBlank(message = "用户名不能为空")
    private String userName;

    @ApiModelProperty(name="password",value="后台用户密码",required=true,hidden=false)
    @NotBlank(message = "密码不能为空")
    private String password;

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

    @Override
    public String toString() {
        return "BackLoginModel{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
