package com.aichu.common.util.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName BaseResponse
 * @Description 如果有分页放回结果 集成该类
 * @Author Melon
 * @Date 2019/7/27 17:54
 * @Version 1.0.0
 **/
@ApiModel(value = "响应结果实体")
public class BaseResponse<T> {

    /**
     * 总记录数
     **/
    @ApiModelProperty(value = "分页查询总记录数")
    private long count;

    @ApiModelProperty(value = "响应结果实体")
    private T data;

    public BaseResponse() {
    }

    public BaseResponse(long count, T data) {
        this.count = count;
        this.data = data;
    }

    public static <T> BaseResponse<T> create() {
        return new BaseResponse<>();
    }

    public static <T> BaseResponse<T> create(long count, T data) {
        return new BaseResponse<>(count, data);
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
