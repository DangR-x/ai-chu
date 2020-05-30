package com.aichu.service.dto;

import com.aichu.common.util.api.BasePageOrder;

/**
 * @ClassName AcSysBannerBackQueryDTO
 * @Author yuan.shuai
 * @Description 系统Banner管理检索
 * @Date 2019/8/26
 * @Version 1.0.0
 */
public class AcSysBannerBackQueryDTO extends BasePageOrder {

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
