package com.aichu.admin.vo.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * 该实体BEAN是由系统生成请勿修改
 *
 * Created by system on 2020/02/19
 */
public class AcSysChargeConfigRequest  {
    /** 主键ID */
    @ApiModelProperty(name="id",value="主键ID",hidden=false)
    private Integer id;

    /** 充值金额（单位：分） */
    @ApiModelProperty(name="chargeAmount",value="充值金额（单位：分）",required = true,hidden=false)
    @NotNull(message = "充值金额不能为空")
    private Integer chargeAmount;

    /** 充值金币 */
    @ApiModelProperty(name="chargeCoin",value="充值金币",required = true,hidden=false)
    @NotNull(message = "充值金币不能为空")
    private Integer chargeCoin;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getChargeAmount() {
        return chargeAmount;
    }

    public void setChargeAmount(Integer chargeAmount) {
        this.chargeAmount = chargeAmount;
    }

    public Integer getChargeCoin() {
        return chargeCoin;
    }

    public void setChargeCoin(Integer chargeCoin) {
        this.chargeCoin = chargeCoin;
    }

}