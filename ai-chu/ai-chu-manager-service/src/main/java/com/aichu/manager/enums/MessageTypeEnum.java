package com.aichu.manager.enums;

/**
 * @ClassName MessageTypeEnum
 * @Description 消息类型信息枚举
 * @Author Melon
 * @Date 2019/7/26 15:59
 * @Version 1.0.0
 **/
public enum MessageTypeEnum {


    MESSAGE_TYPE_USER(0,"点对点个人消息"),
    MESSAGE_TYPE_GROUP(1,"群消息（高级群）"),

    MESSAGE_CONTENT_TYPE_TEXT(0,"文本消息"),
    MESSAGE_CONTENT_TYPE_IMG(1,"图片消息"),
    MESSAGE_CONTENT_TYPE_VOICE(2,"语音消息"),
    MESSAGE_CONTENT_TYPE_VIDEO(3,"视频消息"),
    MESSAGE_CONTENT_TYPE_LOCAL(4,"地理位置信息消息"),
    MESSAGE_CONTENT_TYPE_FILE(6,"文件消息"),
    MESSAGE_CONTENT_TYPE_CUSTOM(100,"自定义消息类型");

    /* Code码 */
    private Integer code;

    /* 信息 */
    private String name;

    MessageTypeEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
