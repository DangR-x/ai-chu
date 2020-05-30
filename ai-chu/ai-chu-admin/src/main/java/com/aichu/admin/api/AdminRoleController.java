package com.aichu.admin.api;

import com.aichu.admin.config.OperationLog;
import com.aichu.admin.vo.request.AdminRolePermissionRequest;
import com.aichu.admin.vo.request.AdminRoleUpdateOrAddRequest;
import com.aichu.admin.vo.response.AdminRoleListResponse;
import com.aichu.admin.vo.response.AdminRoleSelectResponse;
import com.aichu.common.util.api.ApiResult;
import com.aichu.common.util.api.BasePageOrder;


import com.aichu.common.util.api.BaseResponse;
import com.aichu.common.util.api.Request;
import com.aichu.common.util.common.BeanUtil;
import com.aichu.service.api.AdminRoleService;
import com.aichu.service.dto.AdminRoleBackListDTO;
import com.aichu.service.dto.AdminRolePermissionDTO;
import com.aichu.service.dto.UpdateOrAddRoleDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @ClassName AdminRoleController
 * @Author yuan.shuai
 * @Description 后台角色管理
 * @Date 2019/7/31
 * @Version 1.0.0
 */
@RestController
@RequestMapping("/adminRole/manager/")
@Api(value = "后台角色管理",tags = "后台角色管理接口")
public class AdminRoleController {
    private Logger logger = LoggerFactory.getLogger(AdminRoleController.class);

    @Autowired
    private AdminRoleService adminRoleService;

    /**
     * @Description 查询后台所有角色(下拉框)
     * @Return ApiResult<List<AdminRoleSelectResponse>>
     * @Author yuan.shuai
     * @Date  2019/7/31
     * @Version 1.0.0
     */
    @RequestMapping(value = "queryRoleSelect", method = RequestMethod.GET )
    @ApiOperation(value = "查询后台所有角色(下拉框)",notes = "查询后台所有角色(下拉框)",httpMethod = "GET")
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<List<AdminRoleSelectResponse>> getAdminRoleSelectList() throws Exception{
        return ApiResult.success(BeanUtil.copy(adminRoleService.getAdminRoleBackSelectList(),AdminRoleSelectResponse.class));
    }

    /**
     * @Description 获取角色列表（模糊查询共用）
     * @Param BasePageOrder
     * @Return ApiResult<BaseResponse<List<AdminRoleListResponse>>>
     * @Author yuan.shuai
     * @Date  2019/8/1
     * @Version 1.0.0
     */
    @RequestMapping(value = "queryRoleList", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "查询角色列表",notes = "查询角色列表",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<BaseResponse<List<AdminRoleListResponse>>> getAdminRoleList(@RequestBody(required = true) @Valid Request<BasePageOrder> request) throws Exception{
        BaseResponse<List<AdminRoleBackListDTO>> serviceResonse = adminRoleService.getAdminRoleBackList(request.getData());
        BaseResponse<List<AdminRoleListResponse>> response = new BaseResponse<>(serviceResonse.getCount(),BeanUtil.copy(serviceResonse.getData(),AdminRoleListResponse.class));
        return ApiResult.success(response);
    }

    /**
     * @Description 修改或者新增角色
     * @Param AdminRoleUpdateOrAddRequst
     * @Return ApiResult<Boolean>
     * @Author yuan.shuai
     * @Date  2019/8/1
     * @Version 1.0.0
     */
    @OperationLog("新增/修改角色")
    @RequestMapping(value = "updateOrAddRole", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "修改或者新增角色",notes = "修改或者新增角色",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<Boolean> updateOrAddAdminRole(@RequestBody(required = true) @Valid Request<AdminRoleUpdateOrAddRequest> request) throws Exception{
        return ApiResult.success(adminRoleService.updateOrAddAdminRole(BeanUtil.copy(request.getData(), UpdateOrAddRoleDTO.class)));
    }

    /**
     * @Descrition 修改角色权限
     * @Param AdminRolePermissionRequest
     * @Return ApiResult<Boolean>
     * @Author yuan.shuai
     * @Date  2019/8/1
     * @Version 1.0.0
     */
    @OperationLog("修改角色权限")
    @RequestMapping(value = "updateRolePermission", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "修改角色权限",notes = "修改角色权限",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<Boolean> updateAdminRolePermission(@RequestBody(required = true) @Valid Request<AdminRolePermissionRequest> request) throws Exception{
        logger.info("修改角色权限");
        return ApiResult.success(adminRoleService.updateRoleMenuPermission(BeanUtil.copy(request.getData(), AdminRolePermissionDTO.class)));
    }

    /**
     * @Description 删除角色
     * @Param roleId
     * @Version 1.0.0
     */
    @OperationLog("删除角色")
    @RequestMapping(value = "deleteRole", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "删除角色",notes = "删除角色",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<Boolean> deleteAdminRole(@RequestBody(required = true) @Valid Request<Integer> request) throws Exception{
        return ApiResult.success(adminRoleService.deleteAdminRole(request.getData()));
    }

    /**
     * @Description 获取角色所有菜单的ID
     * @Param RoleId
     * @Return ApiResult<List<Integer>>
     * @Author yuan.shuai
     * @Date  2019/8/1
     * @Version 1.0.0
     */
    @RequestMapping(value = "rolePermissionIdList", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "获取角色所有权限菜单的ID",notes = "获取角色所有权限菜单的ID",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<List<Integer>> getRolePermissionIdList(@RequestBody(required = true) @Valid Request<Integer> request) throws Exception{

        return ApiResult.success(adminRoleService.getRolePermissionIdList(request.getData()));
    }

    /**
     * @Description 检查角色名称是否存在
     * @Param  roleName
     * @Return Boolean
     * @Author yuan.shuai
     * @Date  2019/8/2
     * @Version 1.0.0
     */
    @RequestMapping(value = "queryRoleNameIsExist", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "检查角色名称是否存在",notes = "检查角色名称是否存在",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<Boolean> queryRoleNameIsExist(@RequestBody(required = true) @Valid Request<String> request) throws Exception{
        return ApiResult.success(adminRoleService.queryRoleNameIsExist(request.getData()));
    }

    /**
     * @Description 检查角色Code是否存在
     * @Param  roleCode
     * @Return Boolean
     * @Author yuan.shuai
     * @Date  2019/8/2
     * @Version 1.0.0
     */
    @RequestMapping(value = "queryRoleCodeIsExist", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "检查角色Code是否存在",notes = "检查角色Code是否存在",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<Boolean> queryRoleCodeIsExist(@RequestBody(required = true) @Valid Request<String> request) throws Exception{
        return ApiResult.success(adminRoleService.queryRoleCodeIsExist(request.getData()));
    }

}
