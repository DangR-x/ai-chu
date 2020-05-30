package com.aichu.dao.workstation.mapper;

import com.aichu.dao.workstation.object.MenuCascadeListDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName AcAdminModuleDaoMapper
 * @Author yuan.shuai
 * @Description 后台菜单表Mapper
 * @Date 2019/7/20
 * @Version 1.0.0
 */
public interface AcAdminModuleDaoMapper {

    /**
     * @Description 查询一级菜单
     * @Return List<MenuCascadeListDao>
     * @Author yuan.shuai
     * @Date  2019/8/1
     * @Version 1.0.0
     */
    List<MenuCascadeListDao> getMenuCascadeList();

    /**
     * @Description 查询二级菜单
     * @Param  parentId
     * @Return List<MenuCascadeListDao>
     * @Author yuan.shuai
     * @Date  2019/8/1
     * @Version 1.0.0
     */
    List<MenuCascadeListDao> getTwoMenuCascadeList(@Param("parentId") Integer parentId);

    /**
     * @Description 查询二级菜单权限
     * @Param  parentId
     * @Return List<MenuCascadeListDao>
     * @Author yuan.shuai
     * @Date  2019/8/1
     * @Version 1.0.0
     */
    List<MenuCascadeListDao> getPemissionMenuCascadeList(@Param("parentId") Integer parentId);

    /**
     * @Description 获取角色权限ID
     * @Param roleId
     * @Return List<Integer>
     * @Author yuan.shuai
     * @Date  2019/8/1
     * @Version 1.0.0
     */
    List<Integer> getRolePermissionIdList(@Param("roleId") Integer roleId);

}