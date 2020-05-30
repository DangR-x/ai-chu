package com.aichu.dao.workstation.object;

import java.io.Serializable;
/**
 * 该实体BEAN是由系统生成请勿修改
 *
 * Created by system on 2020/01/13
 */
public class AcChartGoodsDao implements Serializable {
    /** 主键ID */
    private Integer id;

    /** 商品名称 */
    private String goodsName;

    /** 商品图片 */
    private String goodsImage;

    /** 商品价格 */
    private Integer goodsMoney;

    /** 功能描述 */
    private String functionDes;

    /** 是否上架（0-否，1-是） */
    private Integer isPutaway;

    /** 是否删除（0-否，1-是） */
    private Integer isDelete;

    /** 创建时间 */
    private String createTime;

    private static final long serialVersionUID = 1L;

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

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
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
        sb.append(", isDelete=").append(isDelete);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}