package com.aichu.manager.enums;

/**
 * @ClassName AppTypeEnum
 * @Description APP类型信息枚举
 * @Author Melon
 * @Date 2019/7/26 15:59
 * @Version 1.0.0
 **/
public enum AppTypeEnum {

    //APP类型
    APP_TYPE_ANDROID(0, "Android"),
    APP_TYPE_IOS(1,"IOS");

    /* Code码 */
    private Integer code;

    /* 信息 */
    private String name;

    AppTypeEnum(Integer code, String name) {
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
