package com.aichu.service.dto;

/**
 * @ClassName AcUserFrozenDTO
 * @Author yuan.shuai
 * @Description
 * @Date 2019/12/9
 * @Version 1.0.0
 */
public class AcUserFrozenDTO {

    private Integer userId;

    private Integer isFreeze;

    private String freezeContent;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getIsFreeze() {
        return isFreeze;
    }

    public void setIsFreeze(Integer isFreeze) {
        this.isFreeze = isFreeze;
    }

    public String getFreezeContent() {
        return freezeContent;
    }

    public void setFreezeContent(String freezeContent) {
        this.freezeContent = freezeContent;
    }
}
