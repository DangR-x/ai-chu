package com.aichu.admin.vo.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 该实体BEAN是由系统生成请勿修改
 *
 * Created by system on 2020/01/13
 */
public class AcChartGoodsRequest {
    /** 主键ID */
    @ApiModelProperty(name="id",value="主键ID",hidden=false)
    private Integer id;

    /** 商品名称 */
    @ApiModelProperty(name="goodsName",value="商品名称",required = true,hidden=false)
    @NotBlank(message = "商品名称不能为空")
    private String goodsName;

    /** 商品图片 */
    @ApiModelProperty(name="goodsImage",value="商品图片",hidden=false)
    //@NotBlank(message = "商品图片不能为空")
    private String goodsImage;

    /** 商品价格 */
    @ApiModelProperty(name="goodsMoney",value="商品价格",required = true,hidden=false)
    @NotNull(message = "商品价格不能为空")
    private Integer goodsMoney;

    /** 功能描述 */
    @ApiModelProperty(name="functionDes",value="功能描述",hidden=false)
    private String functionDes;

    /** 是否上架（0-否，1-是） */
    @ApiModelProperty(name="isPutaway",value="是否上架（0-否，1-是）",required = true,hidden=false)
    @NotNull(message = "是否上架不能为空")
    private Integer isPutaway;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(String goodsImage) {
        this.goodsImage = goodsImage;
    }

    public Integer getGoodsMoney() {
        return goodsMoney;
    }

    public void setGoodsMoney(Integer goodsMoney) {
        this.goodsMoney = goodsMoney;
    }

    public String getFunctionDes() {
        return functionDes;
    }

    public void setFunctionDes(String functionDes) {
        this.functionDes = functionDes;
    }

    public Integer getIsPutaway() {
        return isPutaway;
    }

    public void setIsPutaway(Integer isPutaway) {
        this.isPutaway = isPutaway;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", goodsName=").append(goodsName);
        sb.append(", goodsImage=").append(goodsImage);
        sb.append(", goodsMoney=").append(goodsMoney);
        sb.append(", functionDes=").append(functionDes);
        sb.append(", isPutaway=").append(isPutaway);
        sb.append("]");
        return sb.toString();
    }
}