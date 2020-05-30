package com.aichu.service.dto;


import com.aichu.common.util.api.BasePageOrder;

/**
 * @ClassName AcSysSystemConfigQueryDTO
 * @Author yuan.shuai
 * @Description 系统配置检索DTO
 * @Date 2019/9/19
 * @Version 1.0.0
 */
public class AcSysSystemConfigQueryDTO extends BasePageOrder {

    private String name;

    private Integer type;

    /** 用途（0-系统，1-后台，2-移动应用，3-官网，4-H5）*/
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
