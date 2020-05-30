package com.aichu.admin.vo.request;

import com.aichu.common.util.api.BasePageOrder;
import io.swagger.annotations.ApiModelProperty;

/**
 * @program: ai-chu
 * @description 商检检索DTO
 * @author: Yuan.shuai
 * @create: 2020-02-17 10:11
 **/
public class AcChartGoodsQuqeryRequest extends BasePageOrder {

    @ApiModelProperty(name = "name", value = "关键词",hidden = false)
    private String name;

    @ApiModelProperty(name = "isPutaway", value = "是否上架（0-否，1-是）",hidden = false)
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
