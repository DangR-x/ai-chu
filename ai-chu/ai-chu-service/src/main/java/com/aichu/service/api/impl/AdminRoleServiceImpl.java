package com.aichu.service.api.impl;

import com.aichu.common.util.api.BasePageOrder;
import com.aichu.common.util.api.BaseResponse;
import com.aichu.common.util.common.BeanUtil;
import com.aichu.common.util.exception.BusinessException;
import com.aichu.dao.autogeneration.mapper.AcAdminRoleDescriptionMapper;
import com.aichu.dao.autogeneration.mapper.AcAdminRoleMapper;
import com.aichu.dao.autogeneration.object.AcAdminRoleDO;
import com.aichu.dao.autogeneration.object.AcAdminRoleDescriptionDO;
import com.aichu.dao.workstation.mapper.*;
import com.aichu.dao.workstation.object.*;
import com.aichu.manager.enums.ResultCodeEnum;
import com.aichu.manager.enums.TableIsDeleteEnum;
import com.aichu.service.api.AdminRoleService;
import com.aichu.service.api.ShiroUtilService;
import com.aichu.service.dto.AdminRoleBackListDTO;
import com.aichu.service.dto.AdminRoleBackSelectDTO;
import com.aichu.service.dto.AdminRolePermissionDTO;
import com.aichu.service.dto.UpdateOrAddRoleDTO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @ClassName AdminRoleServiceImpl
 * @Author yuan.shuai
 * @Description
 * @Date 2019/7/23
 * @Version 1.0.0
 */
@Service
public class AdminRoleServiceImpl implements AdminRoleService {

    private Logger logger = LoggerFactory.getLogger(AdminRoleServiceImpl.class);

    @Autowired
    private ShiroUtilService shiroUtilService;

    @Autowired
    private AcAdminUserRoleDaoMapper acAdminUserRoleDaoMapper;

    @Autowired
    private AcAdminRoleDaoMapper acAdminRoleDaoMapper;

    @Autowired
    private AcAdminRoleMapper acAdminRoleMapper;

    @Autowired
    private AcAdminModuleDaoMapper acAdminModuleDaoMapper;

    @Autowired
    private AcAdminModuleJurDaoMapper acAdminModuleJurDaoMapper;

    @Autowired
    private AcAdminRoleDescriptionMapper acAdminRoleDescriptionMapper;

    @Autowired
    private AcAdminRoleDescriptionDaoMapper acAdminRoleDescriptionDaoMapper;

    /**
     * 通过session查询当前用户的菜单和角色
     * @return
     */
    @Override
    public HashMap<String,Object> queryUserModuleAndRole() throws Exception{
        AcAdminUserDao acAdminUserDao = (AcAdminUserDao) SecurityUtils.getSubject().getPrincipal();
        if (Objects.isNull(acAdminUserDao)){
            logger.info("没有在Session中获取到用户缓存信息");
            throw new BusinessException(ResultCodeEnum.PARAM_ERROR.code(),ResultCodeEnum.PARAM_ERROR.message());
        }
        logger.info("这是从session取出的用户信息："+ acAdminUserDao.getUserName() +"-"+acAdminUserDao.getId());
        List<String> roleNameList = new ArrayList<>();
        Set<Integer> moduleSet = new HashSet<>();
        Set<String> urlSet = new HashSet<>();
        //通过 用户ID查询用户角色信息
        List<AcAdminRoleDao> userRole = this.queryAllUserRole(acAdminUserDao.getId());
        // 通过roleId查询出，角色所拥有的权限
        if (Objects.isNull(userRole)){
            logger.info("此用户："+acAdminUserDao.getId()+ " 没有角色权限");
            throw new BusinessException(ResultCodeEnum.JURISDICTION_ERROR.code(),ResultCodeEnum.JURISDICTION_ERROR.message());
        }
        //查出角色权限数据
        List<Integer> allPermissionIdList = shiroUtilService.getRolePermissionToRoleList(userRole);
        //查出所有菜单权限数据
        List<AcAdminModuleJurDao> allMenuPermission = shiroUtilService.getAllAdminModuleJur();
        //筛选出用户的所对应的菜单权限
        for (Integer permissionId : allPermissionIdList){
            allMenuPermission.forEach(item -> {
                if (Objects.equals(item.getId(),permissionId)){
                    moduleSet.add(item.getModuleId());
                    urlSet.add(item.getUrl());
                }
            });
        }
        userRole.forEach(item ->roleNameList.add(item.getRoleName()));
        //Object object = SecurityUtils.getSubject().getSession().getAttribute("adminUser"+wzAdminUserDao.getId());
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("allRoles",roleNameList);
        hashMap.put("allPermissions",moduleSet);
        hashMap.put("allUrl",urlSet);
        if (Objects.isNull(hashMap)){
            logger.info("系统异常，没有获取到Shiro保存的Session值");
            throw new BusinessException(ResultCodeEnum.SYSTEM_ERROR.code(),ResultCodeEnum.SYSTEM_ERROR.message());
        }
        return hashMap;
    }

    /**
     * 查询用户所有的角色
     * @param userId
     * @return
     */
    @Override
    public List<AcAdminRoleDao> queryAllUserRole(Integer userId) {
        if (Objects.nonNull(userId)){
            List<AcAdminRoleDao> roleList = acAdminUserRoleDaoMapper.getRoleToUserId(userId);
            return roleList;
        }
        return new ArrayList<>();
    }

    @Override
    public List<AdminRoleBackSelectDTO> getAdminRoleBackSelectList() throws Exception {
        logger.info("------------查询后台所有角色(下拉框)------------Start");

        List<AdminRoleBackSelectDao> list = acAdminRoleDaoMapper.getAdminRoleBackSelectList();

        logger.info("------------查询后台所有角色(下拉框)------------End");
        return BeanUtil.copy(list,AdminRoleBackSelectDTO.class);
    }

    @Override
    public BaseResponse<List<AdminRoleBackListDTO>> getAdminRoleBackList(BasePageOrder basePageOrder) throws Exception {
        logger.info("------------查询后台角色列表------------Start");
        Page<AdminRoleBackListDao> pages = PageHelper.startPage(basePageOrder.getPageNum(),basePageOrder.getPageSize());
        List<AdminRoleBackListDao> list = acAdminRoleDaoMapper.getAdminBackList();
        logger.info("------------查询后台角色列表------------End");
        return BaseResponse.create(pages.getTotal(),BeanUtil.copy(list,AdminRoleBackListDTO.class));
    }

    @Override
    @Transactional
    public Boolean updateOrAddAdminRole(UpdateOrAddRoleDTO roleDTO) throws Exception {
        logger.info("------------修改/新增角色------------Start");
        if (Objects.isNull(roleDTO.getId())){
            AcAdminRoleDO yjzhAdminRoleDO = new AcAdminRoleDO();
            yjzhAdminRoleDO.setRoleCode(roleDTO.getRoleCode());
            yjzhAdminRoleDO.setRoleName(roleDTO.getRoleName());
            yjzhAdminRoleDO.setIsDelete(TableIsDeleteEnum.TABLE_IS_DELETE_FALSE.getCode());
            yjzhAdminRoleDO.setCreateTime(new Date());
            Integer result = acAdminRoleMapper.insertSelective(yjzhAdminRoleDO);
            if (result == 0){
                logger.info("新增角色失败");
                throw new BusinessException(ResultCodeEnum.ADD_DATA_ERROR.code(), ResultCodeEnum.ADD_DATA_ERROR.message());
            }
        }else{
            Integer result = acAdminRoleDaoMapper.updateAdminRole(BeanUtil.copy(roleDTO,AdminRoleUpdateOrAddDao.class));
            if (result == 0){
                logger.info("修改角色失败");
                throw new BusinessException(ResultCodeEnum.UPDATE_DATA_ERROR.code(), ResultCodeEnum.UPDATE_DATA_ERROR.message());
            }
        }
        logger.info("------------修改/新增角色------------End");
        return true;
    }

    @Override
    @Transactional
    public Boolean deleteAdminRole(Integer roleId) throws Exception {
        logger.info("------------删除角色------------Start");
        if (Objects.isNull(roleId)){
            logger.info("删除角色，获取ID失败");
            throw new BusinessException(ResultCodeEnum.BUSINESS_ERROR.code(), ResultCodeEnum.BUSINESS_ERROR.message());
        }
        String roleCode = this.getRoleCodeToRoleId(roleId); // 获取角色Code
        logger.info(roleCode+"--------------");
        // 1：修改菜单权限表，把角色的code去除
        acAdminModuleJurDaoMapper.updateModuleJurPermsCodeToRoleCode(roleCode);
        // 2: 修改角色权限关联表
        acAdminRoleDescriptionDaoMapper.deleteRoleDescriptionToRoleId(roleId);
        // 3: 修改角色表
        AcAdminRoleDO acAdminRoleDO = new AcAdminRoleDO();
        acAdminRoleDO.setId(roleId);
        acAdminRoleDO.setIsDelete(TableIsDeleteEnum.TABLE_IS_DELETE_TRUE.getCode());
        Integer result = acAdminRoleMapper.updateByPrimaryKeySelective(acAdminRoleDO);
        if (result == 0){
            logger.info("删除角色失败");
            throw new BusinessException(ResultCodeEnum.UPDATE_DATA_ERROR.code(), ResultCodeEnum.UPDATE_DATA_ERROR.message());
        }
        logger.info("------------删除角色------------End");
        return true;
    }

    @Override
    @Transactional
    public Boolean updateRoleMenuPermission(AdminRolePermissionDTO adminRolePermissionDTO) throws Exception {
        logger.info("------------修改角色菜单权限------------Start");
        if (Objects.isNull(adminRolePermissionDTO.getRoleId())){
            logger.info("修改角色菜单权限，获取ID失败");
            throw new BusinessException(ResultCodeEnum.BUSINESS_ERROR.code(), ResultCodeEnum.BUSINESS_ERROR.message());
        }
        String roleCode = this.getRoleCodeToRoleId(adminRolePermissionDTO.getRoleId()); // 获取角色Code
        Date date = new Date();
        // 获取旧的角色菜单权限数据
        List<Integer> oldList = acAdminModuleJurDaoMapper.getAllModuleJurIdToRoleCode(roleCode);
        // 删除取消勾选的菜单权限
        oldList.forEach(oldJurId -> {
            if (!adminRolePermissionDTO.getJurIds().contains(oldJurId)) {
                String permsCode = acAdminModuleJurDaoMapper.getModuleJurPermsCodeToId(oldJurId); // 获取权限代码
                acAdminModuleJurDaoMapper.updatePermsCodeToRoleCodeAndMJurId(roleCode,oldJurId); // 删除菜单权限关联数据
                acAdminRoleDescriptionDaoMapper.updateRoleDescriptionToRoleIdAndCode(adminRolePermissionDTO.getRoleId(),oldJurId+permsCode); // 删除角色权限关联数据
            }
        });
        // 查询所有的角色权限关联数据
        List<String> permsCodeList = acAdminRoleDescriptionDaoMapper.queryAllRoleDescriptionToRoleId(adminRolePermissionDTO.getRoleId());
        // 添加新增的菜单权限
        adminRolePermissionDTO.getJurIds().forEach(jurId ->{
            String permsCode = acAdminModuleJurDaoMapper.getModuleJurPermsCodeToId(jurId); // 获取菜单权限代码
            if (Objects.nonNull(permsCode)){
                // 检查是否已经存在数据
                 if (!permsCodeList.contains((jurId + permsCode))){
                     acAdminModuleJurDaoMapper.updateModuleJurAddRoleCode(roleCode,jurId); // 修改权限关联表，增加角色Code
                     AcAdminRoleDescriptionDO acAdminRoleDescriptionDO = new AcAdminRoleDescriptionDO();
                     acAdminRoleDescriptionDO.setCreateTime(date);
                     acAdminRoleDescriptionDO.setIsDelete(TableIsDeleteEnum.TABLE_IS_DELETE_FALSE.getCode());
                     acAdminRoleDescriptionDO.setPermsCode(jurId + permsCode); // 组合权限Code
                     acAdminRoleDescriptionDO.setRoleId(adminRolePermissionDTO.getRoleId());
                     acAdminRoleDescriptionMapper.insertSelective(acAdminRoleDescriptionDO);
                }
            }
        });

        logger.info("------------修改角色菜单权限------------End");
        return true;
    }

    @Override
    public List<Integer> getRolePermissionIdList(Integer roleId) throws Exception {
        logger.info("-------------获取角色权限ID集合----------Start");
        List<Integer> list = acAdminModuleDaoMapper.getRolePermissionIdList(roleId);
        logger.info("-------------获取角色权限ID集合----------End");
        return list;
    }

    @Override
    public Boolean queryRoleNameIsExist(String roleName) throws Exception {
        logger.info("-------------检查角色名称是否存在----------Start");
        Integer count = acAdminRoleDaoMapper.queryRoleNameIsExist(roleName);
        logger.info("-------------检查角色名称是否存在----------End");
        return Objects.equals(count,0);
    }

    @Override
    public Boolean queryRoleCodeIsExist(String roleCode) throws Exception {
        logger.info("-------------检查角色名称是否存在----------Start");
        Integer count = acAdminRoleDaoMapper.queryRoleCodeIsExist(roleCode);
        logger.info("-------------检查角色名称是否存在----------End");
        return Objects.equals(count,0);
    }

    /**
     * @Description 获取角色Code
     * @Param  roleId
     * @Return  roleCode
     * @Author yuan.shuai
     * @Date  2019/8/2
     * @Version 1.0.0
     */
    private String getRoleCodeToRoleId(Integer roleId) throws Exception{
        String roleCode = acAdminRoleDaoMapper.getAdminRoleCodeToId(roleId);
        if (Objects.isNull(roleCode)){
            logger.info("角色菜单权限，获取角色代码失败");
            throw new BusinessException(ResultCodeEnum.BUSINESS_ERROR.code(), ResultCodeEnum.BUSINESS_ERROR.message());
        }
        return roleCode;
    }
}
