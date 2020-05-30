package com.aichu.manager.enums;

/**
 * @ClassName ChartGoodsStatusEnum
 * @Description 爱触聊天商品信息枚举
 * @Author Melon
 * @Date 2019/7/26 15:59
 * @Version 1.0.0
 **/
public enum ChartGoodsStatusEnum {

    CHART_GOODS_STATUS_IS_PUTAWAY_FALSE(0,"未上架"),
    CHART_GOODS_STATUS_IS_PUTAWAY_TRUE(1, "已上架");

    /* Code码 */
    private Integer code;

    /* 信息 */
    private String name;

    ChartGoodsStatusEnum(Integer code, String name) {
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
