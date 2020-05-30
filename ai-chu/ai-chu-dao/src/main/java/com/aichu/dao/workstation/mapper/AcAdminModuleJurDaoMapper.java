package com.aichu.dao.workstation.mapper;

import com.aichu.dao.workstation.object.AcAdminModuleJurDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName AcAdminModuleJurDaoMapper
 * @Author yuan.shuai
 * @Description 后台菜单角色权限表Mapper
 * @Date 2019/7/20
 * @Version 1.0.0
 */
public interface AcAdminModuleJurDaoMapper {
    /**
     * @Description 通过菜单角色权限表ID查询 详情
     * @Param RoleID
     * @Return List<AcAdminModuleJurDao>
     * @Author yuan.shuai
     * @Date  2019/7/20
     */
    AcAdminModuleJurDao getAdminModuleJurToMouduleJurId(@Param("mouduleJurId") Integer mouduleJurId);

    /**
     * @Description 查询所有的角色权限菜单
     * @Return List<AcAdminModuleJurDao>
     * @Author yuan.shuai
     * @Date  2019/9/6
     * @Version 1.0.0
     */
    List<AcAdminModuleJurDao> getAllAdminModuleJur();

    /**
     * @Description 修改权限关联表，增加角色权限
     * @Param roleCode，moduleJurId
     * @Return
     * @Author yuan.shuai
     * @Date  2019/8/2
     * @Version 1.0.0
     */
    Integer updateModuleJurAddRoleCode(@Param("roleCode") String roleCode, @Param("moduleJurId") Integer moduleJurId);

    /**
     * @Description 获取权限关联表权限代码
     * @Param moduleJurId
     * @Return  String
     * @Author yuan.shuai
     * @Date  2019/8/2
     * @Version 1.0.0
     */
    String getModuleJurPermsCodeToId(@Param("moduleJurId") Integer moduleJurId);

    /**
     * @Description 取消角色的权限
     * @Param roleCode
     * @Return
     * @Author yuan.shuai
     * @Date  2019/8/2
     * @Version 1.0.0
     */
    Integer updateModuleJurPermsCodeToRoleCode(@Param("roleCode") String roleCode);

    /**
     * @Description 通过ModuleJurId取消角色的权限
     * @Param roleCode，moduleJurId
     * @Return
     * @Author yuan.shuai
     * @Date  2019/8/2
     * @Version 1.0.0
     */
    Integer updatePermsCodeToRoleCodeAndMJurId(@Param("roleCode") String roleCode, @Param("moduleJurId") Integer moduleJurId);

    /**
     * @Description 通过角色Code获取所有的角色菜单权限Id
     * @Param roleCode
     * @Return java.util.List<Integer>
     * @Author yuan.shuai
     * @Date  2019/8/2
     * @Version 1.0.0
     */
    List<Integer> getAllModuleJurIdToRoleCode(@Param("roleCode") String roleCode);
}