package com.aichu.service.dto;

import java.io.Serializable;

/**
 * 该实体BEAN是由系统生成请勿修改
 *
 * Created by system on 2020/03/04
 */
public class AcSysAppVersionBackDTO implements Serializable {
    /** 主键ID */
    private Integer id;

    /** 项目名称 */
    private String appName;

    /** 内部版本号 */
    private Integer inVersion;

    /** 版本号 */
    private String version;

    /** 下载地址 */
    private String versionUrl;

    /** 版本更新描述 */
    private String versionDesc;

    /** 是否强制更新（0-否，1-是） */
    private Integer isCompelUpdate;

    /** 版本类型(0-Android，1-Ios) */
    private Integer type;

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
        sb.append(", appName=").append(appName);
        sb.append(", inVersion=").append(inVersion);
        sb.append(", version=").append(version);
        sb.append(", versionUrl=").append(versionUrl);
        sb.append(", versionDesc=").append(versionDesc);
        sb.append(", isCompelUpdate=").append(isCompelUpdate);
        sb.append(", type=").append(type);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}