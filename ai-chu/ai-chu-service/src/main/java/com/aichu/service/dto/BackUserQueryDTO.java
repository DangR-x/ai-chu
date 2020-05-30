package com.aichu.service.dto;

import com.aichu.common.util.api.BasePageOrder;

/**
 * @ClassName BackUserQueryDTO
 * @Author yuan.shuai
 * @Description 后台用户列查询
 * @Date 2019/11/4
 * @Version 1.0.0
 */
public class BackUserQueryDTO extends BasePageOrder {

    /**关键词*/
    private String name;

    /**代理等级*/
    private Integer level;

    /** 是否冻结*/
    private Integer isFreeze;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getIsFreeze() {
        return isFreeze;
    }

    public void setIsFreeze(Integer isFreeze) {
        this.isFreeze = isFreeze;
    }
}
