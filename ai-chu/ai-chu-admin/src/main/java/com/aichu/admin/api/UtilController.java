package com.aichu.admin.api;

import com.aichu.admin.vo.response.AcUtilIdAndNameResponse;
import com.aichu.admin.vo.response.UploadFileResponse;
import com.aichu.common.util.api.ApiResult;
import com.aichu.common.util.auth.annotation.IgnoreAuthorization;
import com.aichu.common.util.common.BeanUtil;
import com.aichu.manager.api.oss.QiNiuOssService;
import com.aichu.service.api.AcUtilService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName UtilController
 * @Author yuan.shuai
 * @Description
 * @Date 2019/12/16
 * @Version 1.0.0
 */
@RestController
@RequestMapping("/util/manager")
@Api(value = "后台工具类管理",tags = "后台工具类管理接口")
public class UtilController {

    @Autowired
    private AcUtilService utilService;

    @Autowired
    private QiNiuOssService qiNiuOssService;

    @RequestMapping(value = "/province/list", method = RequestMethod.GET)
    @ApiOperation(value = "查询省列表数据",notes = "查询省列表数据",httpMethod = "GET")
    @ApiImplicitParams({@ApiImplicitParam(name = "Authorization", required = true, paramType = "header")})
    public ApiResult<List<AcUtilIdAndNameResponse>> getProvinceList() throws Exception{
        return ApiResult.success(BeanUtil.copy(utilService.getProvinceList(),AcUtilIdAndNameResponse.class));
    }

    /***
     * @Author Yuan.shuai
     * @Description 七牛云文件上传凭证
     * @Date 17:28 2019/12/26
     * @Param []
     * @Return com.aichu.common.util.api.ApiResult<java.lang.String>
     **/
    @IgnoreAuthorization
    @RequestMapping(value = "/qiuniu/upload/certificate", method = RequestMethod.GET)
    @ApiOperation(value = "七牛云文件上传凭证", notes = "七牛云文件上传凭证", httpMethod = "GET")
    public ApiResult<UploadFileResponse> uploadFileToOSSClient() throws Exception{
        return ApiResult.success(BeanUtil.copy(qiNiuOssService.qiuNiuOSSUploadCertificate(), UploadFileResponse.class));
    }
}
