package com.aichu.admin.vo.request;

import com.aichu.common.util.api.BasePageOrder;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName AcSysSystemConfigQueryRequest
 * @Author yuan.shuai
 * @Description 系统配置检索Request
 * @Date 2019/9/19
 * @Version 1.0.0
 */
public class AcSysSystemConfigQueryRequest extends BasePageOrder {

    @ApiModelProperty(name="name",value="关键词",hidden=false)
    private String name;

    @ApiModelProperty(name="type",value="配置类型（0-关键词，1-文件，2-链接）",hidden=false)
    private Integer type;

    /** 用途（0-系统，1-后台，2-移动应用，3-官网，4-H5）*/
    @ApiModelProperty(name="source",value="用途（0-系统，1-后台，2-移动应用，3-官网，4-H5）",hidden=false)
    private Integer source;

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

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }
}
