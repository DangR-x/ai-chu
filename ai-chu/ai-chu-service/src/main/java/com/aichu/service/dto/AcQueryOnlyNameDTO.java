package com.aichu.service.dto;

import com.aichu.common.util.api.BasePageOrder;

/**
 * @program: ai-chu
 * @description
 * @author: Yuan.shuai
 * @create: 2020-02-17 11:40
 **/
public class AcQueryOnlyNameDTO extends BasePageOrder {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
