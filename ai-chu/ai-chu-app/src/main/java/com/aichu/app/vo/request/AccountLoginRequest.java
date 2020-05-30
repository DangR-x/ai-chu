package com.aichu.app.vo.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

/**
 * @ClassName AccountLoginRequest
 * @Description 用户登录求情数据模型Request
 * @Author Melon
 * @Date 2019/7/19 10:52
 * @Version 1.0.0
 **/
public class AccountLoginRequest {

    @ApiModelProperty(name="phone",value="手机号",required=true,hidden=false)
    @NotBlank(message = "手机号")
    private String phone;

    @ApiModelProperty(name="authCode",value="验证码",required=true,hidden=false)
    @NotBlank(message = "验证码")
    private String authCode;

    @ApiModelProperty(name="superiorUserId",value="上级ID",hidden=false)
    private Integer superiorUserId;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public Integer getSuperiorUserId() {
        return superiorUserId;
    }

    public void setSuperiorUserId(Integer superiorUserId) {
        this.superiorUserId = superiorUserId;
    }
}
