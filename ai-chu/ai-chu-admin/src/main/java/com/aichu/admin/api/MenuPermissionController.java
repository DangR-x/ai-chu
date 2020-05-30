package com.aichu.admin.api;

import com.aichu.admin.vo.response.MenuListResponse;
import com.aichu.common.util.api.ApiResult;
import com.aichu.common.util.common.BeanUtil;
import com.aichu.service.api.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName MenuPermissionController
 * @Author yuan.shuai
 * @Description
 * @Date 2019/8/1
 * @Version 1.0.0
 */
@RestController
@RequestMapping("/menu/manager/")
@Api(value = "后台菜单管理",tags = "后台菜单管理接口")
public class MenuPermissionController {
    private Logger logger = LoggerFactory.getLogger(MenuPermissionController.class);

    @Autowired
    private MenuService menuService;

    /**
     * @Description 级联菜单查询
     * @Return ApiResult<List<MenuListResponse>>
     * @Author yuan.shuai
     * @Date  2019/8/16
     * @Version 1.0.0
     */
    @RequestMapping(value = "menuCascade", method = RequestMethod.GET)
    @ApiOperation(value = "查询后台级联菜单",notes = "查询后台级联菜单",httpMethod = "GET")
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<List<MenuListResponse>> getMenuCascadeList() throws Exception{
        return ApiResult.success(BeanUtil.copy(menuService.getMenuCascadeList(),MenuListResponse.class));
    }

}
