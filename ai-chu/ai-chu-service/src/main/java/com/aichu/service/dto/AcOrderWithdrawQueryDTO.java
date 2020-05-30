package com.aichu.service.dto;

import com.aichu.common.util.api.BasePageOrder;

/**
 * @program: ai-chu
 * @description
 * @author: Yuan.shuai
 * @create: 2020-02-17 15:35
 **/
public class AcOrderWithdrawQueryDTO extends BasePageOrder {

    private String name;

    private Integer withDrawStatus;

    private String startCreateTime;

    private String endCreateTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWithDrawStatus() {
        return withDrawStatus;
    }

    public void setWithDrawStatus(Integer withDrawStatus) {
        this.withDrawStatus = withDrawStatus;
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
