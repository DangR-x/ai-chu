package com.aichu.admin.vo.request;

import com.aichu.common.util.api.BasePageOrder;
import io.swagger.annotations.ApiModelProperty;

/**
 * @program: ai-chu
 * @description
 * @author: Yuan.shuai
 * @create: 2020-02-17 15:35
 **/
public class AcOrderWithdrawQueryRequest extends BasePageOrder {

    @ApiModelProperty(name = "name", value = "关键词",hidden = false)
    private String name;

    @ApiModelProperty(name = "withDrawStatus", value = "提现状态（0-提现中，1-已拒绝，2-提现成功, 3-提现失败）",hidden = false)
    private Integer withDrawStatus;

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

    public Integer getWithDrawStatus() {
        return withDrawStatus;
    }

    public void setWithDrawStatus(Integer withDrawStatus) {
        this.withDrawStatus = withDrawStatus;
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
}
