package com.aichu.manager.enums;

/**
 * @ClassName UserBlackListTypeEnum
 * @Description 用户黑名单信息枚举
 * @Author Melon
 * @Date 2019/7/26 15:59
 * @Version 1.0.0
 **/
public enum UserBlackListTypeEnum {

    USER_BLACK_LIST_TYPE_RELATION_BLACK_LIST(1,"黑名单操作"),
    USER_BLACK_LIST_TYPE_RELATION_SILENCE(2,"静音列表操作"),
    USER_BLACK_LIST_TYPE_VALUE_BLACK_LIST(0,"取消黑名单或静音"),
    USER_BLACK_LIST_TYPE_VALUE_SILENCE(1, "加入黑名单或静音");

    /* Code码 */
    private Integer code;

    /* 信息 */
    private String name;

    UserBlackListTypeEnum(Integer code, String name) {
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
