package com.aichu.service.dto;

/**
 * @ClassName AcSysSystemConfigDTO
 * @Author yuan.shuai
 * @Description 系统配置DTO
 * @Date 2019/9/19
 * @Version 1.0.0
 */
public class AcSysSystemConfigDTO {

    /** 主键 */
    private Integer id;

    /** 关键词KEY */
    private String keys;

    /** 关键词名称 */
    private String keyName;

    /** 关键词的值 */
    private String value;

    /** 备注说明 */
    private String comment;

    /** 配置类型（0-关键词，1-文件，2-链接） */
    private Integer type;

    /** 用途（0-系统，1-后台，2-移动应用，3-官网，4-H5）*/
    private Integer source;

    /** 是否删除（0-否，1-是） */
    private Integer isDelete;

    /** 创建时间 */
    private String createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }
}
