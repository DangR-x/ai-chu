package com.aichu.admin.vo.response;

/**
 * @ClassName AcSysBannerResponse
 * @Author yuan.shuai
 * @Description 系统Banner管理DTO
 * @Date 2019/8/26
 * @Version 1.0.0
 */
public class AcSysBannerResponse {

    /** 主键ID */
    private Integer id;

    /** Banner地址链接 */
    private String bannerUrl;

    /** Banner类型（0-启动页，1-恭喜Banner,........） */
    private Integer bannerType;

    /** Banner类型Code */
    private String bannerTypeCode;

    /** Banner描述信息 */
    private String bannerDesc;

    /** 创建时间 */
    private String createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public Integer getBannerType() {
        return bannerType;
    }

    public void setBannerType(Integer bannerType) {
        this.bannerType = bannerType;
    }

    public String getBannerTypeCode() {
        return bannerTypeCode;
    }

    public void setBannerTypeCode(String bannerTypeCode) {
        this.bannerTypeCode = bannerTypeCode;
    }

    public String getBannerDesc() {
        return bannerDesc;
    }

    public void setBannerDesc(String bannerDesc) {
        this.bannerDesc = bannerDesc;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
