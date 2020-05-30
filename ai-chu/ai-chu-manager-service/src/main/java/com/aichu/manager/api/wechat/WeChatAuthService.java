package com.aichu.manager.api.wechat;

import com.aichu.common.util.common.HttpClientUtils;
import com.aichu.common.util.common.Utils;
import com.aichu.common.util.exception.BusinessException;
import com.aichu.dao.autogeneration.mapper.AcUserMapper;
import com.aichu.dao.autogeneration.mapper.AcUserOauthMapper;
import com.aichu.dao.autogeneration.object.AcUserDO;
import com.aichu.dao.autogeneration.object.AcUserOauthDO;
import com.aichu.dao.autogeneration.object.AcUserOauthExample;
import com.aichu.manager.config.WeChatPayConfig;
import com.aichu.manager.constant.WeChatConstant;
import com.aichu.manager.enums.ResultCodeEnum;
import com.aichu.manager.enums.TableIsDeleteEnum;
import com.aichu.manager.enums.UserChannelTypeEnum;
import com.aichu.manager.enums.UserOauthTypeEnum;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName WeChatAuthService
 * @Description 微信授权信息Service
 * @Author Melon
 * @Date 2019/8/29 18:37
 * @Version 1.0.0
 **/
@Service
public class WeChatAuthService {

    @Autowired
    private WeChatPayConfig weChatPayConfig;

    @Autowired
    private AcUserMapper acUserMapper;

    @Autowired
    private AcUserOauthMapper acUserOauthMapper;

    /***
     * @Author Melon
     * @Description 通过WxCode获取AccessToken
     * @Date 9:42 2019/8/31
     * @Param [wxCode]
     * @Return com.alibaba.fastjson.JSONObject
     **/
    public JSONObject wxAccesTokenByWxCode(String wxCode) throws Exception {
        JSONObject jsonObject = HttpClientUtils.httpGet(WeChatConstant.CODE_BY_ACCESS_TOKEN_URL
                        + "?appid="+ weChatPayConfig.getWxAppId()
                        + "&secret=" + weChatPayConfig.getWxSecret()
                        + "&code=" + wxCode
                        + "&grant_type=authorization_code",
                        null);
        if (jsonObject == null){
            throw new BusinessException(ResultCodeEnum.CODE_BY_ACCESS_TOKEN_ERROR.code(), ResultCodeEnum.CODE_BY_ACCESS_TOKEN_ERROR.message());
        }
        return jsonObject;
    }
    
    /***
     * @Author Melon
     * @Description 微信用户信息授权
     * @Date 14:24 2019/9/9
     * @Param [userId, authCode]
     * @Return java.lang.Boolean
     **/
    public Boolean wzUserAuth(Integer userId, String authCode) throws Exception {

        //查询用户信息
        AcUserDO acUserDO = acUserMapper.selectByPrimaryKey(userId);
        //根据WxCode获取用户OpenId信息
        JSONObject tokenJson = this.wxAccesTokenByWxCode(authCode);
        JSONObject userInfoJson = this.weChatUserInfoByOpenId(tokenJson.getString("access_token"), tokenJson.getString("openid"));

        //用户基础信息
        acUserDO.setNickName(userInfoJson.getString("nickname"));
        acUserMapper.updateByPrimaryKeySelective(acUserDO);

        //第三方用户信息
        AcUserOauthExample acUserOauthExample = new AcUserOauthExample();
        acUserOauthExample.createCriteria()
                .andOpenIdEqualTo(tokenJson.getString("openid"))
                .andOauthTypeEqualTo(UserOauthTypeEnum.USER_OAUTH_TYPE_WX.getCode())
                .andIsDeleteEqualTo(TableIsDeleteEnum.TABLE_IS_DELETE_FALSE.getCode());
        List<AcUserOauthDO> acUserOauthDOList = acUserOauthMapper.selectByExample(acUserOauthExample);
        if (Utils.isEmpty(acUserOauthDOList)){
            AcUserOauthDO acUserOauthDO = new AcUserOauthDO();
            acUserOauthDO.setUserId(userId);
            acUserOauthDO.setNickName(userInfoJson.getString("nickname"));
            acUserOauthDO.setHeadImg(userInfoJson.getString("headimgurl"));
            acUserOauthDO.setOauthType(UserChannelTypeEnum.USER_CHANNEL_TYPE_WECHAT.getCode());
            acUserOauthDO.setOpenId(userInfoJson.getString("openid"));
            acUserOauthDO.setUnionId(userInfoJson.getString("unionid"));
            acUserOauthMapper.insertSelective(acUserOauthDO);
        }else {
            throw new BusinessException(ResultCodeEnum.WX_OPENID_HAS_BEEN_BIND.code(), ResultCodeEnum.WX_OPENID_HAS_BEEN_BIND.message());
        }

        return true;
    }

    /***
     * @Author Melon
     * @Description 刷新或续期access_token使用
     * @Date 9:42 2019/8/31
     * @Param [refreshToken]
     * @Return java.lang.String
     **/
    public String refreshAccessToken(String refreshToken) throws Exception {
        JSONObject jsonObject = HttpClientUtils.httpGet(WeChatConstant.REFRESH_TOKEN_URL
                        + "?appid="+ weChatPayConfig.getWxAppId()
                        + "&grant_type=refresh_token"
                        + "&refresh_token=" + refreshToken,
                        null);
        if (jsonObject == null){
            throw new BusinessException(ResultCodeEnum.REFRESH_ACCESS_TOKEN_ERROR.code(), ResultCodeEnum.REFRESH_ACCESS_TOKEN_ERROR.message());
        }
        return jsonObject.getString("access_token");
    }

    /***
     * @Author Melon
     * @Description 检验授权凭证（access_token）是否有效
     * @Date 9:46 2019/8/31
     * @Param [accessToken, openId]
     * @Return java.lang.Boolean
     **/
    public Boolean checkAccessTokenIsValid(String accessToken, String openId) throws Exception {
        JSONObject jsonObject = HttpClientUtils.httpGet(WeChatConstant.CHECK_ACCESS_TOKEN_IS_VALID_URL
                        + "?access_token="+ accessToken
                        + "&openid=" + openId,
                        null);
        if (!jsonObject.get("errmsg").equals("ok")){
            throw new BusinessException(ResultCodeEnum.CHECK_ACCESS_TOKEN_IS_VALID_ERROR.code(), ResultCodeEnum.CHECK_ACCESS_TOKEN_IS_VALID_ERROR.message());
        }
        return true;
    }
    
    /***
     * @Author Melon
     * @Description 获取用户个人信息（UnionID机制）
     * @Date 9:48 2019/8/31
     * @Param [accessToken, openId]
     * @Return com.alibaba.fastjson.JSONObject
     **/
    public JSONObject weChatUserInfoByOpenId(String accessToken, String openId) throws Exception {
        JSONObject jsonObject = HttpClientUtils.httpGet(WeChatConstant.GET_USER_INFO_URL
                        + "?access_token="+ accessToken
                        + "&openid=" + openId,
                        null);
        if (jsonObject == null){
            throw new BusinessException(ResultCodeEnum.USER_INFO_BY_OPEN_ID_ERROR.code(), ResultCodeEnum.USER_INFO_BY_OPEN_ID_ERROR.message());
        }
        return jsonObject;
    }
}
