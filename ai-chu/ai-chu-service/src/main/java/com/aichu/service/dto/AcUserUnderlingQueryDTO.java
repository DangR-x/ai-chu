package com.aichu.service.dto;

import com.aichu.common.util.api.BasePageOrder;

/**
 * @ClassName AcUserUnderlingQueryDTO
 * @Author yuan.shuai
 * @Description
 * @Date 2019/12/24
 * @Version 1.0.0
 */
public class AcUserUnderlingQueryDTO extends BasePageOrder {

    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
