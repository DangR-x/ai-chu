package com.aichu.service.api;

import com.aichu.dao.workstation.object.*;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @ClassName ShiroUtilService
 * @Author yuan.shuai
 * @Description Shiro管理Service
 * @Date 2019/7/18
 * @Version 1.0.0
 */
public interface ShiroUtilService {

    /**
     * @Description 通过后台用户名称查询用户信息
     * @param userName
     * @return AcAdminUserDao
     */
    AcAdminUserDao getAdminUserToUserName(String userName) throws Exception;

    /**
     * @Description 通过用户ID查询所属的角色集合
     * @Param UserId
     * @Return List<AcAdminRoleDao>
     * @Author yuan.shuai
     * @Date  2019/7/20
     */
    List<AcAdminRoleDao> getAdminRoleListToUserId(Integer userId) throws Exception;

    /**
     * @Description 通过角色ID查询 菜单角色权限表ID集合
     * @Param List<AcAdminRoleDao>
     * @Return List<Integer>
     * @Author yuan.shuai
     * @Date  2019/7/20
     */
    List<Integer> getRolePermissionToRoleList(List<AcAdminRoleDao> roleList) throws Exception;

    /**
     * @Description 获取所有的角色权限菜单数据
     * @Return List<WzAdminModuleJurDao>
     * @Author yuan.shuai
     * @Date  2019/9/6
     * @Version 1.0.0
     */
    List<AcAdminModuleJurDao> getAllAdminModuleJur() throws Exception;

    /**
     * @Description 通过用户ID查询所有权限名称和角色名称
     * @Param  UserId
     * @Return HashMap<String, Set<String>>
     * @Author yuan.shuai
     * @Date  2019/7/23
     */
    HashMap<String, Set<String>> getAllPermissionNameAndRoleName(Integer userId) throws Exception;
}
