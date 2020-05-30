package com.aichu.admin.vo.response;

/**
 * @ClassName AcSysLabeSelectResponse
 * @Author yuan.shuai
 * @Description 后台活动标签下拉框DTO
 * @Date 2019/8/16
 * @Version 1.0.0
 */
public class AcSysLabeSelectResponse {

    private Integer id;
    private String logo;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public void setName(String name) {
        this.name = name;
    }
}