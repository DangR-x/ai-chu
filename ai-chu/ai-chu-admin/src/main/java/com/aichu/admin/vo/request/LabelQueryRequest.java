package com.aichu.admin.vo.request;

import com.aichu.common.util.api.BasePageOrder;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName LabelQueryRequest
 * @Author yuan.shuai
 * @Description 系统标签库检索条件
 * @Date 2019/8/16
 * @Version 1.0.0
 */
public class LabelQueryRequest extends BasePageOrder {

    @ApiModelProperty(name="name",value="关键词",hidden=false)
    private String name;

    @ApiModelProperty(name="typeId",value="关键词类型",hidden=false)
    private Integer typeId;

    @ApiModelProperty(name="isHot",value="是否火热（0：否，1：是）",hidden=false)
    private Integer isHot;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getIsHot() {
        return isHot;
    }

    public void setIsHot(Integer isHot) {
        this.isHot = isHot;
    }
}
