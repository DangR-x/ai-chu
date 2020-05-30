package com.aichu.service.dto;

/**
 * @ClassName AcSysLabelSelectDTO
 * @Author yuan.shuai
 * @Description 后台活动标签下拉框DTO
 * @Date 2019/8/16
 * @Version 1.0.0
 */
public class AcSysLabelSelectDTO {

    private Integer id;

    private String labelName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }
}
