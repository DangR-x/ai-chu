package com.aichu.manager.enums;

/**
 * @ClassName SystemUserImageEnum
 * @Description 问祖用户系统默认图片信息
 * @Author Melon
 * @Date 2019/7/26 15:59
 * @Version 1.0.0
 **/
public enum SystemUserImageEnum {

    AI_CHU_SYSTEM_USER_HEAD_IMAGE("爱触用户系统默认头像地址",
            "http://wenzu.oss-cn-shenzhen.aliyuncs.com/system/system1566294781534.png?Expires=1881654781&OSSAccessKeyId=LTAIw6NezbDnPNKz&Signature=Q63AiurE60sYEUHX4tD9a77gVc4%3D"),
    AI_CHU_SYSTEM_SYS_HEAD_IMAGE("爱触系统平台默认头像地址",
            "http://wenzu.oss-cn-shenzhen.aliyuncs.com/system/system1566203419516.png?Expires=1881563417&OSSAccessKeyId=LTAIw6NezbDnPNKz&Signature=dDSMnoiyd8OPyX1qIk9KL0nlLlo%3D"),
    AI_CHU_SYSTEM_SYS_GROUP_HEAD_IMAGE("爱触系统群组默认头像地址",
            "http://wenzu.oss-cn-shenzhen.aliyuncs.com/system/system1566294669824.png?Expires=1881654663&OSSAccessKeyId=LTAIw6NezbDnPNKz&Signature=jTVT8BtA%2BSbWfy7CEpXJy%2BCJaA0%3D");


    /* Code码 */
    private String code;

    /* 信息 */
    private String name;

    SystemUserImageEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
