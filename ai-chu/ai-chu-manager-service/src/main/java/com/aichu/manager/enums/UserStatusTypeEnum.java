package com.aichu.manager.enums;

/**
 * @ClassName UserStatusTypeEnum
 * @Author yuan.shuai
 * @Description 用户是否冻结枚举
 * @Date 2019/12/9
 * @Version 1.0.0
 */
public enum UserStatusTypeEnum {

    USER_STATUS_TYPE_NORMAL(0,"正常"),
    USER_STATUS_TYPE_FROZEN(1,"冻结");

    private Integer code;

    private String name;

    UserStatusTypeEnum(Integer code, String name){
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }}
