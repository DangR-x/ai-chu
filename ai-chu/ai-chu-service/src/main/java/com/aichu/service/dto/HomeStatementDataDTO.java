package com.aichu.service.dto;

import com.aichu.dao.workstation.object.ActiveUserDao;

import java.util.List;

/**
 * @ClassName HomeStatementDataDTO
 * @Author hsw
 * @Description 首頁报表用户数据
 * @Date 2020/3/12
 * @Version 1.0.0
 */
public class HomeStatementDataDTO {
    /**
     * 日活跃用户list
     */
    private List<ActiveUserDao> activeUserList;

    /**
     * 日注册用户list
     */
    private List<ActiveUserDao> registerUserList;

    public List<ActiveUserDao> getActiveUserList() {
        return activeUserList;
    }

    public void setActiveUserList(List<ActiveUserDao> activeUserList) {
        this.activeUserList = activeUserList;
    }

    public List<ActiveUserDao> getRegisterUserList() {
        return registerUserList;
    }

    public void setRegisterUserList(List<ActiveUserDao> registerUserList) {
        this.registerUserList = registerUserList;
    }
}
