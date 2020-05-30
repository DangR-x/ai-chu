package com.aichu.manager.enums;

/**
 * @ClassName SysSystemConfigEnum
 * @Description 系统配置类型信息枚举
 * @Author Melon
 * @Date 2019/7/26 15:59
 * @Version 1.0.0
 **/
public enum SysConfigEnum {

    //key-word （0-隐私政策协议，1-用户协议，2-充值协议, 3-关于我们，4-充值比例，5-主播提成比例，6-代理满足条件，7-客服微信号）
    SYS_SYSTEM_CONFIG_KEY_PRIVACY_POLICY(0,"privacyPolicy", "隐私政策协议"),
    SYS_SYSTEM_CONFIG_KEY_USER_POLICY(1,"userPolicy", "用户协议"),
    SYS_SYSTEM_CONFIG_KEY_CHARGE_POLICY(2,"chargePolicy", "充值协议"),
    SYS_SYSTEM_CONFIG_KEY_ABOUT_US(3,"aboutUs", "关于我们"),
    SYS_SYSTEM_CONFIG_KEY_CHARGE_RATE(4,"chargeRate", "充值比例（1:10）"),
    SYS_SYSTEM_CONFIG_KEY_ANCHOR_DEDUCT_RATE(5,"anchorDeductRate", "主播提成比例（1:100）"),
    SYS_SYSTEM_CONFIG_KEY_AGENCY_CHARGE_RULES(6,"agencyChargeRules", "成为代理满足条件（充值金币）"),
    SYS_SYSTEM_CONFIG_KEY_CUSTOMER_SERVER_WE_CHAT(7,"customerServerWeChat","客服微信号"),
    SYS_SYSTEM_CONFIG_KEY_CHART_WARN_TIME(8, "chartWarnTime", "聊天报警时间"),
    SYS_SYSTEM_CONFIG_KEY_GENERALIZE_LINK(9, "generalizeLink", "推广链接");


    /* Tag标识 */
    private Integer tag;

    /* Code码 */
    private String code;

    /* 信息 */
    private String name;

    SysConfigEnum(Integer tag, String code, String name) {
        this.tag = tag;
        this.code = code;
        this.name = name;
    }

    public Integer getTag() {
        return tag;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
