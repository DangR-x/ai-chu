package com.aichu.manager.enums;

/**
 * @ClassName OrderStatusEnum
 * @Description 订单信息枚举
 * @Author Melon
 * @Date 2019/7/26 15:59
 * @Version 1.0.0
 **/
public enum OrderStatusEnum {

    //交易途径（0-聊天，1-打赏）
    ORDER_SOURCE_PAY_WAY_CHART(0, "聊天"),
    ORDER_SOURCE_PAY_WAY_REWARD(1,"打赏"),


    //交易类别（0-消费，1-充值，2-提现）
    ORDER_STATUS_PAY_USE_COST(0, "消费"),
    ORDER_STATUS_PAY_USE_CHARGE(1,"充值"),
    ORDER_STATUS_PAY_USE_WITHDRAW(2,"提现"),

    //订单状态（0-未支付，1-已支付，2，已取消，3-未退款，4-退款中，5-已退款，6-已拒绝,7-已完成）
    ORDER_STATUS_PAY_STATUS_NON_PAYMENT(0,"未支付"),
    ORDER_STATUS_PAY_STATUS_HAS_PAYMENT(1,"已支付"),
    ORDER_STATUS_PAY_STATUS_HAC_CANCEL(2,"已取消"),
    ORDER_STATUS_PAY_STATUS_NON_REFUND(3,"未退款"),
    ORDER_STATUS_PAY_STATUS_REFUND_ING(4,"退款中"),
    ORDER_STATUS_PAY_STATUS_HAS_REFUND(5,"已退款"),
    ORDER_STATUS_PAY_STATUS_HAS_REFUSE(6,"已拒绝"),
    ORDER_STATUS_PAY_STATUS_HAS_SUCCESS(7,"已完成"),

    //支付方式（0-余额，1-微信，2-支付宝）
    ORDER_STATUS_PAY_WAY_BALANCE(0,"余额"),
    ORDER_STATUS_PAY_WAY_WX(1,"微信"),
    ORDER_STATUS_PAY_WAY_ALI(2,"支付宝"),

    //订单状态（0-失效订单，1-正常订单）
    ORDER_STATUS_TYPE_LOSE_EFFICACY(0,"失效订单"),
    ORDER_STATUS_TYPE_NORMAL(1,"正常订单"),

    //退款类型（0-转账，1-红包）
    ORDER_REFUND_TYPE_TRANSFER(0,"优惠卡"),

    //退款状态（0-退款中，1-已拒绝，2-已通过）
    ORDER_REFUND_STATUS_REFUND_ING(0,"退款中"),
    ORDER_REFUND_STATUS_HAS_REFUSE(1,"已拒绝"),
    ORDER_REFUND_STATUS_REFUND_AGREE(2,"已通过"),
    ORDER_REFUND_STATUS_REFUND_FILED(3,"退款失败"),

    //消费类型（0-充值，1-提现，2-优惠卡，3-直播打赏，4-直播付费, 5-代理提成）
    ORDER_CONSUME_TYPE_RECHARGE(0,"充值"),
    ORDER_CONSUME_TYPE_WITHDRAW(1,"提现"),
    ORDER_CONSUME_TYPE_PREFERENTIAL_CARD(2,"优惠卡"),
    ORDER_CONSUME_TYPE_LIVE_REWARD(3,"直播打赏"),
    ORDER_CONSUME_TYPE_LIVE_PAY(4,"直播付费"),
    ORDER_CONSUME_TYPE_AGENCY_INCOME(5,"代理提成"),

    //提现方式（0-微信，1-支付宝）
    ORDER_TYPE_WITH_DRAW_WX(0,"微信"),
    ORDER_TYPE_WITH_DRAW_ALI(1,"支付宝"),

    //提现状态（0-提现中，1-已拒绝，2-提现成功, 3-提现失败）
    ORDER_STATUS_WITH_DRAW_ING(0,"提现中"),
    ORDER_STATUS_WITH_DRAW_REFUSE(1,"已拒绝"),
    ORDER_STATUS_WITH_DRAW_SUCCESS(2,"提现成功"),
    ORDER_STATUS_WITH_DRAW_FILED(3,"提现失败");
    /* Code码 */
    private Integer code;

    /* 信息 */
    private String name;

    OrderStatusEnum(Integer code, String name) {
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
