package com.aichu.app.api;

import com.aichu.app.vo.response.*;
import com.aichu.common.util.api.ApiResult;
import com.aichu.common.util.auth.annotation.IgnoreAuthorization;
import com.aichu.common.util.common.BeanUtil;
import com.aichu.manager.api.oss.QiNiuOssService;
import com.aichu.service.api.AcChartGoodsService;
import com.aichu.service.api.AcSysBannerService;
import com.aichu.service.api.AcSysLabelService;
import com.aichu.service.api.AcSysProvinceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @ClassName DictInfoController
 * @Description 爱触字典相关信息接口
 * @Author Melon
 * @Date 2019/7/22 18:07
 * @Version 1.0.0
 **/
@RestController
@RequestMapping(value = "/dict")
@Api(value = "爱触字典Controller", tags = "爱触字典相关信息接口")
public class DictInfoController {

    @Autowired
    private QiNiuOssService qiNiuOssService;

    @Autowired
    private AcSysProvinceService acSysProvinceService;

    @Autowired
    private AcSysBannerService acSysBannerService;

    @Autowired
    private AcSysLabelService acSysLabelService;

    @Autowired
    private AcChartGoodsService acChartGoodsService;

    /***
     * @Author Melon
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

    /***
     * @Author Melon
     * @Description 获取地理信息列表
     * @Date 11:04 2019/7/23
     * @Param []
     * @Return java.util.Map<java.lang.String,java.lang.Object>
     **/
    @IgnoreAuthorization
    @RequestMapping(value = "/geography/dict", method = RequestMethod.GET)
    @ApiOperation(value = "获取地理字典信息列表", notes = "获取地理信息列表", httpMethod = "GET")
    public ApiResult<List<Map<String, Object>>> geographyInfoList() throws Exception{
        return ApiResult.success(acSysProvinceService.geographyInfoMap());
    }
    
    /***
     * @Author Melon
     * @Description 系统Banner字典信息
     * @Date 18:15 2019/12/26
     * @Param [bannerType]
     * @Return com.aichu.common.util.api.ApiResult<java.util.List<java.lang.String>>
     **/
    @IgnoreAuthorization
    @RequestMapping(value = "/banner/dict/{bannerType}", method = RequestMethod.GET)
    @ApiOperation(value = "系统Banner字典信息", notes = "系统Banner字典信息", httpMethod = "GET")
    @ApiImplicitParam(name="bannerType", dataType = "Integer", value = "目标文件夹类型（0-启动页Banner,1-首页Banner）", required = true)
    public ApiResult<List<String>> systemBannerDictInfoList(@PathVariable("bannerType") Integer bannerType) throws Exception{
        return ApiResult.success(acSysBannerService.systemBannerDictInfoList(bannerType));
    }

    /***
     * @Author Melon
     * @Description 标签字典信息列表
     * @Date 18:31 2019/12/26
     * @Param [labelType]
     * @Return com.aichu.common.util.api.ApiResult<java.util.List<com.aichu.app.vo.response.LabelDictResponse>>
     **/
    @IgnoreAuthorization
    @RequestMapping(value = "/label/dict/{labelType}", method = RequestMethod.GET)
    @ApiOperation(value = "标签字典信息列表", notes = "标签字典信息列表", httpMethod = "GET")
    @ApiImplicitParam(name="labelType", dataType = "Integer", value = "标签类型(0-身高标签，1-体重标签，2-职业标签，3-星座标签，4-印象标签，5-评论标签, 6-签到金币)", required = true)
    public ApiResult<List<LabelDictResponse>> labelDictList(@PathVariable("labelType") Integer labelType) throws Exception{
        return ApiResult.success(BeanUtil.copy(acSysLabelService.labelDictList(labelType), LabelDictResponse.class));
    }

    /***
     * @Author Melon
     * @Description 聊天商品信息
     * @Date 10:26 2020/1/10
     * @Param []
     * @Return com.aichu.common.util.api.ApiResult<java.util.List<com.aichu.app.vo.response.UserChartGoodsListResponse>>
     **/
    @IgnoreAuthorization
    @RequestMapping(value = "/chart/goods", method = RequestMethod.GET)
    @ApiOperation(value = "聊天商品信息", notes = "聊天商品信息", httpMethod = "GET")
    public ApiResult<List<UserChartGoodsListResponse>> cloudChartGoodsList() throws Exception{
        return ApiResult.success(BeanUtil.copy(acChartGoodsService.cloudChartGoodsList(), UserChartGoodsListResponse.class));
    }

    /***
     * @Author Melon
     * @Description 优惠卡信息
     * @Date 14:19 2020/2/19
     * @Param []
     * @Return com.aichu.common.util.api.ApiResult<java.util.List<com.aichu.app.vo.response.PreferentialCardResponse>>
     **/
    @IgnoreAuthorization
    @RequestMapping(value = "/preferential/card", method = RequestMethod.GET)
    @ApiOperation(value = "优惠卡信息", notes = "优惠卡信息", httpMethod = "GET")
    public ApiResult<List<PreferentialCardResponse>> preferentialCard() throws Exception{
        return ApiResult.success(BeanUtil.copy(acChartGoodsService.preferentialCard(), PreferentialCardResponse.class));
    }
    
    /***
     * @Author Melon
     * @Description 充值配置信息
     * @Date 14:43 2020/2/19
     * @Param []
     * @Return com.aichu.common.util.api.ApiResult<java.util.List<com.aichu.app.vo.response.ChargeConfigResponse>>
     **/
    @IgnoreAuthorization
    @RequestMapping(value = "/charge/config", method = RequestMethod.GET)
    @ApiOperation(value = "充值配置信息", notes = "充值配置信息", httpMethod = "GET")
    public ApiResult<List<ChargeConfigResponse>> chargeConfig() throws Exception{
        return ApiResult.success(BeanUtil.copy(acChartGoodsService.chargeConfig(), ChargeConfigResponse.class));
    }
}
