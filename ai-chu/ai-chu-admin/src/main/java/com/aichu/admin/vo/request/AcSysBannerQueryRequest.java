package com.aichu.admin.vo.request;

import com.aichu.common.util.api.BasePageOrder;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName AcSysBannerQueryRequest
 * @Author yuan.shuai
 * @Description 系统Banner管理检索
 * @Date 2019/8/26
 * @Version 1.0.0
 */
public class AcSysBannerQueryRequest extends BasePageOrder {

    @ApiModelProperty(name="name",value="关键词",hidden=false)
    private String name;

    @ApiModelProperty(name="type",value="Banner类型（0-启动页，1-恭喜Banner,........）",hidden=false)
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
