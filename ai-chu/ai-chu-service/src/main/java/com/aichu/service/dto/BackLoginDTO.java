package com.aichu.service.dto;

/**
 * @ClassName BackLoginDTO
 * @Author yuan.shuai
 * @Description 登录DTO
 * @Date 2019/7/23
 * @Version 1.0.0
 */
public class BackLoginDTO {

    private String userName;

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
