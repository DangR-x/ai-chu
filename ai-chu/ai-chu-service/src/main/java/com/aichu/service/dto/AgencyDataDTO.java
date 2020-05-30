package com.aichu.service.dto;

/**
 * @ClassName HomeStatementDataResponse
 * @Author hsw
 * @Description 首頁报表日消费
 * @Date 2020/3/12
 * @Version 1.0.0
 */
public class AgencyDataDTO {
    /**
     * 当日主播提成金币
     */
    private String anchor;

    /**
     * 代理提成金币
     */
    private String agency;

    /**
     * 平台提成金币
     */
    private String platformCount;

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

    public String getPlatformCount() {
        return platformCount;
    }

    public void setPlatformCount(String platformCount) {
        this.platformCount = platformCount;
    }

}
