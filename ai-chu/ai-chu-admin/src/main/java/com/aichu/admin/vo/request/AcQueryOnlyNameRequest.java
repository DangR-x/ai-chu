package com.aichu.admin.vo.request;

import com.aichu.common.util.api.BasePageOrder;
import io.swagger.annotations.ApiModelProperty;

/**
 * @program: ai-chu
 * @description
 * @author: Yuan.shuai
 * @create: 2020-02-17 11:40
 **/
public class AcQueryOnlyNameRequest extends BasePageOrder {

    @ApiModelProperty(name = "name", value = "关键词",hidden = false)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
