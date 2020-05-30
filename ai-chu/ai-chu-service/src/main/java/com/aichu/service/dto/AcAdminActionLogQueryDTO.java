package com.aichu.service.dto;

import com.aichu.common.util.api.BasePageOrder;

/**
 * @ClassName WzAdminActionLogQueryDTO
 * @Author yuan.shuai
 * @Description 操作日志检索DTO
 * @Date 2019/11/9
 * @Version 1.1.0
 */
public class AcAdminActionLogQueryDTO extends BasePageOrder {

    private String name;

    private Integer adminUserId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAdminUserId() {
        return adminUserId;
    }

    public void setAdminUserId(Integer adminUserId) {
        this.adminUserId = adminUserId;
    }
}
