package com.aichu.admin.api;

import com.aichu.admin.vo.request.AcAdminActionLogQueryRequest;
import com.aichu.admin.vo.response.AcAdminActionLogListResponse;
import com.aichu.common.util.api.ApiResult;
import com.aichu.common.util.api.BaseResponse;
import com.aichu.common.util.api.Request;
import com.aichu.common.util.common.BeanUtil;
import com.aichu.service.api.AcAdminActionLogService;
import com.aichu.service.dto.AcAdminActionLogListDTO;
import com.aichu.service.dto.AcAdminActionLogQueryDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @ClassName AdminActionLogController
 * @Author yuan.shuai
 * @Description 操作日志管理
 * @Date 2019/11/12
 * @Version 1.1.0
 */
@RestController
@RequestMapping("/actionlog/manager/")
@Api(value = "后台操作日志管理",tags = "后台操作日志管理接口")
public class AdminActionLogController {

    @Autowired
    private AcAdminActionLogService wzAdminActionLogService;

    /**
     * @Description 后台操作日志列表查询
     * @Param WzAdminActionLogQueryRequest
     * @Return ApiResult<BaseResponse<List<WzAdminActionLogListResponse>>>
     * @Author yuan.shuai
     * @Date  2019/11/12
     * @Version 1.1.0
     */
    @RequestMapping(value = "queryActionLogList", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "后台操作日志列表查询",notes = "后台操作日志列表查询",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<BaseResponse<List<AcAdminActionLogListResponse>>> queryActionLogList(@RequestBody(required = true) @Valid Request<AcAdminActionLogQueryRequest> request) throws Exception{
        BaseResponse<List<AcAdminActionLogListDTO>> serviceResponse = wzAdminActionLogService.getAdminActionLogList(BeanUtil.copy(request.getData(), AcAdminActionLogQueryDTO.class));
        BaseResponse<List<AcAdminActionLogListResponse>> response = new BaseResponse<>(serviceResponse.getCount(),BeanUtil.copy(serviceResponse.getData(), AcAdminActionLogListResponse.class));
        return ApiResult.success(response);
    }
}
