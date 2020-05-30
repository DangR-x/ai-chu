package com.aichu.manager.enums;

/**
 * @ClassName TableIsDeleteEnum
 * @Description 表信息字段是否删除信息枚举
 * @Author Melon
 * @Date 2019/7/26 15:59
 * @Version 1.0.0
 **/
public enum TableIsDeleteEnum {

    TABLE_IS_DELETE_FALSE(0,"未删除"),
    TABLE_IS_DELETE_TRUE(1, "已删除");

    /* Code码 */
    private Integer code;

    /* 信息 */
    private String name;

    TableIsDeleteEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
