package com.aichu.manager.enums;

/**
 * @ClassName SysSystemConfigEnum
 * @Description 系统配置类型信息枚举
 * @Author Melon
 * @Date 2019/7/26 15:59
 * @Version 1.0.0
 **/
public enum SysSystemConfigEnum {

    //key-word
    SYS_SYSTEM_CONFIG_USER_POLICY("userPolicy", "用户协议"),
    SYS_SYSTEM_CONFIG_KEY_UPGRADE_LEVEL_CONDITION("upgradeLevelCondition", "H5首页背景图"),
    SYS_SYSTEM_CONFIG_KEY_PROMOTE_LINKS("promoteLinks", "推广链接"),
    SYS_SYSTEM_CONFIG_ENGINEER_AMOUNT("engineerAmount","工程资料金额"),
    SYS_SYSTEM_CONFIG_DISTRIBUTION_RATIO("distributionRatio","分销比例"),
    SYS_SYSTEM_CONFIG_DISTRIBUTION_ASTRICT("distributionAstrict","分销起始最低金额"),
    SYS_SYSTEM_CONFIG_NEWS_REWARD("reward","新闻打赏"),
    SYS_SYSTEM_CONFIG_NEWS_REWARD_MAKING_FRIENDS ("makingFriends","交友信息支付"),
    //key-source(0-系统，1-后台，2-移动应用，3-官网，4-H5)
    SYS_SYSTEM_CONFIG_SOURCE_SYSTEM("0","系统"),
    SYS_SYSTEM_CONFIG_SOURCE_ADMIN("1","后台"),
    SYS_SYSTEM_CONFIG_SOURCE_APP("2","移动应用"),
    SYS_SYSTEM_CONFIG_SOURCE_WEBSITE("3","官网"),
    SYS_SYSTEM_CONFIG_SOURCE_H5("4","H5");
    /* Code码 */
    private String code;

    /* 信息 */
    private String name;

    SysSystemConfigEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
