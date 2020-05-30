package com.aichu.admin.vo.request;

import com.aichu.common.util.api.BasePageOrder;
import io.swagger.annotations.ApiModelProperty;

/**
 * @program: ai-chu
 * @description
 * @author: Yuan.shuai
 * @create: 2020-02-17 15:35
 **/
public class AcOrderBaseRefundQueryRequest extends BasePageOrder {

    @ApiModelProperty(name = "name", value = "关键词",hidden = false)
    private String name;

    @ApiModelProperty(name = "refundStatus", value = "退款状态（0-退款中，1-已拒绝，2-已通过, 3-退款失败）",hidden = false)
    private Integer refundStatus;

    @ApiModelProperty(name = "consumeType", value = "消费类型（0-充值，1-提现，2-优惠卡，3-直播打赏，4-直播付费, 5-代理提成）",hidden = false)
    private Integer consumeType;

    @ApiModelProperty(name = "startCreateTime", value = "交易开始时间",hidden = false)
    private String startCreateTime;

    @ApiModelProperty(name = "endCreateTime", value = "交易截止时间",hidden = false)
    private String endCreateTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(Integer refundStatus) {
        this.refundStatus = refundStatus;
    }

    public String getStartCreateTime() {
        return startCreateTime;
    }

    public void setStartCreateTime(String startCreateTime) {
        this.startCreateTime = startCreateTime;
    }

    public String getEndCreateTime() {
        return endCreateTime;
    }

    public void setEndCreateTime(String endCreateTime) {
        this.endCreateTime = endCreateTime;
    }

    public Integer getConsumeType() {
        return consumeType;
    }

    public void setConsumeType(Integer consumeType) {
        this.consumeType = consumeType;
    }
}
