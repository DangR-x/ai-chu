package com.aichu.admin.vo.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * 该实体BEAN是由系统生成请勿修改
 *
 * Created by system on 2020/01/13
 */
public class AcSysAgentConfigRequest {

    /** 主键ID */
    @ApiModelProperty(name = "id", value = "主键ID",hidden = false)
    private Integer id;

    /** 代理等级(0-7) */
    @ApiModelProperty(name = "level", value = "代理等级(0-7) ",required = true,hidden = false)
    @NotNull(message = "代理等级不能为空")
    private Integer level;

    /** 可代理人数下线 */
    @ApiModelProperty(name = "minUserNum", value = "可代理人数下线",required = true,hidden = false)
    @NotNull(message = "可代理人数下线")
    private Integer minUserNum;

    /** 可代理人数上线 */
    @ApiModelProperty(name = "maxUserNum", value = "可代理人数上线",required = true,hidden = false)
    @NotNull(message = "可代理人数上线不能为空")
    private Integer maxUserNum;

    /** 提成比率（0-100） */
    @ApiModelProperty(name = "deductRate", value = "提成比率（0-100） ",required = true,hidden = false)
    @NotNull(message = "提成比率不能为空")
    private Integer deductRate;

    /** 升级满足的收益值（金币） */
    @ApiModelProperty(name = "riseEarnings", value = "升级满足的收益值（金币）",required = true,hidden = false)
    @NotNull(message = "升级满足的收益值不能为空")
    private Integer riseEarnings;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getMinUserNum() {
        return minUserNum;
    }

    public void setMinUserNum(Integer minUserNum) {
        this.minUserNum = minUserNum;
    }

    public Integer getMaxUserNum() {
        return maxUserNum;
    }

    public void setMaxUserNum(Integer maxUserNum) {
        this.maxUserNum = maxUserNum;
    }

    public Integer getDeductRate() {
        return deductRate;
    }

    public void setDeductRate(Integer deductRate) {
        this.deductRate = deductRate;
    }

    public Integer getRiseEarnings() {
        return riseEarnings;
    }

    public void setRiseEarnings(Integer riseEarnings) {
        this.riseEarnings = riseEarnings;
    }

}