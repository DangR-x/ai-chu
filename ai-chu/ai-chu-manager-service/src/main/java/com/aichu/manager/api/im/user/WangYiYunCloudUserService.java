package com.aichu.manager.api.im.user;

import com.aichu.common.util.common.Utils;
import com.aichu.common.util.exception.BusinessException;
import com.aichu.dao.autogeneration.mapper.AcUserMapper;
import com.aichu.dao.autogeneration.object.AcUserDO;
import com.aichu.dao.autogeneration.object.AcUserExample;
import com.aichu.manager.api.im.builder.CheckSumBuilder;
import com.aichu.manager.api.im.config.WangYiYunCloudHttpConfig;
import com.aichu.manager.config.WangYiYunCloudConfig;
import com.aichu.manager.constant.WangYiYunCloudConstant;
import com.aichu.manager.dto.UserBlackListInfoDTO;
import com.aichu.manager.dto.WangYiYunCloudTokenDTO;
import com.aichu.manager.dto.WangYiYunUserInfoDTO;
import com.aichu.manager.enums.ResultCodeEnum;
import com.aichu.manager.enums.TableIsDeleteEnum;
import com.aichu.manager.enums.UserBlackListTypeEnum;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.rong.RongCloud;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.bouncycastle.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName WangYiYunCloudUserService
 * @Description 网易云用户信息Service
 * @Author Melon
 * @Date 2019/7/19 11:03
 * @Version 1.0.0
 **/
@Service
public class WangYiYunCloudUserService {

    private Logger logger = LoggerFactory.getLogger(WangYiYunCloudUserService.class);

    @Autowired
    private WangYiYunCloudConfig wangYiYunCloudConfig;

    @Autowired
    private AcUserMapper acUserMapper;

    private static String appKey = null;

    private static String appSecret = null;

    private static String nonce = null;

    private static String curTime = null;

    private static String checkSum = null;

    @PostConstruct
    public void init() {

        //初始化网易云参数信息
        appKey = wangYiYunCloudConfig.getAppKey();
        appSecret = wangYiYunCloudConfig.getAppSecret();
        nonce = "12345";
    }

    /***
     * @Author Melon
     * @Description 获取网易云用户注册Token信息
     * API 文档: https://api.netease.im/nimserver/user/create.action HTTP/1.1
     * @Date 15:06 2019/8/8
     * @Param [wzUId, userName, headImage]
     * @Return io.rong.models.response.TokenResult
     **/
    public WangYiYunCloudTokenDTO wangYiYunCloudUserRegister(Integer userId, String acUid, String userName, String headImage) throws Exception{
        logger.info("----获网易云用户注册Token信息---Start--- :userId - {}, acUid - {}, userName - {}, headImage - {}", userId, acUid, userName, headImage);


        //用户信息
        AcUserDO acUserDO = acUserMapper.selectByPrimaryKey(userId);
        if (acUserDO == null){
            throw new BusinessException(ResultCodeEnum.USER_INFO_NOT_EXISTED.code(), ResultCodeEnum.USER_INFO_NOT_EXISTED.message());
        }

        WangYiYunCloudTokenDTO wangYiYunCloudTokenDTO = new WangYiYunCloudTokenDTO();

        //注册用户，生成用户在网易云的唯一身份标识 Token
        curTime = String.valueOf((new Date()).getTime() / 1000L);
        checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce ,curTime);//参考 计算CheckSum的java代码
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = WangYiYunCloudHttpConfig.WangYiYunCloudHttpInit(WangYiYunCloudConstant.WANG_YI_YUN_USER_REGISTER_URL, appKey, nonce, curTime, checkSum);

        // 设置请求的参数
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("accid", acUid));
        nvps.add(new BasicNameValuePair("name", userName));
        nvps.add(new BasicNameValuePair("icon", headImage));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));

        // 执行请求
        HttpResponse response = httpClient.execute(httpPost);

        // 打印执行结果
        //System.out.println(EntityUtils.toString(response.getEntity(), "utf-8"));
        JSONObject responseJsonObject = JSONObject.parseObject(EntityUtils.toString(response.getEntity(), "utf-8"));
        logger.info("----获网易云用户注册Token信息---Start--- :userId - {}, acUid - {}, userName - {}, headImage - {}", userId, acUid, userName, headImage);
        logger.info("----responseJsonObject---", responseJsonObject);
        if (!responseJsonObject.getString("code").equals("200")){
            if (!responseJsonObject.getString("code").equals("414")){
                throw new BusinessException(ResultCodeEnum.WANG_YI_YUN_USER_HAS_REGISTER.code(), ResultCodeEnum.WANG_YI_YUN_USER_HAS_REGISTER.message());
            }
            throw new BusinessException(ResultCodeEnum.WANG_YI_YUN_REGISTER_TOKEN_ERROR.code(), ResultCodeEnum.WANG_YI_YUN_REGISTER_TOKEN_ERROR.message());
        }

        JSONObject infoJsonObject = responseJsonObject.getJSONObject("info");
        wangYiYunCloudTokenDTO.setWangYiYunCloudUserToken(infoJsonObject.getString("token"));
        wangYiYunCloudTokenDTO.setWangYiYunCloudUserAccId(Strings.toUpperCase(infoJsonObject.getString("accid")));
        wangYiYunCloudTokenDTO.setWangYiYunCloudUserName(infoJsonObject.getString("name"));

        acUserDO.setImToken(infoJsonObject.getString("token"));
        Integer result = acUserMapper.updateByPrimaryKeySelective(acUserDO);
        if (result == 0){
            throw new BusinessException(ResultCodeEnum.UPDATE_USER_ERROR.code(), ResultCodeEnum.UPDATE_USER_ERROR.message());
        }

        logger.info("----获取网易云用户注册Token信息---End--- :result - {}", response.toString());
        return wangYiYunCloudTokenDTO;
    }
    
    /***
     * @Author Melon
     * @Description 获取网易云用户资料信息
     * API 文档: https://api.netease.im/nimserver/user/getUinfos.action HTTP/1.1
     * @Date 17:37 2020/1/4
     * @Param [acUid]
     * @Return com.aichu.manager.dto.WangYiYunUserInfoDTO
     **/
    public WangYiYunUserInfoDTO wangYiYunCloudUserInfo(String acUid) throws Exception{
        logger.info("----获取网易云用户资料信息---Start--- :acUid - {}", acUid);

        WangYiYunUserInfoDTO wangYiYunUserInfoDTO = new WangYiYunUserInfoDTO();

        JSONArray jsonArray = new JSONArray();
        jsonArray.add(acUid);
        //初始化Http请求
        curTime = String.valueOf((new Date()).getTime() / 1000L);
        checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce ,curTime);//参考 计算CheckSum的java代码
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = WangYiYunCloudHttpConfig.WangYiYunCloudHttpInit(WangYiYunCloudConstant.WANG_YI_YUN_USER_INFO_URL, appKey, nonce, curTime, checkSum);

        // 设置请求的参数
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("accids", jsonArray.toString()));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));

        // 执行请求
        HttpResponse response = httpClient.execute(httpPost);

        // 打印执行结果
        //System.out.println(EntityUtils.toString(response.getEntity(), "utf-8"));
        JSONObject responseJsonObject = JSONObject.parseObject(EntityUtils.toString(response.getEntity(), "utf-8"));
        if (!responseJsonObject.getString("code").equals("200")){
            throw new BusinessException(ResultCodeEnum.WANG_YI_YUN_GET_USER_ERROR.code(), ResultCodeEnum.WANG_YI_YUN_GET_USER_ERROR.message());
        }

        JSONObject infoJsonObject = responseJsonObject.getJSONArray("uinfos").getJSONObject(0);
        wangYiYunUserInfoDTO.setWangYiYunCloudUserAccId(Strings.toUpperCase(infoJsonObject.getString("accid")));
        wangYiYunUserInfoDTO.setWangYiYunCloudUserName(infoJsonObject.getString("name"));
        wangYiYunUserInfoDTO.setWangYiYunCloudUserHeadImg(infoJsonObject.getString("icon"));

        logger.info("----获取网易云用户资料信息---End--- :result - {}", response.toString());
        return wangYiYunUserInfoDTO;
    }

    /***
     * @Author Melon
     * @Description 更新网易云用户资料信息
     * API 文档: https://api.netease.im/nimserver/user/updateUinfo.action  HTTP/1.1
     * @Date 18:01 2020/1/4
     * @Param [acUid, userName, headImage]
     * @Return java.lang.Boolean
     **/
    public Boolean wangYiYunCloudUpdateUserInfo(String acUid, String userName, String headImage) throws Exception{
        logger.info("----更新网易云用户资料信息---Start--- :acUid - {}, userName - {}, headImage - {}", acUid, userName, headImage);

        //初始化Http请求
        curTime = String.valueOf((new Date()).getTime() / 1000L);
        checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce ,curTime);//参考 计算CheckSum的java代码
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = WangYiYunCloudHttpConfig.WangYiYunCloudHttpInit(WangYiYunCloudConstant.WANG_YI_YUN_UPDATE_USER_INFO_URL, appKey, nonce, curTime, checkSum);

        // 设置请求的参数
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("accid", Strings.toLowerCase(acUid)));
        nvps.add(new BasicNameValuePair("name", userName));
        nvps.add(new BasicNameValuePair("icon", headImage));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));

        // 执行请求
        HttpResponse response = httpClient.execute(httpPost);

        // 打印执行结果
        //System.out.println(EntityUtils.toString(response.getEntity(), "utf-8"));
        JSONObject responseJsonObject = JSONObject.parseObject(EntityUtils.toString(response.getEntity(), "utf-8"));
        if (!responseJsonObject.getString("code").equals("200")){
            throw new BusinessException(ResultCodeEnum.WANG_YI_YUN_UPDATE_USER_ERROR.code(), ResultCodeEnum.WANG_YI_YUN_UPDATE_USER_ERROR.message());
        }

        logger.info("----更新网易云用户资料信息---End--- :result - {}", response.toString());
        return true;
    }

    /***
     * @Author Melon
     * @Description 获取用户黑名单列表
     * API 文档: https://api.netease.im/nimserver/user/listBlackAndMuteList.action HTTP/1.1
     * @Date 11:44 2020/1/6
     * @Param [acUid]
     * @Return java.util.List<com.aichu.manager.dto.UserBlackListInfoDTO>
     **/
    public List<UserBlackListInfoDTO> wangYiYunCloudUserBlackListInfo(String acUid) throws Exception{
        logger.info("----获取用户黑名单列表---Start--- :acUid - {}", acUid);

        List<UserBlackListInfoDTO> userBlackListInfoDTOList = new ArrayList<>();

        //初始化Http请求
        curTime = String.valueOf((new Date()).getTime() / 1000L);
        checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce ,curTime);//参考 计算CheckSum的java代码
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = WangYiYunCloudHttpConfig.WangYiYunCloudHttpInit(WangYiYunCloudConstant.WANG_YI_YUN_USER_BLACKLIST_URL, appKey, nonce, curTime, checkSum);

        // 设置请求的参数
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("accid", Strings.toLowerCase(acUid)));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));

        // 执行请求
        HttpResponse response = httpClient.execute(httpPost);

        // 打印执行结果
        //System.out.println(EntityUtils.toString(response.getEntity(), "utf-8"));
        JSONObject responseJsonObject = JSONObject.parseObject(EntityUtils.toString(response.getEntity(), "utf-8"));
        if (!responseJsonObject.getString("code").equals("200")){
            throw new BusinessException(ResultCodeEnum.WANG_YI_YUN_GET_USER_BLACK_LIST_ERROR.code(), ResultCodeEnum.WANG_YI_YUN_GET_USER_BLACK_LIST_ERROR.message());
        }

        JSONArray blacklistJsonArray = responseJsonObject.getJSONArray("blacklist");
        blacklistJsonArray.stream().forEach( blacklistJson ->{
            UserBlackListInfoDTO userBlackListInfoDTO = new UserBlackListInfoDTO();

            AcUserExample acUserExample = new AcUserExample();
            acUserExample.createCriteria()
                    .andAcUidEqualTo(Strings.toUpperCase(blacklistJson.toString()))
                    .andIsDeleteEqualTo(TableIsDeleteEnum.TABLE_IS_DELETE_FALSE.getCode());
            List<AcUserDO> acUserDOList = acUserMapper.selectByExample(acUserExample);
            if (Utils.isEmpty(acUserDOList)){
                throw new BusinessException(ResultCodeEnum.USER_INFO_NOT_EXISTED.code(), ResultCodeEnum.USER_INFO_NOT_EXISTED.message());
            }
            userBlackListInfoDTO.setUserId(acUserDOList.get(0).getId());
            userBlackListInfoDTO.setUserAcId(acUserDOList.get(0).getAcUid());
            userBlackListInfoDTO.setUserName(acUserDOList.get(0).getNickName());
            userBlackListInfoDTO.setUserHead(acUserDOList.get(0).getHeadImg());
            userBlackListInfoDTO.setUserSignature(acUserDOList.get(0).getSignature());
            userBlackListInfoDTOList.add(userBlackListInfoDTO);
        });

        logger.info("----获取用户黑名单列表---End--- :result - {}", response.toString());
        return userBlackListInfoDTOList;
    }

    /***
     * @Author Melon
     * @Description 用户添加黑名单
     * API 文档: https://api.netease.im/nimserver/user/listBlackAndMuteList.action HTTP/1.1
     * @Date 18:01 2020/1/4
     * @Param [acUid]
     * @Return java.lang.Boolean
     **/
    public Boolean wangYiYunCloudUserAddBlackList(String aimAcId, String acUid) throws Exception{
        logger.info("----用户添加黑名单---Start--- :aimAcId - {}, acUid - {}", aimAcId, acUid);

        //初始化Http请求
        curTime = String.valueOf((new Date()).getTime() / 1000L);
        checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce ,curTime);//参考 计算CheckSum的java代码
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = WangYiYunCloudHttpConfig.WangYiYunCloudHttpInit(WangYiYunCloudConstant.WANG_YI_YUN_USER_ADD_BLACKLIST_URL, appKey, nonce, curTime, checkSum);

        // 设置请求的参数
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("accid", Strings.toLowerCase(acUid)));
        nvps.add(new BasicNameValuePair("targetAcc", Strings.toLowerCase(aimAcId)));
        nvps.add(new BasicNameValuePair("relationType", String.valueOf(UserBlackListTypeEnum.USER_BLACK_LIST_TYPE_RELATION_BLACK_LIST.getCode())));
        nvps.add(new BasicNameValuePair("value", String.valueOf(UserBlackListTypeEnum.USER_BLACK_LIST_TYPE_VALUE_SILENCE.getCode())));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));

        // 执行请求
        HttpResponse response = httpClient.execute(httpPost);

        // 打印执行结果
        //System.out.println(EntityUtils.toString(response.getEntity(), "utf-8"));
        JSONObject responseJsonObject = JSONObject.parseObject(EntityUtils.toString(response.getEntity(), "utf-8"));
        if (!responseJsonObject.getString("code").equals("200")){
            throw new BusinessException(ResultCodeEnum.WANG_YI_YUN_ADD_USER_BLACK_LIST_ERROR.code(), ResultCodeEnum.WANG_YI_YUN_ADD_USER_BLACK_LIST_ERROR.message());
        }

        logger.info("----用户添加黑名单---End--- :result - {}", response.toString());
        return true;
    }

    /***
     * @Author Melon
     * @Description 用户移除黑名单
     * API 文档: https://api.netease.im/nimserver/user/listBlackAndMuteList.action HTTP/1.1
     * @Date 18:01 2020/1/4
     * @Param [acUid]
     * @Return java.lang.Boolean
     **/
    public Boolean wangYiYunCloudUserRemoveBlackList(String aimAcId, String acUid) throws Exception{
        logger.info("----用户移除黑名单---Start--- :aimAcId - {}, acUid - {}", aimAcId, acUid);

        //初始化Http请求
        curTime = String.valueOf((new Date()).getTime() / 1000L);
        checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce ,curTime);//参考 计算CheckSum的java代码
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = WangYiYunCloudHttpConfig.WangYiYunCloudHttpInit(WangYiYunCloudConstant.WANG_YI_YUN_USER_ADD_BLACKLIST_URL, appKey, nonce, curTime, checkSum);

        // 设置请求的参数
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("accid", Strings.toLowerCase(acUid)));
        nvps.add(new BasicNameValuePair("targetAcc", Strings.toLowerCase(aimAcId)));
        nvps.add(new BasicNameValuePair("relationType", String.valueOf(UserBlackListTypeEnum.USER_BLACK_LIST_TYPE_RELATION_BLACK_LIST.getCode())));
        nvps.add(new BasicNameValuePair("value", String.valueOf(UserBlackListTypeEnum.USER_BLACK_LIST_TYPE_VALUE_BLACK_LIST.getCode())));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));

        // 执行请求
        HttpResponse response = httpClient.execute(httpPost);

        // 打印执行结果
        //System.out.println(EntityUtils.toString(response.getEntity(), "utf-8"));
        JSONObject responseJsonObject = JSONObject.parseObject(EntityUtils.toString(response.getEntity(), "utf-8"));
        if (!responseJsonObject.getString("code").equals("200")){
            throw new BusinessException(ResultCodeEnum.WANG_YI_YUN_REMOVE_USER_BLACK_LIST_ERROR.code(), ResultCodeEnum.WANG_YI_YUN_REMOVE_USER_BLACK_LIST_ERROR.message());
        }

        logger.info("----用户移除黑名单---End--- :result - {}", response.toString());
        return true;
    }
}
