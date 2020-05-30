package com.aichu.service.api;

import com.aichu.common.util.api.BasePageOrder;
import com.aichu.common.util.api.BaseResponse;
import com.aichu.dao.workstation.object.AcAdminRoleDao;
import com.aichu.service.dto.AdminRoleBackListDTO;
import com.aichu.service.dto.AdminRoleBackSelectDTO;
import com.aichu.service.dto.AdminRolePermissionDTO;
import com.aichu.service.dto.UpdateOrAddRoleDTO;

import java.util.HashMap;
import java.util.List;

/**
 * @ClassName AdminRoleService
 * @Author yuan.shuai
 * @Description
 * @Date 2019/7/23
 * @Version 1.0.0
 */
public interface AdminRoleService {
   /**
    * @Description 通过session查询当前用户的菜单和角色
    * @Return HashMap<String, Object>
    * @Author yuan.shuai
    * @Date  2019/7/23
    */
   HashMap<String, Object> queryUserModuleAndRole() throws Exception;
   /**
    * @Description 查询用户的所有角色
    * @Param userId
    * @Return java.util.List<AcAdminRoleDao>
    * @Author yuan.shuai
    * @Date  2019/7/23
    */
   List<AcAdminRoleDao> queryAllUserRole(Integer userId) throws Exception;

   /**
    * @Description 查询后台所有角色（用于下拉框）
    * @Return java.util.List<AdminRoleBackSelectDTO>
    * @Author yuan.shuai
    * @Date  2019/7/31
    * @Version 1.0.0
    */
   List<AdminRoleBackSelectDTO> getAdminRoleBackSelectList() throws Exception;

   /**
    * @Description 查询后台角色列表
    * @Param BasePageOrder
    * @Return java.util.List<AdminRoleBackListDTO>
    * @Author yuan.shuai
    * @Date  2019/8/1
    * @Version 1.0.0
    */
   BaseResponse<List<AdminRoleBackListDTO>> getAdminRoleBackList(BasePageOrder basePageOrder) throws Exception;

   /**
    * @Description 修改或者新增角色
    * @Param UpdateOrAddRoleDTO
    * @Return Boolean
    * @Author yuan.shuai
    * @Date  2019/8/1
    * @Version 1.0.0
    */
   Boolean updateOrAddAdminRole(UpdateOrAddRoleDTO roleDTO) throws Exception;

   /**
    * @Description 删除角色
    * @Param roleId
    * @Return Boolean
    * @Author yuan.shuai
    * @Date  2019/8/1
    * @Version 1.0.0
    */
   Boolean deleteAdminRole(Integer roleId) throws Exception;

   /**
    * @Description 修改角色菜单权限
    * @Param AdminRolePermissionDTO
    * @Return Boolean
    * @Author yuan.shuai
    * @Date  2019/8/1
    * @Version 1.0.0
    */
   Boolean updateRoleMenuPermission(AdminRolePermissionDTO adminRolePermissionDTO) throws Exception;

   /**
    * @Description 获取角色权限ID集合
    * @Param roleId
    * @Return java.util.List<Integer>
    * @Author yuan.shuai
    * @Date  2019/8/1
    * @Version 1.0.0
    */
   List<Integer> getRolePermissionIdList(Integer roleId) throws Exception;

   /**
    * @Description 检查角色名称是否存在
    * @Param roleName
    * @Return Boolean
    * @Author yuan.shuai
    * @Date  2019/8/2
    * @Version 1.0.0
    */
   Boolean queryRoleNameIsExist(String roleName) throws Exception;

   /**
    * @Description 检查角色Code是否存在
    * @Param roleName
    * @Return Boolean
    * @Author yuan.shuai
    * @Date  2019/8/2
    * @Version 1.0.0
    */
   Boolean queryRoleCodeIsExist(String roleName) throws Exception;

}
