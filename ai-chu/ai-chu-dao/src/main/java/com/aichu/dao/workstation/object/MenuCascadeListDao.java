package com.aichu.dao.workstation.object;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName MenuCascadeListDao
 * @Author yuan.shuai
 * @Description
 * @Date 2019/8/1
 * @Version 1.0.0
 */
public class MenuCascadeListDao implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String moduleName;

    private List<MenuCascadeListDao> menuCascadeList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public List<MenuCascadeListDao> getMenuCascadeList() {
        return menuCascadeList;
    }

    public void setMenuCascadeList(List<MenuCascadeListDao> menuCascadeList) {
        this.menuCascadeList = menuCascadeList;
    }
}
