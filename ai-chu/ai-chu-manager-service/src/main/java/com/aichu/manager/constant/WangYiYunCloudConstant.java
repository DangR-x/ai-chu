package com.aichu.manager.constant;

/**
 * @ClassName WangYiYunCloudConstant
 * @Description 网易云配置常量参数
 * @Author Melon
 * @Date 2019/8/30 18:07
 * @Version 1.1.0
 **/
public class WangYiYunCloudConstant {

    //网易云用户注册URL
    public static final String WANG_YI_YUN_USER_REGISTER_URL = "https://api.netease.im/nimserver/user/create.action";

    //网易云用户资料信息URL
    public static final String WANG_YI_YUN_USER_INFO_URL = "https://api.netease.im/nimserver/user/getUinfos.action";

    //网易云用户资料信息URL
    public static final String WANG_YI_YUN_UPDATE_USER_INFO_URL = "https://api.netease.im/nimserver/user/updateUinfo.action";

    //网易云设置黑名单信息URL
    public static final String WANG_YI_YUN_USER_ADD_BLACKLIST_URL = "https://api.netease.im/nimserver/user/setSpecialRelation.action";

    //网易云黑名单列表信息URL
    public static final String WANG_YI_YUN_USER_BLACKLIST_URL = "https://api.netease.im/nimserver/user/listBlackAndMuteList.action";

    //网易云发送普通消息URL
    public static final String WANG_YI_YUN_COMMON_URL = "https://api.netease.im/nimserver/msg/sendMsg.action";
}
