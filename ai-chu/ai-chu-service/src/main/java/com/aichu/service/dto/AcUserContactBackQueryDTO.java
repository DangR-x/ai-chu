package com.aichu.service.dto;

import com.aichu.common.util.api.BasePageOrder;

/**
 * @ClassName AcUserContactBackQueryDTO
 * @Author yuan.shuai
 * @Description
 * @Date 2019/12/9
 * @Version 1.0.0
 */
public class AcUserContactBackQueryDTO extends BasePageOrder {

    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
