package com.aichu.dao.autogeneration.object;

import java.io.Serializable;
import java.util.Date;

/**
 * 该实体BEAN是由系统生成请勿修改
 *
 * Created by system on 2020/03/10
 */
public class AcSysAgentConfigDO implements Serializable {
    /** 主键ID */
    private Integer id;

    /** 代理等级(0-7) */
    private Integer level;

    /** 可代理人数下线 */
    private Integer minUserNum;

    /** 可代理人数上线 */
    private Integer maxUserNum;

    /** 提成比率（0-100） */
    private Integer deductRate;

    /** 升级满足的收益值（金币） */
    private Integer riseEarnings;

    /** 是否删除（0-否，1-是） */
    private Integer isDelete;

    /** 创建时间 */
    private Date createTime;

    private static final long serialVersionUID = 1L;

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

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", level=").append(level);
        sb.append(", minUserNum=").append(minUserNum);
        sb.append(", maxUserNum=").append(maxUserNum);
        sb.append(", deductRate=").append(deductRate);
        sb.append(", riseEarnings=").append(riseEarnings);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}