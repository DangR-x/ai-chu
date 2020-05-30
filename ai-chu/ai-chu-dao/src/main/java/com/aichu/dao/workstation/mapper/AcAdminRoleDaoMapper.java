package com.aichu.dao.workstation.mapper;

import com.aichu.dao.workstation.object.AcAdminRoleDao;
import com.aichu.dao.workstation.object.AdminRoleBackListDao;
import com.aichu.dao.workstation.object.AdminRoleBackSelectDao;
import com.aichu.dao.workstation.object.AdminRoleUpdateOrAddDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName AcAdminRoleDaoMapper
 * @Author yuan.shuai
 * @Description 后台角色表Mapper
 * @Date 2019/7/20
 * @Version 1.0.0
 */
public interface AcAdminRoleDaoMapper {
    /**
     * @Description 通过用户ID查询所有角色
     * @Param UserId
     * @Return List<AcAdminRoleDao>
     * @Author yuan.shuai
     * @Date  2019/7/20
     */
    List<AcAdminRoleDao> getAdminUserRoleListToUserId(@Param("userId") Integer userId);

    /**
     * @Description 通过用户ID查询所有角色ID
     * @Param userId
     * @Return roleId
     * @Author yuan.shuai
     * @Date  2019/7/30
     * @Version 1.0.0
     */
    List<Integer> getRoleIdListToUserId(@Param("id") Integer id);

    /**
     * @Description 通过用户Id查询所有角色名称
     * @Param userId
     * @Return
     * @Author yuan.shuai
     * @Date  2019/7/30
     * @Version 1.0.0
     */
    List<String> getRoleNameListToUserId(@Param("id") Integer id);

    /**
     * @Description 通过用户ID删除用户角色中间表
     * @Param userId
     * @Return
     * @Author yuan.shuai
     * @Date  2019/7/30
     * @Version 1.0.0
     */
    int stopOrStartUserRoleToUserId(@Param("userId") Integer userId, @Param("status") Integer status);

    /**
     * @Description 通过用户ID查询用户角色中间表总数
     * @Param userId
     * @Return count
     * @Author yuan.shuai
     * @Date  2019/7/31
     * @Version 1.0.0
     */
    Integer queryAdminUserRoleCountToUserId(@Param("userId") Integer userId);

    /**
     * @Description 查询所有后台角色（角色选择下拉框）
     * @Return java.util.List<AdminRoleBackSelectDao>
     * @Author yuan.shuai
     * @Date  2019/7/31
     * @Version 1.0.0
     */
    List<AdminRoleBackSelectDao> getAdminRoleBackSelectList();

    /**
     * @Description 删除管理员角色中间表
     * @Param userId
     * @Return Integer
     * @Author yuan.shuai
     * @Date  2019/8/1
     * @Version 1.0.0
     */
    Integer deleteAdminUserRoleData(@Param("userId") Integer userId);

    /**
     * @Description 修改角色
     * @Param AdminRoleUpdateOrAddDao
     * @Return Integer
     * @Author yuan.shuai
     * @Date  2019/8/1
     * @Version 1.0.0
     */
    Integer updateAdminRole(AdminRoleUpdateOrAddDao updateOrAddDao);

    /**
     * @Description 查询后台角色列表
     * @Return List<AdminRoleBackListDao>
     * @Author yuan.shuai
     * @Date  2019/8/1
     * @Version 1.0.0
     */
    List<AdminRoleBackListDao> getAdminBackList();

    /**
     * @Description 获取角色Code
     * @Param roleId
     * @Return String
     * @Author yuan.shuai
     * @Date  2019/8/2
     * @Version 1.0.0
     */
    String getAdminRoleCodeToId(@Param("roleId") Integer roleId);

    /**
     * @Description 检查角色名称是否存在
     * @Param roleName
     * @Return Integer
     * @Author yuan.shuai
     * @Date  2019/8/2
     * @Version 1.0.0
     */
    Integer queryRoleNameIsExist(@Param("roleName") String roleName);

    /**
     * @Description 检查角色Code是否存在
     * @Param roleCode
     * @Return Integer
     * @Author yuan.shuai
     * @Date  2019/8/2
     * @Version 1.0.0
     */
    Integer queryRoleCodeIsExist(@Param("roleCode") String roleCode);
}