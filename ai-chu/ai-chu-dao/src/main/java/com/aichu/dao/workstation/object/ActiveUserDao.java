package com.aichu.dao.workstation.object;


import java.io.Serializable;

/**
 * @ClassName ActiveUserDao
 * @Author hsw
 * @Description
 * @Date 2020/3/12
 * @Version 1.0.0
 */
public class ActiveUserDao implements Serializable {
    /** 时间 */
    private String date;

    /** 数量 */
    private Integer number;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
