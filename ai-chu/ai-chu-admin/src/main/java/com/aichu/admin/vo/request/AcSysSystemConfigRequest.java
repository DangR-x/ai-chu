package com.aichu.admin.vo.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @ClassName AcSysSystemConfigRequest
 * @Author yuan.shuai
 * @Description 系统配置Request
 * @Date 2019/9/19
 * @Version 1.0.0
 */
public class AcSysSystemConfigRequest {

    /** 主键 */
    @ApiModelProperty(name="id",value="主键ID",hidden=false)
    private Integer id;

    /** 关键词KEY */
    @ApiModelProperty(name="keys",value="关键词KEY",required = true,hidden=false)
    @NotBlank(message = "关键词KEY不能未空")
    private String keys;

    /** 关键词名称 */
    @ApiModelProperty(name="keyName",value="关键词名称",required = true,hidden=false)
    @NotBlank(message = "关键词名称不能未空")
    private String keyName;

    /** 关键词的值 */
    @ApiModelProperty(name="value",value="关键词的值",required = true,hidden=false)
    @NotBlank(message = "关键词的值不能未空")
    private String value;

    /** 备注说明 */
    @ApiModelProperty(name="comment",value="备注说明",hidden=false)
    private String comment;

    /** 配置类型（0-关键词，1-文件，2-链接） */
    @ApiModelProperty(name="type",value="配置类型（0-关键词，1-文件，2-链接）",required = true,hidden=false)
    @NotNull(message = "配置类型不能未空")
    private Integer type;

    /** 用途（0-系统，1-后台，2-移动应用，3-官网，4-H5）*/
    @ApiModelProperty(name="source",value="用途（0-系统，1-后台，2-移动应用，3-官网，4-H5）",required = true,hidden=false)
    @NotNull(message = "用途类型不能未空")
    private Integer source;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }
}
