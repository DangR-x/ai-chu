package com.aichu.service.dto;

import com.aichu.common.util.api.BasePageOrder;

/**
 * @ClassName AcSysAppVersionBackQueryDTO
 * @Description TODO
 * @Author Yuan.shuai
 * @Date 2020/3/4 15:50
 */
public class AcSysAppVersionBackQueryDTO extends BasePageOrder {

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
