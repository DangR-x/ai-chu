package com.aichu.admin.vo.request;

import com.aichu.common.util.api.BasePageOrder;
import io.swagger.annotations.ApiModelProperty;

/**
 * @program: ai-chu
 * @description
 * @author: Yuan.shuai
 * @create: 2020-02-17 19:42
 **/
public class AcSysAgentConfigQueryRequest extends BasePageOrder {

    @ApiModelProperty(name = "level", value = "等级",hidden = false)
    private Integer level;

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
