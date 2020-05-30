package com.aichu.manager.enums;

/**
 * @ClassName UserSignTypeEnum
 * @Description 用户是否签到信息枚举
 * @Author Melon
 * @Date 2019/7/26 15:59
 * @Version 1.0.0
 **/
public enum UserSignTypeEnum {

    USER_SIGN_TYPE_FALSE(0,"未签到"),
    USER_SIGN_TYPE_TRUE(1, "已签到");

    /* Code码 */
    private Integer code;

    /* 信息 */
    private String name;

    UserSignTypeEnum(Integer code, String name) {
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
