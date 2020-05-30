package com.aichu.common.util.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.Valid;
import java.io.Serializable;

/**
 * @ClassName Request
 * @Description 请求对象基础类 如需更多业务参数 请继承该类进行扩展
 * @Author Melon
 * @Date 2019/7/19 10:13
 * @Version 1.0.0
 **/
@ApiModel("接口公共信息封装")
public class Request<T> implements Serializable {

    /**
     * 外部版本： eg 0.9
     */
    @ApiModelProperty(name="version_i",value="外部版本(eg 0.9)",required=false, hidden=false)
    private String version_inner;

    /**
     * 内部版本：eg 100-201900401-0090
     * version-inner
     */
    @ApiModelProperty(name="version_outer",value="内部版本(eg 100-201900401-0090)",required=false, hidden=false)
    private String version_outer;
    /**
     * App、后台...
     */
    @ApiModelProperty(name="source",value="渠道(eg App、后台...)",required=false, hidden=false)
    private Integer source;
    /**
     * 时间戳
     */
    @ApiModelProperty(name="time",value="时间戳",required=false, hidden=false)
    private String time;
    /**
     * 请求参数
     */
    @Valid
    @ApiModelProperty(name="data",value="请求参数",required=true, hidden=false)
    private T data;

    public String getVersion_inner() {
        return version_inner;
    }

    public void setVersion_inner(String version_inner) {
        this.version_inner = version_inner;
    }

    public String getVersion_outer() {
        return version_outer;
    }

    public void setVersion_outer(String version_outer) {
        this.version_outer = version_outer;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Request{" +
                "version_inner='" + version_inner + '\'' +
                ", version_outer='" + version_outer + '\'' +
                ", source=" + source +
                ", time='" + time + '\'' +
                ", data=" + data +
                '}';
    }
}
