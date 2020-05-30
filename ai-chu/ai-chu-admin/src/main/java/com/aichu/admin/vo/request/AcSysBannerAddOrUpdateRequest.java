package com.aichu.admin.vo.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @ClassName AcSysBannerAddOrUpdateRequest
 * @Author yuan.shuai
 * @Description
 * @Date 2019/8/26
 * @Version 1.0.0
 */
public class AcSysBannerAddOrUpdateRequest {

    /** 主键ID */
    @ApiModelProperty(name="id",value="主键ID",hidden=false)
    private Integer id;

    /** Banner地址链接 */
    @ApiModelProperty(name="bannerUrl",value="Banner地址链接",required = true,hidden=false)
    @NotBlank(message = "Banner图片链接不能为空")
    private String bannerUrl;

    /** Banner类型（0-启动页，1-恭喜Banner,........） */
    @ApiModelProperty(name="bannerType",value="Banner类型（0-启动页，1-恭喜Banner,........）",required = true,hidden=false)
    @NotNull(message = "Banner类型不能为空")
    private Integer bannerType;

    /** Banner类型Code */
    @ApiModelProperty(name="bannerTypeCode",value="Banner类型Code",required = true,hidden=false)
    @NotBlank(message = "Banner类型Code不能为空")
    private String bannerTypeCode;

    /** Banner描述信息 */
    @ApiModelProperty(name="bannerDesc",value="Banner描述信息",hidden=false)
    private String bannerDesc;

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
}
