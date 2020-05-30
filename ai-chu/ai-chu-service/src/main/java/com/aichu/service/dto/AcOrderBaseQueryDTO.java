package com.aichu.service.dto;

import com.aichu.common.util.api.BasePageOrder;

/**
 * @program: ai-chu
 * @description
 * @author: Yuan.shuai
 * @create: 2020-02-17 15:35
 **/
public class AcOrderBaseQueryDTO extends BasePageOrder {

    private String name;

    private Integer consumeType;

    private Integer preferentialCardType;

    private Integer payUse;

    private String startCreateTime;

    private String endCreateTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getConsumeType() {
        return consumeType;
    }

    public void setConsumeType(Integer consumeType) {
        this.consumeType = consumeType;
    }

    public Integer getPreferentialCardType() {
        return preferentialCardType;
    }

    public void setPreferentialCardType(Integer preferentialCardType) {
        this.preferentialCardType = preferentialCardType;
    }

    public Integer getPayUse() {
        return payUse;
    }

    public void setPayUse(Integer payUse) {
        this.payUse = payUse;
    }

    public String getStartCreateTime() {
        return startCreateTime;
    }

    public void setStartCreateTime(String startCreateTime) {
        this.startCreateTime = startCreateTime;
    }

    public String getEndCreateTime() {
        return endCreateTime;
    }

    public void setEndCreateTime(String endCreateTime) {
        this.endCreateTime = endCreateTime;
    }
}
