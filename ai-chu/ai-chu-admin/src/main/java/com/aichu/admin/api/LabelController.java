package com.aichu.admin.api;

import com.aichu.admin.config.OperationLog;
import com.aichu.admin.vo.request.LabelDetailRequest;
import com.aichu.admin.vo.request.LabelQueryRequest;
import com.aichu.admin.vo.response.LabelResponse;
import com.aichu.admin.vo.response.LabelSelectListResponse;
import com.aichu.common.util.api.ApiResult;
import com.aichu.common.util.api.BaseResponse;
import com.aichu.common.util.api.Request;
import com.aichu.common.util.common.BeanUtil;
import com.aichu.service.api.AcSysLabelService;
import com.aichu.service.dto.AcLabelQeuryDTO;
import com.aichu.service.dto.AcSysLabelDTO;
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
 * @ClassName LabelController
 * @Author yuan.shuai
 * @Description 系统标签库Controller
 * @Date 2019/8/16
 * @Version 1.0.0
 */
@RestController
@RequestMapping("/label/manager/")
@Api(value = "后台系统标签库管理",tags = "后台系统标签库管理接口")
public class LabelController {
    private Logger logger = LoggerFactory.getLogger(LabelController.class);

    @Autowired
    private AcSysLabelService acSysLabelService;

    /**
     * @Description 查询系统标签列表
     * @Param LabelQueryRequest
     * @Return ApiResult<BaseResponse<List<LabelResponse>>>
     * @Author yuan.shuai
     * @Date  2019/8/3
     * @Version 1.0.0
     */
    @RequestMapping(value = "queryLabelList", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "后台系统标签列表",notes = "后台系统标签列表",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<BaseResponse<List<LabelResponse>>> getLabelList(@RequestBody(required = true) @Valid Request<LabelQueryRequest> request) throws Exception{
        BaseResponse<List<AcSysLabelDTO>> serviceResponse = acSysLabelService.getLableBackList(BeanUtil.copy(request.getData(), AcLabelQeuryDTO.class));
        BaseResponse<List<LabelResponse>> response = new BaseResponse<>(serviceResponse.getCount(), BeanUtil.copy(serviceResponse.getData(),LabelResponse.class));
        return ApiResult.success(response);
    }

    /**
     * @Description 后台后台标签下拉框列表
     * @Param id
     * @Return ApiResult<CongratulationNewsResponse>
     * @Author yuan.shuai
     * @Date  2019/8/16
     * @Version 1.0.0
     */
    @RequestMapping(value = "getLabelSelectList", method = RequestMethod.GET)
    @ApiOperation(value = "后台标签下拉框",notes = "后台标签下拉框",httpMethod = "GET")
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<List<LabelSelectListResponse>> getLabelSelectList() throws Exception{
        return ApiResult.success(BeanUtil.copy(acSysLabelService.getLabelSelectList(), LabelSelectListResponse.class));
    }

    /**
     * @Description 后台活动标签删除
     * @Param id
     * @Return Boolean
     * @Author yuan.shuai
     * @Date  2019/8/16
     * @Version 1.0.0
     */
    @OperationLog("删除系统标签")
    @RequestMapping(value = "deletLabel", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "后台系统标签删除",notes = "后台系统标签删除",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<Boolean> deleteLabel(@RequestBody(required = true) @Valid Request<Integer> request) throws Exception{
        return ApiResult.success(acSysLabelService.deleteLabel(request.getData()));
    }

    /**
     * @Description 后台活动标签修改
     * @Param LabelDetailRequest
     * @Return Boolean
     * @Author yuan.shuai
     * @Date  2019/8/16
     * @Version 1.0.0
     */
    @OperationLog("新增/修改系统标签")
    @RequestMapping(value = "addOrUpdateLabel", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "后台系统标签新增/修改",notes = "后台系统标签新增/修改",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<Boolean> updateLabel(@RequestBody(required = true) @Valid Request<LabelDetailRequest> request) throws Exception{
        return ApiResult.success(acSysLabelService.updateOrAddLabelDetail(BeanUtil.copy(request.getData(),AcSysLabelDTO.class)));
    }

}
