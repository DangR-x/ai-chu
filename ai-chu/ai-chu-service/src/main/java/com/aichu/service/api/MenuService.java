package com.aichu.service.api;

import com.aichu.service.dto.MenuListDTO;

import java.util.List;

/**
 * @ClassName MenuService
 * @Author yuan.shuai
 * @Description
 * @Date 2019/8/1
 * @Version 1.0.0
 */
public interface MenuService {
    /**
     * @Description 获取菜单级联列表
     * @Return java.util.List<MenuListDTO>
     * @Author yuan.shuai
     * @Date  2019/8/1
     * @Version 1.0.0
     */
    List<MenuListDTO> getMenuCascadeList() throws Exception;
}
