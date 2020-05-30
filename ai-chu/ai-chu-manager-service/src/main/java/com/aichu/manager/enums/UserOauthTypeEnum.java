package com.aichu.manager.enums;

/**
 * @ClassName UserOauthTypeEnum
 * @Description 用户第三方类型信息枚举
 * @Author Melon
 * @Date 2019/7/26 15:59
 * @Version 1.0.0
 **/
public enum UserOauthTypeEnum {

    USER_OAUTH_TYPE_WX(0, "微信"),
    USER_OAUTH_TYPE_ALI(1,"支付宝");

    /* Code码 */
    private Integer code;

    /* 信息 */
    private String name;

    UserOauthTypeEnum(Integer code, String name) {
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
