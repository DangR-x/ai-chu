package com.aichu.admin.vo.response;

import java.io.Serializable;
import java.util.Date;

/**
 * 该实体BEAN是由系统生成请勿修改
 *
 * Created by system on 2020/02/22
 */
public class AcUserPhoneRecordResponse implements Serializable {

    /** 主键ID */
    private Integer id;

    /** 拨打人号码 */
    private String userPhone;

    /** 被拨打用户ID */
    private String teUserPhone;

    /** 通话时长 */
    private String telTime;

    /** 通话状态（0-呼入，1-呼出）*/
    private Integer type;

    /** 创建时间 */
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTelTime() {
        return telTime;
    }

    public void setTelTime(String telTime) {
        this.telTime = telTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getTeUserPhone() {
        return teUserPhone;
    }

    public void setTeUserPhone(String teUserPhone) {
        this.teUserPhone = teUserPhone;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}