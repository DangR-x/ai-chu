package com.aichu.dao.workstation.object;

/**
 * @ClassName AcSysLabelSelectDao
 * @Author yuan.shuai
 * @Description 活动标签库下拉框Dao
 * @Date 2019/8/16
 * @Version 1.0.0
 */
public class AcSysLabelSelectDao {

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
