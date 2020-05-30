package com.aichu.dao.workstation.mapper;

import com.aichu.dao.workstation.object.AcAdminRoleDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName AcShiroUtilDaoMapper
 * @Author yuan.shuai
 * @Description Shiro认证公共Mapper
 * @Date 2019/7/20
 * @Version 1.0.0
 */
public interface AcShiroUtilDaoMapper {
    /**
     * @Description 通过角色ID查询 菜单角色权限表ID
     * @Param roleList
     * @Return List<AcAdminRoleDao>
     * @Author yuan.shuai
     * @Date  2019/7/20
     */
    List<Integer> getRolePermission(@Param("roleList") List<AcAdminRoleDao> roleList);

    /**
     * @Description 通过角色ID查询 菜单角色权限表ID
     * @Param roleId
     * @Return List<WzAdminRoleDao>
     * @Author yuan.shuai
     * @Date  2019/7/20
     */
    List<Integer> getRolePermissionToRoleId(@Param("roleId") Integer roleId);
}
