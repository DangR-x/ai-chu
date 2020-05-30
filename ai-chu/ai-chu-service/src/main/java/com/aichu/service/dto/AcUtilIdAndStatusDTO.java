package com.aichu.service.dto;

/**
 * @program: ai-chu
 * @description 通用修改状态DTO
 * @author: Yuan.shuai
 * @create: 2020-02-18 14:47
 **/
public class AcUtilIdAndStatusDTO {

    private Integer id;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
