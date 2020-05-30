package com.aichu.service.dto;

import com.aichu.dao.workstation.object.MenuCascadeListDao;

import java.util.List;

/**
 * @ClassName MenuListDTO
 * @Author yuan.shuai
 * @Description 菜单级联列表
 * @Date 2019/8/1
 * @Version 1.0.0
 */
public class MenuListDTO {
    private Integer id;

    private String  moduleName;

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
