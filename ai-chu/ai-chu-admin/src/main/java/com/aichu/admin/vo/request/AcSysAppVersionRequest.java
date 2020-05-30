package com.aichu.admin.vo.request;

import io.swagger.annotations.ApiModelProperty;

/**
 * 该实体BEAN是由系统生成请勿修改
 *
 * Created by system on 2020/03/04
 */
public class AcSysAppVersionRequest{

    /** 主键ID */
    @ApiModelProperty(name = "id", value = "主键ID",hidden = false)
    private Integer id;

    /** 项目名称 */
    @ApiModelProperty(name = "appName", value = "项目名称",required = true,hidden = false)
    private String appName;

    /** 内部版本号 */
    @ApiModelProperty(name = "inVersion", value = "内部版本号",required = true,hidden = false)
    private Integer inVersion;

    /** 版本号 */
    @ApiModelProperty(name = "version", value = "版本号",required = true,hidden = false)
    private String version;

    /** 下载地址 */
    @ApiModelProperty(name = "versionUrl", value = "下载地址",required = true,hidden = false)
    private String versionUrl;

    /** 版本更新描述 */
    @ApiModelProperty(name = "versionDesc", value = "版本更新描述",hidden = false)
    private String versionDesc;

    /** 是否强制更新（0-否，1-是） */
    @ApiModelProperty(name = "isCompelUpdate", value = "是否强制更新（0-否，1-是）",required = true,hidden = false)
    private Integer isCompelUpdate;

    /** 版本类型(0-Android，1-Ios) */
    @ApiModelProperty(name = "type", value = "版本类型(0-Android，1-Ios)",required = true,hidden = false)
    private Integer type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Integer getInVersion() {
        return inVersion;
    }

    public void setInVersion(Integer inVersion) {
        this.inVersion = inVersion;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersionUrl() {
        return versionUrl;
    }

    public void setVersionUrl(String versionUrl) {
        this.versionUrl = versionUrl;
    }

    public String getVersionDesc() {
        return versionDesc;
    }

    public void setVersionDesc(String versionDesc) {
        this.versionDesc = versionDesc;
    }

    public Integer getIsCompelUpdate() {
        return isCompelUpdate;
    }

    public void setIsCompelUpdate(Integer isCompelUpdate) {
        this.isCompelUpdate = isCompelUpdate;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", appName=").append(appName);
        sb.append(", inVersion=").append(inVersion);
        sb.append(", version=").append(version);
        sb.append(", versionUrl=").append(versionUrl);
        sb.append(", versionDesc=").append(versionDesc);
        sb.append(", isCompelUpdate=").append(isCompelUpdate);
        sb.append(", type=").append(type);
        sb.append("]");
        return sb.toString();
    }
}