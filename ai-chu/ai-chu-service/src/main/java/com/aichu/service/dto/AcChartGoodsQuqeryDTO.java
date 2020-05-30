package com.aichu.service.dto;

import com.aichu.common.util.api.BasePageOrder;

/**
 * @program: ai-chu
 * @description 商检检索DTO
 * @author: Yuan.shuai
 * @create: 2020-02-17 10:11
 **/
public class AcChartGoodsQuqeryDTO extends BasePageOrder {

    private String name;

    private Integer isPutaway;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIsPutaway() {
        return isPutaway;
    }

    public void setIsPutaway(Integer isPutaway) {
        this.isPutaway = isPutaway;
    }
}
