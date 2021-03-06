package com.aichu.dao.workstation.object;

/**
 * @ClassName AcLabelQueryDao
 * @Author yuan.shuai
 * @Description 系统标签库检索Dao
 * @Date 2019/8/16
 * @Version 1.0.0
 */
public class AcLabelQueryDao {

    private String name;

    private Integer typeId;

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
