package com.aichu.dao.workstation.object;

import java.io.Serializable;

/**
 * @ClassName HomeStatementDataResponse
 * @Author hsw
 * @Description 首頁报表日消费
 * @Date 2020/3/12
 * @Version 1.0.0
 */
public class AgencyDataDao implements Serializable {
    /**
     * 当日主播提成金币
     */
    private String anchor;

    /**
     * 代理提成金币
     */
    private String agency;

    public String getAnchor() {
        return anchor;
    }

    public void setAnchor(String anchor) {
        this.anchor = anchor;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }


}
