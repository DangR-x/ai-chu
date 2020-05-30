package com.aichu.manager.enums;

public enum UserAnchorTypeEnum {
    USER_ANCHORE_TYPE_FALSE(0,"否"),
    USER_ANCHORE_TYPE_TRUE(1, "是");

    /* Code码 */
    private Integer code;

    /* 信息 */
    private String name;

    UserAnchorTypeEnum(Integer code, String name) {
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
