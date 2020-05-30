package com.aichu.admin.vo.response;

/**
 * @ClassName LabelSelectListResponse
 * @Author yuan.shuai
 * @Description 活动标签下拉列表
 * @Date 2019/8/16
 * @Version 1.0.0
 */
public class LabelSelectListResponse {

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
