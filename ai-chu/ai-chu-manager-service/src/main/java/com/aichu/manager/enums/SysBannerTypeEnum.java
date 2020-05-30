package com.aichu.manager.enums;

/**
 * @ClassName SysBannerTypeEnum
 * @Description 系统Banner类型信息枚举
 * @Author Melon
 * @Date 2019/7/26 15:59
 * @Version 1.0.0
 **/
public enum SysBannerTypeEnum {

    SYS_BANNER_TYPE_LAUNCH(0, "启动页Banner"),
    SYS_BANNER_TYPE_MAIN_FACE(1,"首页Banner"),
    SYS_BANNER_TYPE_SECOND_BANNER(3,"工程二级Banner"),
    SYS_BANNER_TYPE_ENGINEER(2,"工程Banner");

    /* Code码 */
    private Integer code;

    /* 信息 */
    private String name;

    SysBannerTypeEnum(Integer code, String name) {
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
