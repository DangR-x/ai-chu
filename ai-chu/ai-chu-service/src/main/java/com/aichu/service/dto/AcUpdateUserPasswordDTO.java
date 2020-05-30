package com.aichu.service.dto;

/**
 * @ClassName AcUpdateUserPasswordDTO
 * @Author yuan.shuai
 * @Description
 * @Date 2019/12/16
 * @Version 1.0.0
 */
public class AcUpdateUserPasswordDTO {

    private Integer userId;

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
