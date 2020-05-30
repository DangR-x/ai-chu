package com.aichu.admin.vo.request;

import com.aichu.common.util.api.BasePageOrder;
import io.swagger.annotations.ApiModelProperty;

/**
 * @program: ai-chu
 * @description
 * @author: Yuan.shuai
 * @create: 2020-02-22 21:43
 **/
public class AcOnlyIdQueryReuqest extends BasePageOrder {

    @ApiModelProperty(name = "id", value = "用户ID",required = true,hidden = false)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
