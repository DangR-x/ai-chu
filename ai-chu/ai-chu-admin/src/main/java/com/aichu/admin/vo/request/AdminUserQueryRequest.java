package com.aichu.admin.vo.request;

import com.aichu.common.util.api.BasePageOrder;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName AdminUserQueryDTO
 * @Author yuan.shuai
 * @Description 管理员检索DTO
 * @Date 2019/11/4
 * @Version 1.0.0
 */
public class AdminUserQueryRequest extends BasePageOrder {

    @ApiModelProperty(name = "name", value = "关键词", hidden = false)
    private String name;

//    @ApiModelProperty(name = "type", value = "管理员类型（0-管理员，1-开发商，2-商户）", hidden = false)
//    private Integer type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Integer getType() {
//        return type;
//    }
//
//    public void setType(Integer type) {
//        this.type = type;
//    }
}
