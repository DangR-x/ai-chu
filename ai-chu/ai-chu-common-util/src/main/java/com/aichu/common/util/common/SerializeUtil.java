package com.aichu.common.util.common;

import java.io.*;

/**
 * @ClassName SerializeUtil
 * @Author yuan.shuai
 * @Description 序列化工具
 * @Date 2019/8/28
 * @Version 1.0.0
 */
public class SerializeUtil {

    /**
     * @Description 序列化
     * @Param Object
     * @Return byte[]
     * @Author yuan.shuai
     * @Date  2019/8/28
     * @Version 1.0.0
     */
    public static byte[] serialize(Object obj) {
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        try {
            // 序列化
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);
            byte[] byteArray = baos.toByteArray();
            return byteArray;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @Description 反序列化
     * @Param byte
     * @Return Object
     * @Author yuan.shuai
     * @Date  2019/8/28
     * @Version 1.0.0
     */
    public static Object unSerialize(byte[] bytes) {
        ByteArrayInputStream bais = null;
        try {
            // 反序列化为对象
            bais = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
