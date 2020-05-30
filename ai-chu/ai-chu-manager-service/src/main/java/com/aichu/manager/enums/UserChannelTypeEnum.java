package com.aichu.manager.enums;

/**
 * @ClassName UserChannelTypeEnum
 * @Description 用户来源渠道类型信息枚举
 * @Author Melon
 * @Date 2019/7/26 15:59
 * @Version 1.0.0
 **/
public enum UserChannelTypeEnum {

    USER_CHANNEL_TYPE_WECHAT(0, "微信"),
    USER_CHANNEL_TYPE_ALI(1,"支付宝"),
    USER_CHANNEL_TYPE_APPLE(2,"Apple");

    /* Code码 */
    private Integer code;

    /* 信息 */
    private String name;

    UserChannelTypeEnum(Integer code, String name) {
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
