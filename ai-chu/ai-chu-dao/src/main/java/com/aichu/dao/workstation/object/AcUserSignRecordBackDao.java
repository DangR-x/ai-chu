package com.aichu.dao.workstation.object;

import java.io.Serializable;

/**
 * 该实体BEAN是由系统生成请勿修改
 *
 * Created by system on 2020/01/13
 */
public class AcUserSignRecordBackDao implements Serializable {
    /** 主键ID */
    private Integer id;

    /** 签到金币 */
    private Integer coin;

    /** 周卡签到赠送金币 */
    private Integer weekCoin;

    /** 月卡签到赠送金币 */
    private Integer mouthCoin;

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

    public Integer getCoin() {
        return coin;
    }

    public void setCoin(Integer coin) {
        this.coin = coin;
    }

    public Integer getWeekCoin() {
        return weekCoin;
    }

    public void setWeekCoin(Integer weekCoin) {
        this.weekCoin = weekCoin;
    }

    public Integer getMouthCoin() {
        return mouthCoin;
    }

    public void setMouthCoin(Integer mouthCoin) {
        this.mouthCoin = mouthCoin;
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
        sb.append(", coin=").append(coin);
        sb.append(", weekCoin=").append(weekCoin);
        sb.append(", mouthCoin=").append(mouthCoin);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}