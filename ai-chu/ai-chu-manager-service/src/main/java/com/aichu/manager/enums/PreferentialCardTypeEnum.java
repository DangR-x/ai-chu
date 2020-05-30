package com.aichu.manager.enums;

/**
 * @ClassName PreferentialCardTypeEnum
 * @Description 优惠卡类型信息枚举
 * @Author Melon
 * @Date 2019/7/26 15:59
 * @Version 1.0.0
 **/
public enum PreferentialCardTypeEnum {

    PREFERENTIAL_CARD_TYPE_WEEK(0,"周卡"),
    PREFERENTIAL_CARD_TYPE_MOUTH(1, "月卡"),

    PREFERENTIAL_CARD_TYPE_WEEK_KEY_DATABASE(1,"周卡"),
    PREFERENTIAL_CARD_TYPE_MOUTH_KEY_DATABASE(2, "月卡");

    /* Code码 */
    private Integer code;

    /* 信息 */
    private String name;

    PreferentialCardTypeEnum(Integer code, String name) {
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
