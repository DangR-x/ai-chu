package com.aichu.admin.vo.request;

import com.aichu.common.util.api.BasePageOrder;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName AcSysAppVersionBackQueryDTO
 * @Description
 * @Author Yuan.shuai
 * @Date 2020/3/4 15:50
 */
public class AcSysAppVersionQueryRequest extends BasePageOrder {

    @ApiModelProperty(name = "name", value = "关键词",hidden = false)
    private String name;

    @ApiModelProperty(name = "type", value = "版本类型(0-Android，1-Ios)",required = true,hidden = false)
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
