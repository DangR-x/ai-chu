package com.aichu.manager.enums;

/**
 * @ClassName UserAttentionTypeEnum
 * @Description 用户关注信息枚举
 * @Author Melon
 * @Date 2019/7/26 15:59
 * @Version 1.0.0
 **/
public enum UserAttentionTypeEnum {

    USER_ATTENTION_TYPE_FALSE(0,"未关注"),
    USER_ATTENTION_TYPE_TRUE(1, "已关注");

    /* Code码 */
    private Integer code;

    /* 信息 */
    private String name;

    UserAttentionTypeEnum(Integer code, String name) {
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
