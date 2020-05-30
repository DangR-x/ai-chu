package com.aichu.app.api;

import com.aichu.app.authorization.jwt.JwtConfig;
import com.aichu.app.authorization.jwt.JwtTokenBuilder;
import com.aichu.app.vo.request.AccountLoginRequest;
import com.aichu.app.vo.response.TokenResponse;
import com.aichu.common.util.api.ApiResult;
import com.aichu.common.util.api.Request;
import com.aichu.common.util.auth.annotation.IgnoreAuthorization;
import com.aichu.common.util.auth.manager.TokenManager;
import com.aichu.common.util.common.Utils;
import com.aichu.common.util.exception.BusinessException;
import com.aichu.common.util.sign.AcSignUtils;
import com.aichu.dao.autogeneration.object.AcUserAnchorDO;
import com.aichu.dao.autogeneration.object.AcUserDO;
import com.aichu.manager.api.im.user.WangYiYunCloudUserService;
import com.aichu.manager.api.sms.YueFanSmsService;
import com.aichu.manager.dao.SmsCodeCacheDao;
import com.aichu.manager.dto.WangYiYunCloudTokenDTO;
import com.aichu.manager.enums.ResultCodeEnum;
import com.aichu.manager.enums.SystemUserImageEnum;
import com.aichu.manager.enums.TableIsDeleteEnum;
import com.aichu.service.api.AcUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

/**
 * @ClassName AccountController
 * @Description 爱触用户登录Controller
 * @Author Melon
 * @Date 2019/7/19 9:40
 * @Version 1.0.0
 **/
@RestController
@RequestMapping(value = "/account")
@Api(value = "爱触账户Controller", tags = "爱触用户登陆接口")
public class AccountController {

    @Autowired
    private SmsCodeCacheDao authCodeDao;

    @Autowired
    private TokenManager tokenManager;

    @Autowired
    private JwtConfig jwtConfig;

    @Autowired
    private JwtTokenBuilder jwtTokenBuilder;

    @Autowired
    private AcUserService acUserService;

    @Autowired
    private YueFanSmsService yueFanSmsService;

    @Autowired
    private WangYiYunCloudUserService wangYiYunCloudUserService;

    /**
     * @MethodName: login
     * @Author: Melon
     * @Date: 2019-1-9 15:15
     * @Param: AccountLoginRequest
     * @return: Token
     * @Version: V1.1.0
     * @Description: 登录[新用户自动注册]
     **/
    @IgnoreAuthorization
    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "用户登录", notes = "用户登录", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult<TokenResponse> login(@RequestBody(required = true) @Valid Request<AccountLoginRequest> request) throws Exception {
        TokenResponse tokenResponse = doLoginByPhone(request.getData().getPhone(), request.getData().getAuthCode(),request.getData().getSuperiorUserId());
        return ApiResult.success(tokenResponse);
    }

    /***
     * @Author Melon
     * @Description 手机号验证码登录
     * @Date 13:43 2019/7/19
     * @Param [phone, authCode,superiorUserId]
     * @Return com.aichu.app.vo.response.TokenResponse
     **/
    private TokenResponse doLoginByPhone(String phone, String authCode,Integer superiorUserId) throws Exception {

        // 验证验证码是否正确
        //String lastAuthCode = yueFanSmsService.getAuthCode(phone);
        String lastAuthCode = "123456";
        if (Utils.isEmpty(authCode) || Utils.isEmpty(lastAuthCode) || !lastAuthCode.equals(authCode)) {
            throw new BusinessException(ResultCodeEnum.AUTH_CODE_ERROR.getCode(), ResultCodeEnum.AUTH_CODE_ERROR.getMessage());
        } else {
            authCodeDao.deleteAuthCodeCache(phone);
        }

        //判断用户是否存在
        AcUserDO acUserDO =  acUserService.selectAcUserByPhone(phone);
        if (null == acUserDO){
            //创建账户信息
            acUserDO = new AcUserDO();
            acUserDO.setAcUid(AcSignUtils.systemAcUID());
            acUserDO.setPhone(phone);
            acUserDO.setHeadImg(SystemUserImageEnum.AI_CHU_SYSTEM_USER_HEAD_IMAGE.getName());
            acUserService.insertAcUserWithAccount(acUserDO);
            acUserDO = acUserService.selectAcUserByPhone(phone);
            // 是否存在上级用户 存在就插入
            if (Utils.notEmpty(superiorUserId)){
                AcUserAnchorDO anchorDO = new AcUserAnchorDO();
                anchorDO.setUserId(superiorUserId);
                anchorDO.setAnchorUserId(acUserDO.getId());
                anchorDO.setIsDelete(TableIsDeleteEnum.TABLE_IS_DELETE_FALSE.getCode());
                anchorDO.setCreateTime(new Date());
                acUserService.insertUserAnchor(anchorDO);
            }
        }

        //生成Token信息并存储到Redis
        return BuildToken(acUserDO);
    }


    /**
     * @ClassName AccountController
     * @Description 缓存登陆
     * @Author Melon
     * @Date 2019/7/20 16:18
     * @Version 1.0.0
     **/
    @IgnoreAuthorization
    @RequestMapping(value = "/cacheLogin", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "缓存登录", notes = "缓存登录", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResult<TokenResponse> cacheLogin(@RequestBody(required = true) Request<AccountLoginRequest> request) throws Exception {

        //根据用户电话查找用户信息
        AcUserDO acUserDO = acUserService.selectAcUserByPhone(request.getData().getPhone());
        if (acUserDO == null){
            throw new BusinessException(ResultCodeEnum.USER_INFO_NOT_EXISTED.code(), ResultCodeEnum.USER_INFO_NOT_EXISTED.message());
        }

        String jwtSubject = JwtTokenBuilder.buildSubject(new HashMap<String, String>(1) {{
            put("phone", acUserDO.getPhone());
        }});

        String refreshToken = jwtTokenBuilder.buildToken(jwtSubject, jwtConfig.getRefreshExpiresSecond(),
                jwtConfig.getRefreshBase64Secret());
        //AccessToken
        String accessToken = tokenManager.getTokenByKey(acUserDO.getPhone());
        if(Utils.isEmpty(accessToken)) {
            throw new BusinessException(ResultCodeEnum.LOGIN_TOKEN_EFFICACY.getCode(), ResultCodeEnum.LOGIN_TOKEN_EFFICACY.getMessage());
        }

        //Token信息
        TokenResponse token = new TokenResponse();
        token.setAccess_token(tokenManager.getTokenByKey(acUserDO.getPhone()));
        token.setRefresh_token(refreshToken);
        token.setToken_type("aichu 1.0.0");
        token.setIsBindPhone(Objects.isNull(acUserDO.getPhone()));
        token.setIsAgency(acUserDO.getIsAgency());
        if (acUserDO.getSex() == null || (acUserDO.getNickName() == null && acUserDO.getNickName().equals(""))
                || (acUserDO.getBirthDate() == null && acUserDO.getBirthDate().equals(""))
                || acUserDO.getProvinceId() == null || acUserDO.getCityId() == null || acUserDO.getAreaId() == null){
            token.setIsAuthentication(0);
        }else {
            token.setIsAuthentication(1);
        }
        token.setExpires_in(jwtConfig.getExpiresSecond());
        return ApiResult.success(token);
    }

    /***
     * @Author Melon
     * @Description 用户信息检验
     * @Date 10:57 2019/8/2
     * @Param [phone]
     * @Return void
     **/    
    private void userInformationCheck(String lastAuthCode, String authCode, String phone) throws Exception {

        if (Utils.isEmpty(authCode) || Utils.isEmpty(lastAuthCode) || !lastAuthCode.equals(authCode)) {
            throw new BusinessException(ResultCodeEnum.AUTH_CODE_ERROR.getCode(), ResultCodeEnum.AUTH_CODE_ERROR.getMessage());
        } else {
            authCodeDao.deleteAuthCodeCache(phone);
        }

        //判断用户是否存在
        AcUserDO acUserDO =  acUserService.selectAcUserByPhone(phone);
        if (null != acUserDO){
            throw new BusinessException(ResultCodeEnum.USER_INFO_HAS_EXISTED.code(), ResultCodeEnum.USER_INFO_HAS_EXISTED.message());
        }
    }

    /***
     * @Author Melon
     * @Description 系统生成JWT_Token信息
     * @Date 15:29 2019/7/20
     * @Param [acUserDO]
     * @Return com.aichu.app.vo.response.TokenResponse
     **/
    private TokenResponse BuildToken(AcUserDO acUserDO) throws Exception {

        TokenResponse token = new TokenResponse();
        String accessToken = null;
        String refreshToken = null;

        try {
            String jwtSubject = JwtTokenBuilder.buildSubject(new HashMap<String, String>(1) {{
                put("phone", acUserDO.getPhone());
            }});
            accessToken = jwtTokenBuilder.buildToken(jwtSubject, jwtConfig.getExpiresSecond(),
                    jwtConfig.getBase64Secret());
            refreshToken = jwtTokenBuilder.buildToken(jwtSubject, jwtConfig.getRefreshExpiresSecond(),
                    jwtConfig.getRefreshBase64Secret());
        } catch (Exception e) {
            throw new BusinessException(ResultCodeEnum.LOGIN_FAILED.getCode(), ResultCodeEnum.LOGIN_FAILED.getMessage());
        }
        token.setAccess_token(accessToken);
        //wangYiYunCloudUserInfo
        if (acUserDO.getImToken() == null){
            WangYiYunCloudTokenDTO wangYiYunCloudTokenDTO = wangYiYunCloudUserService.wangYiYunCloudUserRegister(acUserDO.getId(), acUserDO.getAcUid(), acUserDO.getNickName(), acUserDO.getHeadImg());
            token.setIm_token(wangYiYunCloudTokenDTO.getWangYiYunCloudUserToken());
        }else {
            token.setIm_token(acUserDO.getImToken());
        }
        token.setRefresh_token(refreshToken);
        token.setToken_type("aichu 1.0.0");
        token.setUserId(acUserDO.getId());
        token.setUserAcId(acUserDO.getAcUid());
        token.setUserHeadImg(acUserDO.getHeadImg());
        token.setIsBindPhone(Objects.isNull(acUserDO.getPhone()) ? false : true);
        token.setPhoneNum(acUserDO.getPhone());
        if (acUserDO.getSex() == null || (acUserDO.getNickName() == null && "".equals(acUserDO.getNickName()))
                || (acUserDO.getBirthDate() == null && "".equals(acUserDO.getBirthDate()))
                || acUserDO.getProvinceId() == null || acUserDO.getCityId() == null || acUserDO.getAreaId() == null){
            token.setIsAuthentication(0);
        }else {
            token.setIsAuthentication(1);
        }
        token.setIsAgency(acUserDO.getIsAgency() == 0 ? 0 : 1);
        token.setIsAnchor(acUserDO.getIsAnchor() == 0 ? 0 : 1);
        token.setExpires_in(jwtConfig.getExpiresSecond());
        token.setSignDays(acUserService.userSignDays(acUserDO.getId()));
        token.setIsSign(acUserService.userIsSignToDay(acUserDO.getId()) == true ? 1 : 0);

        // 存储到redis
        tokenManager.createRelationship(acUserDO.getPhone(), accessToken);
        return token;
    }
}
