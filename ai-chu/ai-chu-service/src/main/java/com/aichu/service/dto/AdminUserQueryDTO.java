package com.aichu.service.dto;

import com.aichu.common.util.api.BasePageOrder;

/**
 * @ClassName AdminUserQueryDTO
 * @Author yuan.shuai
 * @Description 管理员检索DTO
 * @Date 2019/11/4
 * @Version 1.0.0
 */
public class AdminUserQueryDTO extends BasePageOrder {

    private String name;

    private Integer type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
