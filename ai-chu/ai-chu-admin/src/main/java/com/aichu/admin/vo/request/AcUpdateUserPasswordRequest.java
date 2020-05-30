package com.aichu.admin.vo.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @ClassName AcUpdateUserPasswordRequest
 * @Author yuan.shuai
 * @Description
 * @Date 2019/12/16
 * @Version 1.0.0
 */
public class AcUpdateUserPasswordRequest {

    @ApiModelProperty(name="userId",value="用户ID",required = true,hidden=false)
    @NotNull(message = "用户ID不能为空")
    private Integer userId;

    @ApiModelProperty(name="password",value="密码",required = true,hidden=false)
    @NotBlank(message = "密码不能为空")
    private String password;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
