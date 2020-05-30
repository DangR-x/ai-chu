package com.aichu.dao.workstation.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName AcAdminRoleDescriptionDaoMapper
 * @Author yuan.shuai
 * @Description 后台角色权限中间表Mapper
 * @Date 2019/7/20
 * @Version 1.0.0
 */
public interface AcAdminRoleDescriptionDaoMapper {

    /**
     * @Description 删除角色权限（修改is_delete状态值）
     * @Param roleId
     * @Return Integer
     * @Author yuan.shuai
     * @Date  2019/8/2
     * @Version 1.0.0
     */
    Integer deleteRoleDescriptionToRoleId(@Param("roleId") Integer roleId);

    /**
     * @Description 查询角色的所有权限数据
     * @Param roleId
     * @Return
     * @Author yuan.shuai
     * @Date  2019/8/2
     * @Version 1.0.0
     */
    List<String> queryAllRoleDescriptionToRoleId(@Param("roleId") Integer roleId);

    /**
     * @Description 通过角色Id和权限代码删除权限关联数据（修改is_delete）
     * @Param roleId,permsCode
     * @Return
     * @Author yuan.shuai
     * @Date  2019/8/2
     * @Version 1.0.0
     */
    Integer updateRoleDescriptionToRoleIdAndCode(@Param("roleId") Integer roleId, @Param("permsCode") String permsCode);

}