package com.aichu.admin.shiros;

import com.aichu.common.util.common.MD5Utils;
import com.aichu.common.util.exception.BusinessException;
import com.aichu.dao.workstation.object.AcAdminUserDao;
import com.aichu.manager.enums.ResultCodeEnum;
import com.aichu.service.api.ShiroUtilService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

/**
 * @ClassName MyShiroRealm
 * @Author yuan.shuai
 * @Description 实现AuthorizingRealm接口用户认证
 * @Date 2019/7/17
 * @Version 1.0.0
 */
public class MyShiroRealm extends AuthorizingRealm {

    private Logger logger = LoggerFactory.getLogger(MyShiroRealm.class);
    
    @Autowired
    private ShiroUtilService shiroUtilService;

    /**
     * @Author yuan.shuai
     * @Description 角色权限和对应权限添加
     * @param principalCollection
     * @return AuthorizationInfo
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("==================角色权限添加===================");
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        AcAdminUserDao adminUser = (AcAdminUserDao) principalCollection.getPrimaryPrincipal();
        HashMap<String,Set<String>> hashMap = new HashMap<>();
        try {
            shiroUtilService.getAllPermissionNameAndRoleName(adminUser.getId());
        }catch (Exception e){
            e.printStackTrace();
        }
        if (Objects.nonNull(hashMap)){
            //所有角色名
            Set<String> allRoles = hashMap.get("allRoles");
            //所有的权限菜单
            Set<String> allPermissions = hashMap.get("allPermissions");
            simpleAuthorizationInfo.addRoles(allRoles);
            simpleAuthorizationInfo.addStringPermissions(allPermissions);
        }
        return simpleAuthorizationInfo;
    }

    /**
     * @Description 用户认证
     * @Param AuthenticationToken
     * @Return AuthenticationInfo
     * @Author yuan.shuai
     * @Date  2019/7/17
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException{
        logger.info("=======================执行用户认证========================");
        // 登录的认证需要先行执行，因为需要判断登录的用户信息是否合法
        logger.info("toke: "+token.toString());
        String username = (String) token.getPrincipal(); //获取用户名
        AcAdminUserDao adminUser = null;
        try {
            adminUser = shiroUtilService.getAdminUserToUserName(username);
        } catch (Exception e) {
            String errorMessage = e.getCause().getMessage();
            throw new BusinessException(ResultCodeEnum.getByMessage(errorMessage).code(),errorMessage);
        }
        if (adminUser == null){
            // 报错信息：账号不存在,请重新输入
            logger.info(ResultCodeEnum.ADMIN_NOT_EXIST.message());
            throw new BusinessException(ResultCodeEnum.ADMIN_NOT_EXIST.code(),ResultCodeEnum.ADMIN_NOT_EXIST.message());
        } else if (adminUser.getIsDelete() == 1){
            // 用户被删除，报错信息：账号不存在,请重新输入
            logger.info(ResultCodeEnum.ADMIN_NOT_EXIST.message());
            throw new BusinessException(ResultCodeEnum.ADMIN_NOT_EXIST.code(),ResultCodeEnum.ADMIN_NOT_EXIST.message());
        } else {
            //密码处理
            String password = new String((char[]) token.getCredentials());
            if (Objects.equals(MD5Utils.getStringMD5(password),adminUser.getPassword())){
                AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(adminUser,adminUser.getPassword(),getName());
//                SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
//                        adminUser, // 用户名
//                        adminUser.getPassword(), // 密码
//                        ByteSource.Util.bytes("wenzu"), // 盐
//                        getName() // realm name
////                );
                return authenticationInfo;
            }else{
                // 报错信息：账号或密码错误,请重新输入
                logger.info(ResultCodeEnum.USERNAME_OR_PASSWORD_FAILED.message());
                throw new BusinessException(ResultCodeEnum.USERNAME_OR_PASSWORD_FAILED.code(),ResultCodeEnum.USERNAME_OR_PASSWORD_FAILED.message());
            }
        }
    }

    /**
     * 清楚缓存使权限立即生效
     */
    public void clearAuth() {
        this.clearCachedAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
    }
}
