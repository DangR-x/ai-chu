package com.aichu.service.api.impl;

import com.aichu.common.util.api.BaseResponse;
import com.aichu.common.util.common.BeanUtil;
import com.aichu.common.util.common.MD5Utils;
import com.aichu.common.util.common.Utils;
import com.aichu.common.util.exception.BusinessException;
import com.aichu.dao.autogeneration.mapper.AcAdminUserMapper;
import com.aichu.dao.autogeneration.mapper.AcAdminUserRoleMapper;
import com.aichu.dao.autogeneration.object.AcAdminUserDO;
import com.aichu.dao.autogeneration.object.AcAdminUserExample;
import com.aichu.dao.autogeneration.object.AcAdminUserRoleDO;
import com.aichu.dao.workstation.mapper.AcAdminRoleDaoMapper;
import com.aichu.dao.workstation.mapper.AcAdminUserDaoMapper;
import com.aichu.dao.workstation.object.AcAdminUserDao;
import com.aichu.dao.workstation.object.AdminUserBackDetailDao;
import com.aichu.dao.workstation.object.EditorAdminUserBackDao;
import com.aichu.manager.api.shiro.ShiroCustomService;
import com.aichu.manager.enums.ResultCodeEnum;
import com.aichu.manager.enums.TableIsDeleteEnum;
import com.aichu.service.api.AcAdminUserService;
import com.aichu.service.api.AdminRoleService;
import com.aichu.service.dto.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @ClassName AcAdminUserServiceImpl
 * @Author yuan.shuai
 * @Description 管理员信息Service
 * @Date 2019/11/4
 * @Version 1.0.0
 */
@Service
public class AcAdminUserServiceImpl implements AcAdminUserService {

    private Logger logger = LoggerFactory.getLogger(AcAdminUserServiceImpl.class);

    @Autowired
    private AcAdminUserDaoMapper acAdminUserDaoMapper;

    @Autowired
    private ShiroCustomService shiroUtilService;

    @Autowired
    private AcAdminUserMapper acAdminUserMapper;

    @Autowired
    private AdminRoleService adminRoleService;

    @Autowired
    private AcAdminRoleDaoMapper adminRoleDaoMapper;

    @Autowired
    private AcAdminUserRoleMapper adminUserRoleMapper;

    @Override
    public AcAdminUserDao getAdminUserToUserName(String userName) {
        logger.info("-----------通过管理员名称或者信息-------Start");
        AcAdminUserDao nlAdminUserDao = acAdminUserDaoMapper.getAdminUserToUserName(userName);
        logger.info("-----------通过管理员名称或者信息-------End");
        return nlAdminUserDao;
    }

    @Override
    public AdminUserLoginDTO adminUserLogin(BackLoginDTO backLoginDTO) throws Exception {
        logger.info("-----------管理员登录-------Start");
        String userName = backLoginDTO.getUserName();
        if (Objects.isNull(userName)){
            logger.info("登陆用户名称没有获取到，系统异常");
            throw new BusinessException(ResultCodeEnum.SYSTEM_ERROR.code(), ResultCodeEnum.SYSTEM_ERROR.message());
        }
        logger.info("登录的用户名："+ userName);
        AcAdminUserDao adminUserDao = acAdminUserDaoMapper.getAdminUserToUserName(userName);
        if (Objects.isNull(adminUserDao)){
            throw new BusinessException(ResultCodeEnum.ADMIN_NOT_EXIST.code(), ResultCodeEnum.ADMIN_NOT_EXIST.message());
        }
        logger.info("这是查询出的用户"+adminUserDao.getUserName());
        AdminUserLoginDTO response = new AdminUserLoginDTO();
        HashMap<String, Object> hashMap = adminRoleService.queryUserModuleAndRole();
        response.setUserName(adminUserDao.getUserName());
        response.setAliasName(adminUserDao.getAliasName());
        response.setType(adminUserDao.getType());
        response.setHeadImg(adminUserDao.getHeadImg());
        if (Objects.nonNull(hashMap)){
            List<String> rollNameList = (List<String>) hashMap.get("allRoles");
            Set<Integer> moduleSet = (Set<Integer>) hashMap.get("allPermissions");
            Set<String> permissionSet = (Set<String>) hashMap.get("allUrl");
            if (Objects.isNull(rollNameList) && Objects.nonNull(moduleSet)){
                logger.info("账户异常，权限不为空，角色为空");
                throw new BusinessException(ResultCodeEnum.SYSTEM_ACCOUNT_ERROR.code(),ResultCodeEnum.SYSTEM_ACCOUNT_ERROR.message());
                // TODO
            }else{
                List<Integer> moduleList = new ArrayList<>(moduleSet);
                List<String> permissonList = new ArrayList<>(permissionSet);
                response.setModuleList(moduleList);
                response.setRoleList(rollNameList);
                response.setPermissionList(permissonList);
            }
        }else{
            logger.info("账户角色和权限都为空");
            throw new BusinessException(ResultCodeEnum.JURISDICTION_ERROR.code(),ResultCodeEnum.JURISDICTION_ERROR.message());
        }
        logger.info("-----------管理员登录-------End");
        return response;
    }

    @Override
    public void updateAdminUserPwd(AdminUserUpdatePwdDTO updatePwdDTO) throws Exception {
        logger.info("-----------管理员修改密码-------Start");
        SimplePrincipalCollection simplePrincipalCollection = shiroUtilService.getRedisObjectToSessionId();
        AcAdminUserDao nlAdminUserDao = BeanUtil.copy(simplePrincipalCollection.getPrimaryPrincipal(), AcAdminUserDao.class);
        if (Objects.isNull(nlAdminUserDao)){
            logger.info("后台管理员修改密码失败，管理员信息不存在或者Session过期，系统异常");
            throw new BusinessException(ResultCodeEnum.SYSTEM_SESSION_ERROR.code(),ResultCodeEnum.SYSTEM_SESSION_ERROR.message());
        }
        if (!Objects.equals(nlAdminUserDao.getPassword(), MD5Utils.getStringMD5(updatePwdDTO.getOldPwd()))){
            logger.info("旧密码输入错误，请重新输入");
            throw new BusinessException(ResultCodeEnum.OLD_PASSWORD_ERROR.code(),ResultCodeEnum.OLD_PASSWORD_ERROR.message());
        }
        AcAdminUserDO newPwdDo = new AcAdminUserDO();
        newPwdDo.setId(nlAdminUserDao.getId());
        newPwdDo.setPassword(MD5Utils.getStringMD5(updatePwdDTO.getNewPwd()));
        Integer result = acAdminUserMapper.updateByPrimaryKeySelective(newPwdDo);
        if (result == 0){
            logger.info("修改密码失败");
            throw new BusinessException(ResultCodeEnum.UPDATE_PASSWORD_ERROR.code(),ResultCodeEnum.UPDATE_PASSWORD_ERROR.message());
        }
        logger.info("-----------管理员修改密码-------End");
        // 修改成功后，重新登录
        SecurityUtils.getSubject().logout();
    }

    @Override
    public Boolean updateAdminUserAliasName(String aliasName) throws Exception {
        logger.info("-----------管理员修改昵称-------Start");
        // 从Redis中获取登录Session信息
        SimplePrincipalCollection simplePrincipalCollection = shiroUtilService.getRedisObjectToSessionId();
        AcAdminUserDao acAdminUserDao = BeanUtil.copy(simplePrincipalCollection.getPrimaryPrincipal(), AcAdminUserDao.class);
        AcAdminUserExample adminUserExample = new AcAdminUserExample();
        adminUserExample.createCriteria()
                .andAliasNameEqualTo(aliasName)
                .andIsDeleteEqualTo(TableIsDeleteEnum.TABLE_IS_DELETE_FALSE.getCode());
        List<AcAdminUserDO> acAdminUserDOS = acAdminUserMapper.selectByExample(adminUserExample);
        if (Objects.isNull(acAdminUserDao)){
            logger.info("后台管理员修改昵称失败，管理员信息不存在或者Session过期，系统异常");
            throw new BusinessException(ResultCodeEnum.SYSTEM_SESSION_ERROR.code(),ResultCodeEnum.SYSTEM_SESSION_ERROR.message());
        }
        // 校验昵称是否已经存在
        if (Utils.notEmpty(acAdminUserDOS)){
            logger.info("昵称已经存在，请重新输入昵称");
            throw new BusinessException(ResultCodeEnum.ALIAS_NAME_REPETITION.code(),ResultCodeEnum.ALIAS_NAME_REPETITION.message());
        }
        AcAdminUserDO newAdminDo = new AcAdminUserDO();
        newAdminDo.setId(acAdminUserDao.getId());
        newAdminDo.setAliasName(aliasName);
        Integer result = acAdminUserMapper.updateByPrimaryKeySelective(newAdminDo);
        if (result == 0){
            logger.info("修改昵称失败");
            throw new BusinessException(ResultCodeEnum.UPDATE_DATA_ERROR.code(),ResultCodeEnum.UPDATE_DATA_ERROR.message());
        }
        // 修改Session用户信息
        acAdminUserDao.setAliasName(aliasName);
        SecurityUtils.getSubject().getSession().setAttribute("AdminUser",acAdminUserDao);
        logger.info("-----------管理员修改昵称-------End");
        return true;
    }

    @Override
    public BaseResponse<List<AdminUserDTO>> getAdminUserList(AdminUserQueryDTO queryDTO) throws Exception {
        logger.info("-----------管理员列表查询-------Start");
        Page<AcAdminUserDao> pages = PageHelper.startPage(queryDTO.getPageNum(),queryDTO.getPageSize());
        List<AcAdminUserDao> list = acAdminUserDaoMapper.getAdminUserList(queryDTO.getName());
        logger.info("-----------管理员列表查询-------End");
        return BaseResponse.create(pages.getTotal(),BeanUtil.copy(list,AdminUserDTO.class));
    }

    @Override
    @Transactional
    public Boolean addOrUpdateAdminUser(AdminUserAddOrUpdateDTO addOrUpdateDTO) throws Exception {
        logger.info("-----------管理员新增/修改-------Start");
        if (Objects.isNull(addOrUpdateDTO)){
            logger.info("后台管理员修改/新增信息为空，系统异常");
            throw new BusinessException(ResultCodeEnum.BUSINESS_ERROR.code(),ResultCodeEnum.BUSINESS_ERROR.message());
        }
        AcAdminUserExample adminUserExample = new AcAdminUserExample();
        if (Objects.isNull(addOrUpdateDTO.getId())){
            adminUserExample.createCriteria()
                    .andIsDeleteEqualTo(TableIsDeleteEnum.TABLE_IS_DELETE_FALSE.getCode())
                    .andUserNameEqualTo(addOrUpdateDTO.getUserName());
            List<AcAdminUserDO> lists = acAdminUserMapper.selectByExample(adminUserExample);
            if (Utils.notEmpty(lists)){
                throw new BusinessException(ResultCodeEnum.ADMIN_USER_IS_EXIST.code(), ResultCodeEnum.ADMIN_USER_IS_EXIST.message());
            }
            Date date = new Date();
            logger.info("-----------后台管理员新增-------Start");
            AcAdminUserDO adminUserDO = new AcAdminUserDO();
            adminUserDO.setUserName(addOrUpdateDTO.getUserName());
            adminUserDO.setAliasName(addOrUpdateDTO.getAliasName());
            adminUserDO.setCreateTime(date);
            adminUserDO.setType(addOrUpdateDTO.getType());
            adminUserDO.setIsDelete(TableIsDeleteEnum.TABLE_IS_DELETE_FALSE.getCode());
            adminUserDO.setPassword(MD5Utils.getStringMD5(addOrUpdateDTO.getPassword()));
            adminUserDO.setHeadImg(addOrUpdateDTO.getHeadImg());
            Integer userResult = acAdminUserMapper.insertSelective(adminUserDO);
            if (userResult == 0){
                logger.info("新增管理员失败");
                throw new BusinessException(ResultCodeEnum.ADD_DATA_ERROR.code(), ResultCodeEnum.ADD_DATA_ERROR.message());
            }
            AcAdminUserDao AcAdminUserDB = acAdminUserDaoMapper.getAdminUserToUserName(addOrUpdateDTO.getUserName());
            // 新增管理员角色中间表
            this.addAdminUserRoleData(addOrUpdateDTO.getRoleIdList(),BeanUtil.copy(AcAdminUserDB,AcAdminUserDO.class));
            logger.info("-----------后台管理员新增-------End");
        }else{
            logger.info("-----------后台管理员修改-------Start");
            adminUserExample.createCriteria()
                    .andIsDeleteEqualTo(TableIsDeleteEnum.TABLE_IS_DELETE_FALSE.getCode())
                    .andUserNameEqualTo(addOrUpdateDTO.getUserName()).andIdNotEqualTo(addOrUpdateDTO.getId());
            List<AcAdminUserDO> lists = acAdminUserMapper.selectByExample(adminUserExample);
            if (Utils.notEmpty(lists)){
                throw new BusinessException(ResultCodeEnum.ADMIN_USER_IS_EXIST.code(), ResultCodeEnum.ADMIN_USER_IS_EXIST.message());
            }
            AcAdminUserDO adminUserDO = new AcAdminUserDO();
            if (Objects.nonNull(addOrUpdateDTO.getPassword())){
                adminUserDO.setPassword(MD5Utils.getStringMD5(addOrUpdateDTO.getPassword()));
            }
            AcAdminUserDO userDO = acAdminUserMapper.selectByPrimaryKey(addOrUpdateDTO.getId());
            adminUserDO.setAliasName(addOrUpdateDTO.getAliasName());
            adminUserDO.setUserName(addOrUpdateDTO.getUserName());
            adminUserDO.setId(addOrUpdateDTO.getId());
            adminUserDO.setType(addOrUpdateDTO.getType());
            adminUserDO.setHeadImg(addOrUpdateDTO.getHeadImg());
            Integer userResult = acAdminUserMapper.updateByPrimaryKeySelective(adminUserDO);
            if (userResult == 0){
                logger.info("修改管理员失败");
                throw new BusinessException(ResultCodeEnum.UPDATE_DATA_ERROR.code(), ResultCodeEnum.UPDATE_DATA_ERROR.message());
            }
            if (Objects.nonNull(addOrUpdateDTO.getRoleIdList())){
                // 删除旧用户角色中间表(实际是执行修改)
                this.deleteAdminUserRoleData(addOrUpdateDTO.getId(),null);
                // 新增管理员角色中间表
                this.addAdminUserRoleData(addOrUpdateDTO.getRoleIdList(),adminUserDO);
            }
            logger.info("-----------后台管理员修改-------Start");
        }
        logger.info("-----------管理员新增/修改-------End");
        return true;
    }

    @Override
    public Boolean deleteAdminUser(Integer id) throws Exception {
        logger.info("-----------管理员删除-------Start");
        if (Objects.isNull(id)){
            logger.info("管理员ID为空");
            throw new BusinessException(ResultCodeEnum.BUSINESS_ERROR.code(), ResultCodeEnum.BUSINESS_ERROR.message());
        }
        AcAdminUserDO adminUserDO = new AcAdminUserDO();
        adminUserDO.setId(id);
        adminUserDO.setIsDelete(TableIsDeleteEnum.TABLE_IS_DELETE_TRUE.getCode());
        Integer deleteResult = acAdminUserMapper.updateByPrimaryKeySelective(adminUserDO);
        if (deleteResult == 0){
            logger.info("删除管理员失败");
            throw new BusinessException(ResultCodeEnum.UPDATE_DATA_ERROR.code(), ResultCodeEnum.UPDATE_DATA_ERROR.message());
        }
        // 修改用户角色中间表状态
        this.deleteAdminUserRoleData(id,TableIsDeleteEnum.TABLE_IS_DELETE_TRUE.getCode());
        logger.info("-----------管理员删除-------End");
        return true;
    }

    @Override
    public ViewAdminUserBackDetailDTO getViewAdminUserBackDetail(Integer id) throws Exception {
        logger.info("-----------后台查询管理员详情（查看详情）-------Start");
        AdminUserBackDetailDao adminUserBackDetailDao = acAdminUserDaoMapper.getAdminUserBackDetail(id);
        logger.info("-----------后台查询管理员详情（查看详情）-------End");
        return BeanUtil.copy(adminUserBackDetailDao,ViewAdminUserBackDetailDTO.class);
    }

    @Override
    public EditorAdminUserBackDTO getEitorAdminUserBackDetail(Integer id) throws Exception {
        logger.info("-----------后台查询管理员详情（编辑）-------Start");
        EditorAdminUserBackDao editorAdminUserBackDao = acAdminUserDaoMapper.getEditorAdminUserBackDetail(id);
        logger.info("-----------后台查询管理员详情（编辑）-------End");
        //getEditorAdminUserBackDetail
        return BeanUtil.copy(editorAdminUserBackDao,EditorAdminUserBackDTO.class);
    }

    @Override
    public Boolean updateAdminUserHeadImg(AdminUserHeadImgUpdateDTO updateDTO) throws Exception {
        logger.info("-----------后台管理员头像修改-------Start");
        if (Objects.isNull(updateDTO)){
            throw new BusinessException(ResultCodeEnum.SYSTEM_ERROR.code(), ResultCodeEnum.SYSTEM_ERROR.message());
        }
        AcAdminUserDO adminUserDO = acAdminUserMapper.selectByPrimaryKey(updateDTO.getId());
        if (Objects.isNull(adminUserDO) || Objects.isNull(adminUserDO.getId())){
            throw new BusinessException(ResultCodeEnum.DATA_ERROR.code(), ResultCodeEnum.DATA_ERROR.message());
        }
        adminUserDO.setHeadImg(updateDTO.getHeadImg());
        Integer result = acAdminUserMapper.updateByPrimaryKeySelective(adminUserDO);
        if (result == 0){
            throw new BusinessException(ResultCodeEnum.UPDATE_DATA_ERROR.code(), ResultCodeEnum.UPDATE_DATA_ERROR.message());
        }
        logger.info("-----------后台管理员头像修改-------End");
        return Boolean.TRUE;
    }

    /**
     * @Description 删除管理员角色中间表
     * @Param userId,status
     * @Author yuan.shuai
     * @Date  2019/7/31
     * @Version 1.0.0
     */
    private void deleteAdminUserRoleData(Integer userId,Integer status){
        // 获取用户角色中间表总数
        Integer count = adminRoleDaoMapper.queryAdminUserRoleCountToUserId(userId);
        if (!Objects.equals(count,0)){
            if (Objects.isNull(status)){
                Integer result = adminRoleDaoMapper.deleteAdminUserRoleData(userId);
                if (!Objects.equals(count,result)){
                    logger.info("删除用户角色中间表失败");
                    throw new BusinessException(ResultCodeEnum.DELETE_DATA_ERROR.code(), ResultCodeEnum.DELETE_DATA_ERROR.message());
                }
            }else{
                // 修改用户角色中间表(实际是执行修改)
                Integer result = adminRoleDaoMapper.stopOrStartUserRoleToUserId(userId,status);
                if (!Objects.equals(count,result)){
                    logger.info("修改用户角色中间表失败");
                    throw new BusinessException(ResultCodeEnum.UPDATE_DATA_ERROR.code(), ResultCodeEnum.UPDATE_DATA_ERROR.message());
                }
            }
        }
    }

    /**
     * @Description 新增后台管理员角色中间表数据
     * @Param roleIdList，YjzhAdminUserDao
     * @Author yuan.shuai
     * @Date  2019/7/31
     * @Version 1.0.0
     */
    private void addAdminUserRoleData(List<Integer> roleIdList,AcAdminUserDO adminUserDao){
        if (Objects.nonNull(roleIdList)){
            roleIdList.forEach(roleId -> {
                AcAdminUserRoleDO adminUserRoleDO = new AcAdminUserRoleDO();
                adminUserRoleDO.setRoleId(roleId);
                adminUserRoleDO.setUserId(adminUserDao.getId());
                adminUserRoleDO.setCreateTime(new Date());
                adminUserRoleDO.setIsDelete(TableIsDeleteEnum.TABLE_IS_DELETE_FALSE.getCode());
                Integer userRoleResult = adminUserRoleMapper.insertSelective(adminUserRoleDO);
                if (userRoleResult == 0){
                    logger.info("新增管理员角色中间表失败");
                    throw new BusinessException(ResultCodeEnum.ADD_DATA_ERROR.code(), ResultCodeEnum.ADD_DATA_ERROR.message());
                }
            });
        }
    }
}
