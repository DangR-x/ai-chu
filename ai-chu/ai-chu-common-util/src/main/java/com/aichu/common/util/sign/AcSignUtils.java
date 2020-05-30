package com.aichu.common.util.sign;

/**
 * @ClassName AcSignUtils
 * @Description 爱触项目系统签名生成规则Utils
 * @Author Melon
 * @Date 2019/7/23 10:23
 * @Version 1.0.0
 **/
public class AcSignUtils {

    /***
     * @Author Melon
     * @Description 生成AC系统内部唯一识别ID（23位字符串）
     * 生成规则： AC（2位） + 时间戳（13位） + 随机数（8）
     * @Date 10:30 2019/7/23
     * @Param []
     * @Return java.lang.Strings
     **/
    public static String systemAcUID() {

        byte[] lock = new byte[0];
        // 位数，默认是8位
        long randomNum = 100000000;

        long rand = 0;
        synchronized (lock) {
            rand = (long) ((Math.random() + 1) * randomNum);
        }

        //时间戳
        long timer = System.currentTimeMillis();
        String timeStr = String.valueOf(timer).substring(String.valueOf(timer).length() - 5, String.valueOf(timer).length());

        return "AC" + timeStr + String.valueOf(rand).substring(1);
    }
    
    /***
     * @Author Melon
     * @Description 生成AC系统内部唯一识别ID（23位字符串）
     * 生成规则： ACG（2位） + 时间戳（13位） + 随机数（7）
     * @Date 16:25 2019/8/17
     * @Param []
     * @Return java.lang.String
     **/
    public static String systemAcGroupUID() {

        byte[] lock = new byte[0];
        // 位数，默认是7位
        long randomNum = 10000000;

        long rand = 0;
        synchronized (lock) {
            rand = (long) ((Math.random() + 1) * randomNum);
        }

        //时间戳
        long timer = System.currentTimeMillis();
        String timeStr = String.valueOf(timer).substring(String.valueOf(timer).length() - 5, String.valueOf(timer).length());

        return "ACG" + timeStr + String.valueOf(rand).substring(1);
    }

    /***
     * @Author Melon
     * @Description 爱触系统订单号生成(25位)
     * 生成规则： ACTN（4位）+ 时间戳（13位） + 随机数（8）
     * @Date 18:20 2019/9/2
     * @Param []
     * @Return java.lang.String
     **/
    public static String systemAcOrderNo() {

        byte[] lock = new byte[0];
        // 位数，默认是8位
        long randomNum = 100000000;

        long rand = 0;
        synchronized (lock) {
            rand = (long) ((Math.random() + 1) * randomNum);
        }

        //时间戳
        long timer = System.currentTimeMillis();
        String timeStr = String.valueOf(timer).substring(String.valueOf(timer).length() - 5, String.valueOf(timer).length());

        return "ACTN" + timeStr + String.valueOf(rand).substring(1);
    }
}
