package com.aichu.manager.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ResultCodeEnum
 * @Description 全局通用接口错误码
 * @Author Melon
 * @Date 2019/7/18 9:57
 * @Version 1.0.0
 **/
public enum ResultCodeEnum {
    /*
     * 错误码格式说明（示例：202001），
     * 第一位：错误级别，1：为系统级错误，2：为业务逻辑错误 3 提示性信息
     * 中间两位为系统
     * 后三位:错误码 从1以此开始
     */

    SUCCESS(200, "请求成功"),
    //系统级错误 以1开头  业务代码中 未处理 未预料错误（此项目中通常是全局异常、全局错误中使用）
    SYSTEM_ERROR(1010001, "系统错误"),
    SYSTEM_UNKNOWN_ERROR(1010002, "未知错误"),
    SYSTEM_ACCOUNT_ERROR(1010003, "账户异常，请联系管理员"),
    SYSTEM_SENSITIVE_ERROR(1010004, "数据异常，存在敏感脚本"),
    SYSTEM_SESSION_ERROR(1010005, "SESSION失效，请重新登录或者联系管理员"),
    SYSTEM_AMOUNT_ERROR(1010006, "金额异常，请联系管理员"),

    //业务逻辑错误 以2开头 在业务代码中 所有操作能够预料到的错误返回
    BUSINESS_ERROR(201001, "业务处理错误"),
    AUTH_ERROR(201002, "授权错误"),
    LOGIN_FAILED(201003, "登录失败"),
    USERNAME_OR_PASSWORD_FAILED(201004, "账号或密码错误,请重新输入"),
    ADMIN_STATUS_FREEZE(201005, "账号被停用,请联系管理员"),
    ADMIN_NOT_EXIST(201006, "账号不存在,请重新输入"),
    LOGIN_TOKEN_EFFICACY(201007, "登陆已过期，请重新登陆"),
    TOKEN_DECODE_FAILED(201008, "TOKEN解码失败"),
    JURISDICTION_ERROR(201009, "权限不足"),
    SMS_AUTH_CODE_FAILED(201010, "短信发送失败"),
    AUTH_CODE_ERROR(201011, "验证失败，请重新获取验证码"),
    SCENE_SETTING_FAILED(201012, "没有设置场景,请先设置场景"),
    SET_REQUEST_HEADER(201013, "设置请求头失败"),
    USER_INFO_NOT_EXISTED(201016, "用户信息不存在"),
    WX_OPENID_ERR(201019, "获取微信OPENID失败！"),
    LOGIN_TYPE_ERROR(201020, "登录类型错误"),
    LOGIN_PASSWORD_ERROR(201021, "登录密码错误"),
    CREATE_USER_ERROR(201022, "创建用户失败"),
    UPDATE_USER_ERROR(201023, "用户信息更新失败"),
    USER_INFO_HAS_EXISTED(201024, "手机号已注册使用"),
    USER_RELATIONSHIP_NOT_EXISTED(201025, "用户关系信息不存在"),
    UPDATE_DATA_ERROR(201026, "修改信息失败"),
    ADD_DATA_ERROR(201027, "新增信息失败"),
    DELETE_DATA_ERROR(201028, "删除信息失败"),
    OLD_PASSWORD_ERROR(201029, "旧密码输入错误，请重新输入"),
    UPDATE_PASSWORD_ERROR(201030, "修改密码失败"),
    ALIAS_NAME_REPETITION(201031, "昵称已经存在，请重新输入昵称"),
    AIM_USER_HAS_NOT_LIKE(201032, "目标用户还未关注，取消失败！"),
    AIM_USER_LIKE_FILED(201033, "关注失败！"),
    AIM_USER_COMMENT_FILED(201034, "评论失败！"),
    PREFERENTIAL_CARD_NOT_EXISTED(201035, "优惠卡信息不存在！"),
    FEED_BACK_ADD_ERROR(201036, "反馈意见添加失败！"),
    USER_PHOTO_ALBUM_UPDATE_FILED(201037, "照片墙更新失败！"),
    AGENCY_BECOME_MUST_CHARGE_ENOUGH(201038, "用户充值金币不足(5000)，无法成为代理用户！"),
    AGENCY_ANCHOR_USER_NOT_EXISTED(201039, "代理用户旗下用户信息不存在！"),
    AGENCY_ANCHOR_REMOVE_FILED(201040, "代理用户删除主播信息失败！"),
    AGENCY_ANCHOR_HAS_BEAN_BIND(201041, "该主播已经被其他代理人员添加，无法再次添加！"),
    AGENCY_ANCHOR_ADD_ERROR(201042, "添加主播失败！"),
    WANG_YI_YUN_REGISTER_TOKEN_ERROR(201043, "网易云用户注册TOKEN失败！"),
    WANG_YI_YUN_USER_HAS_REGISTER(201044, "网易云用户注册TOKEN失败,该用户已经注册！"),
    WANG_YI_YUN_GET_USER_ERROR(201045, "网易云获取用户失败！"),
    WANG_YI_YUN_UPDATE_USER_ERROR(201046, "网易云更新用户失败！"),
    ADMIN_USER_IS_EXIST(201047, "管理员账号已经存在"),
    WANG_YI_YUN_GET_USER_BLACK_LIST_ERROR(201048, "网易云获取用户黑名单列表失败！"),
    WANG_YI_YUN_ADD_USER_BLACK_LIST_ERROR(201049, "网易云用户添加黑名单失败！"),
    WANG_YI_YUN_REMOVE_USER_BLACK_LIST_ERROR(201050, "网易云用户移除黑名单失败！"),
    USER_SIGN_RECORD_CREATE_ERROR(201051, "用户签到记录生成失败！"),
    USER_ORDER_BASE_CREATE_ERROR(201052, "订单信息生成失败！"),
    USER_ORDER_PAY_RECORD_CREATE_ERROR(201053, "订单信息记录生成失败！"),
    USER_CHART_GOODS_NOT_EXIST(201054, "商品信息不存在！"),
    USER_CHART_GOODS_CREATE_ERROR(201055, "商品记录信息添加失败！"),
    USER_AGENCY_LEVEL_NOT_EXIST(201056, "用户代理等级信息不存在！"),
    USER_COIN_NOT_ENOUGH(201057, "用户账户余额不足！"),
    CREATE_PAY_ERROR(201058, "创建支付失败！"),
    PAY_MONEY_NOT_LESS_ZERO(201059, "支付金额不能小于0元！"),
    AC_WITHDRAW_MONEY_NOT_LESS_ONE_COIN(201089, "单笔提现金额不能小于0.1元！"),
    AC_CREATE_ORDER_BASE_FAILED(201060, "创建支付订单失败"),
    AC_CREATE_ORDER_PAY_RECORD_FAILED(201061, "创建订单支付记录失败"),
    AC_BY_PREFERENTIAL_CARD_FAILED(201062, "购买优惠卡信息失败"),
    AC_USER_HAS_BEEN_BY_PREFERENTIAL_CARD(201063, "购买失败,用户已购买此类型优惠卡,无法再次购买！"),
    AC_UPDATE_ORDER_BASE_FAILED(201064, "修改订单信息失败"),
    AC_UPDATE_ORDER_PAY_RECORD_FAILED(201065, "修改订单流水记录信息失败"),
    AC_UPDATE_PREFERENTIAL_CARD_FAILED(201066, "修改优惠卡信息失败"),
    USER_HAS_NOT_BIND_WX_ERROR(201067, "用户暂未绑定微信第三方信息"),
    CODE_BY_ACCESS_TOKEN_ERROR(201068, "通过WxCode获取AccessToken失败"),
    WX_OPENID_HAS_BEEN_BIND(201069, "此微信账户信息已被绑定使用！"),
    REFRESH_ACCESS_TOKEN_ERROR(201070, "刷新AccessToken失败"),
    CHECK_ACCESS_TOKEN_IS_VALID_ERROR(201071, "检验授权凭证（AccessToken）是否有效失败"),
    USER_INFO_BY_OPEN_ID_ERROR(201072, "通过OPEN_ID获取用户信息失败"),
    USER_DEVICE_BIND_ERROR(201073, "用户设备绑定失败！"),
    USER_DEVICE_BIND_UPDATE_ERROR(201074, "用户设备绑定信息更新失败！"),
    AC_ORDER_REFUND_RECORD_ERROR(201075, "退款失败"),
    AC_ORDER_WITHDRAW_ERROR(201076, "提现失败"),
    USER_VIDEO_RECORD_ADD_ERROR(201077, "用户视频通话记录添加失败！"),
    PAY_GOODS_CONFIG_INFO_NOT_EXIST(201078, "充值配置信息不存在！"),
    AC_PREFERENTIAL_CARD_INFO_NOT_EXIST(201079, "优惠卡信息不存在！"),
    AC_USER_AMOUNT_HAS_NOT_ENOUGH(201080, "账户余额不足"),
    AC_CREATE_ORDER_WITH_DRAW_RECORD_FAILED(201081, "创建订单提现记录失败"),
    AC_APP_VERSION_NOT_EXIST(201082, "APP版本信息不存在！"),
    AC_USER_HAS_SIGN_AND_NOT_REPEAT(201083, "用户今日已经签到，无法再次签到！"),
    PUSH_MESSAGE_ERROR(201085, "推送消息失败！"),
    USER_DEVICE_NOT_EXIST(201086,"用户设备信息不存在！"),
    AIM_USER_CANCEL_LIKE_FILED(201087, "用户取消关注失败！"),
    AIM_USER_MESSAGE_PUSH_FILED(201088, "消息推送失败！"),
    CREATE_ORDER_WITH_DRAW_RECORD_FAILED(201090, "创建订单提现记录失败"),
    ORDER_WITHDRAW_RECORD_NOT_EXIST(201090, "提现记录不存在！"),
    AGENCY_ANCHOR_IS_EXIST(201091, "该用户已经是主播，无法再次添加！"),

    //提示性信息 主要是入参校验性错误 以3开头 可共用一个通用码返回 仅功能操作提示
    PARAM_ERROR(301001, "参数错误"),
    DATA_ERROR(301002, "信息不存在或已被删除");


    /**
     * 枚举值
     */
    private Integer code;

    /**
     * 枚举描述
     */
    private String message;

    /**
     * @param code    枚举值
     * @param message 枚举描述
     */
    private ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * @return 返回code
     */
    public Integer getCode() {
        return code;
    }

    /**
     * @return 返回枚举值
     */
    public String getMessage() {
        return message;
    }

    /**
     * @return 返回code
     */
    public Integer code() {
        return code;
    }

    /**
     * @return 返回枚举值
     */
    public String message() {
        return message;
    }

    /**
     * 通过枚举code获得枚举
     *
     * @return
     */
    public static ResultCodeEnum getByCode(Integer code) {
        for (ResultCodeEnum pEnum : values()) {
            if (pEnum.getCode().equals(code)) {
                return pEnum;
            }
        }
        return null;
    }

    /**
     * 通过枚举值获得枚举
     *
     * @return
     */
    public static ResultCodeEnum getByMessage(String message) {
        for (ResultCodeEnum pEnum : values()) {
            if (pEnum.getMessage().equals(message)) {
                return pEnum;
            }
        }
        return null;
    }

    /**
     * 获取全部枚举
     *
     * @return
     */
    public static List<ResultCodeEnum> getAllEnum() {
        List<ResultCodeEnum> list = new ArrayList<>(values().length);
        for (ResultCodeEnum pEnum : values()) {
            list.add(pEnum);
        }
        return list;
    }

    /**
     * 获取全部枚举值
     *
     * @return
     */
    public static List<Integer> getAllEnumCode() {
        List<Integer> list = new ArrayList<>(values().length);
        for (ResultCodeEnum pEnum : values()) {
            list.add(pEnum.code());
        }
        return list;
    }

    /**
     * 通过code获取msg
     *
     * @param code 枚举值
     */
    public static String getMsgByCode(Integer code) {
        if (code == null) {
            return null;
        }
        ResultCodeEnum pEnum = getByCode(code);
        if (pEnum == null) {
            return null;
        }
        return pEnum.getMessage();
    }

    /**
     * 获取枚举code
     */
    public static Integer getCode(ResultCodeEnum pEnum) {
        if (pEnum == null) {
            return null;
        }
        return pEnum.getCode();
    }
}
