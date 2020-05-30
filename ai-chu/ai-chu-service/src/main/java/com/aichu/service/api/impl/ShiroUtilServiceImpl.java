package com.aichu.service.api.impl;

import com.aichu.common.util.exception.BusinessException;
import com.aichu.dao.workstation.mapper.*;
import com.aichu.dao.workstation.object.*;
import com.aichu.manager.enums.ResultCodeEnum;
import com.aichu.service.api.ShiroUtilService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @ClassName ShiroUtilServiceImpl
 * @Author yuan.shuai
 * @Description
 * @Date 2019/7/18
 * @Version 1.0.0
 */
@Service
public class ShiroUtilServiceImpl implements ShiroUtilService {

    private Logger logger = LoggerFactory.getLogger(ShiroUtilServiceImpl.class);

    @Autowired
    private AcShiroUtilDaoMapper shiroUtilDaoMapper;

    @Autowired
    private AcAdminUserDaoMapper adminUserDaoMapper;

    @Autowired
    private AcAdminRoleDaoMapper adminRoleDaoMapper;

    @Autowired
    private AcAdminModuleJurDaoMapper adminModuleJurDaoMapper;

    /**
     * 通过后台用户名称查询用户信息
     * @param userName
     * @return
     */
    @Override
    public AcAdminUserDao getAdminUserToUserName(String userName) {
        if (Objects.nonNull(userName)){
            AcAdminUserDao adminUserDao = adminUserDaoMapper.getAdminUserToUserName(userName);
            return adminUserDao;
        }
        return null;
    }

    /**
     * 通过用户ID查询所属的角色集合
     * @param userId
     * @return
     */
    @Override
    public List<AcAdminRoleDao> getAdminRoleListToUserId(Integer userId) {
        if (Objects.nonNull(userId)){
            List<AcAdminRoleDao> adminRoleDaoList = adminRoleDaoMapper.getAdminUserRoleListToUserId(userId);
            return  adminRoleDaoList;
        }
        return null;
    }

    /**
     * 获取所有的角色权限菜单数据
     * @return List<WzAdminModuleJurDao>
     * @throws Exception
     */
    @Override
    public List<AcAdminModuleJurDao> getAllAdminModuleJur(){
        List<AcAdminModuleJurDao> adminModuleJurDao = adminModuleJurDaoMapper.getAllAdminModuleJur();
        return adminModuleJurDao;
    }

    /**
     * 通过角色ID集合查询 菜单角色权限表ID集合
     * @param roleList
     * @return List<Integer>
     */
    @Override
    public List<Integer> getRolePermissionToRoleList(List<AcAdminRoleDao> roleList) {
        if (Objects.nonNull(roleList)){
            List<Integer> permissionIdList = shiroUtilDaoMapper.getRolePermission(roleList);
            return permissionIdList;
        }
        return null;
    }

    /**
     * 通过用户ID查询所有权限名和角色名称
     * @param userId
     * @return
     * @throws AuthenticationException
     */
    @Override
    public HashMap<String, Set<String>> getAllPermissionNameAndRoleName(Integer userId) throws AuthenticationException {
        if (Objects.isNull(userId)){
            logger.info("用户ID为空");
            throw new BusinessException(ResultCodeEnum.USER_INFO_NOT_EXISTED.code(),ResultCodeEnum.USER_INFO_NOT_EXISTED.message());
        }
        //保存所有角色名
        Set<String> allRoles = new HashSet<>();
        //保存所有的权限菜单
        Set<String> allPermissions = new HashSet<>();
        //通过用户Id查询用户角色和权限
        List<AcAdminRoleDao> userRole = this.getAdminRoleListToUserId(userId);
        // 通过roleId查询出，角色所拥有的权限
        if (Objects.isNull(userRole)){
            logger.info("此用户："+userId+ " 没有角色权限");
            throw new BusinessException(ResultCodeEnum.JURISDICTION_ERROR.code(),ResultCodeEnum.JURISDICTION_ERROR.message());
        }
        List<Integer> allPermissionIdList = this.getRolePermissionToRoleList(userRole);
        //查出所有菜单权限数据
        List<AcAdminModuleJurDao> allMenuPermission = this.getAllAdminModuleJur();
        //筛选出用户的所对应的菜单权限
        for (Integer permissionId : allPermissionIdList){
            allMenuPermission.forEach(item -> {
                if (item.getModuleId().equals(permissionId)){
                    allPermissions.add(item.getModuleId().toString());
                }
            });
        }
        userRole.forEach(item -> allRoles.add(item.getRoleName()));
        HashMap<String,Set<String>> hashMap = new HashMap<>();
        hashMap.put("allRoles",allRoles);
        hashMap.put("allPermissions",allPermissions);
        // 存入Session中，减少二次查询
        SecurityUtils.getSubject().getSession().setAttribute("adminUser"+userId,hashMap);
        return hashMap;
    }
}
