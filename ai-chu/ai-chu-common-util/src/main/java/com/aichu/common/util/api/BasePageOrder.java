package com.aichu.common.util.api;


import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName BasePageOrder
 * @Description 请求对象基础类 如需更多业务参数 请继承该类进行扩展
 * @Author Melon
 * @Date 2019/7/27 17:17
 * @Version 1.0.0
 **/
public class BasePageOrder {

    @ApiModelProperty(value = "页码", required = true)
    /**页码*/
    private Integer pageNum = 1;
    @ApiModelProperty(value = "每页默认显示大小", required = true)
    /**每页默认显示大小*/
    private Integer pageSize = 10;

    @ApiModelProperty(value = "排序字段")
    private String sortField;

    @ApiModelProperty(value = "排序方式")
    private String sortType;

    private String defaultOrderBy;

    public String buildOrderBy() {
        if (!StringUtils.isBlank(sortField)) {
            return sortField + " " + sortType;
        }
        return defaultOrderBy;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        //如果入参 为0 则取默认值 当前分页插件如果 pageSize 为0 由于max_allowed_packet的限制 会报PacketTooBigException
        //加此判断 也是对系统的自我保护
        if (pageSize != 0) {
            this.pageSize = pageSize;
        }
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

}
