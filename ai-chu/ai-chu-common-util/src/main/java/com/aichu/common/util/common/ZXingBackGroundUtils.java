package com.aichu.common.util.common;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @ClassName ZXingBackGroundUtils
 * @Author yuan.shuai
 * @Description 带LOGO的二维码生成工具
 * @Date 2019/11/2
 * @Version 1.0.0
 */
public class ZXingBackGroundUtils {
    private static final int QRCOLOR = 0xFF000000; // 默认是黑色
    private static final int BGWHITE = 0xFFFFFFFF; // 背景颜色

    private static final int WIDTH = 600; // 二维码宽
    private static final int HEIGHT = 600; // 二维码高

    // 用于设置QR二维码参数
    private static Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>() {
        private static final long serialVersionUID = 1L;

        {
            put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);// 设置QR二维码的纠错级别（H为最高级别）具体级别信息
            put(EncodeHintType.CHARACTER_SET, "utf-8");// 设置编码方式
            put(EncodeHintType.MARGIN, 0);
        }
    };


    // 生成带logo的二维码图片
    /***
     *@param logoFile  logo图地址
     * @param qrUrl 扫描二维码方位地址
     * */
    public static String drawLogoQRCode(BufferedImage logoFile, String qrUrl) {
        String shareUrl = "https://ih5.wenzuxz.com/groupShare?groupId=" + qrUrl;
        String smallFilePath = "";
        try {
            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
            // 参数顺序分别为：编码内容，编码类型，生成图片宽度，生成图片高度，设置参数
            BitMatrix bm = multiFormatWriter.encode(shareUrl, BarcodeFormat.QR_CODE, WIDTH, HEIGHT, hints);
            BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

            // 开始利用二维码数据创建Bitmap图片，分别设为黑（0xFFFFFFFF）白（0xFF000000）两色
            for (int x = 0; x < WIDTH; x++) {
                for (int y = 0; y < HEIGHT; y++) {
                    image.setRGB(x, y, bm.get(x, y) ? QRCOLOR : BGWHITE);
                }
            }

            int width = image.getWidth();
            int height = image.getHeight();
            if (Objects.nonNull(logoFile)) {
                // 构建绘图对象
                Graphics2D g = image.createGraphics();
                // 开始绘制logo图片
                g.drawImage(logoFile, width * 2 / 5, height * 2 / 5, width * 2 / 10, height * 2 / 10, null);
                g.dispose();
                logoFile.flush();
            }

            image.flush();

            StringBuffer outPath = new StringBuffer()
                    .append(new File("").getCanonicalPath() + "/rongCloudGroup/qrCode/image")
                    .append(File.separatorChar)
                    .append("GP-" + qrUrl).append(".jpg");

            String format = "png";
            File file = new File(outPath.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            ImageIO.write(image, format, file);

            smallFilePath = file.getPath();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return smallFilePath;
    }

    public static void main(String[] args) throws  Exception {
        /*String files = "http://wenzu.oss-cn-shenzhen.aliyuncs.com/rongYun/rongYun1572073498657.jpg?Expires=1887433489&OSSAccessKeyId=LTAIw6NezbDnPNKz&Signature=jZAOMF00GWI3r08rvWVKOZl49FI%3D";
        BufferedImage big;
        if (files.contains("http://") || files.contains("https://")) {
            URL url = new URL(files);
            big = ImageIO.read(url);
        } else {
            big = ImageIO.read(new File(files));
        }
        String smallFilePath = drawLogoQRCode(big, "WZG890319042001");
        MultipartFile multipartFile = mergeImage(backgroundImgUrl, smallFilePath, "265", "630", "何一、何三、何二(3)", "WZG890319042001");
        System.out.println(multipartFile.getName());*/
    }

    /**
     * @Description
     * @Param backgroundImgUrl 背景图片
     * @Param groupImgUrl 群头像
     * @Param groupId 群ID
     * @Param groupName 群名称
     * @Return MultipartFile
     * @Author yuan.shuai
     * @Date  2019/11/2
     * @Version 1.0.0
     */
    public static MultipartFile getQRcodeShareImg(String backgroundImgUrl,String groupImgUrl,String groupId,String groupName) throws Exception{
        // 群头像
        BufferedImage big;
        if (groupImgUrl.contains("http://") || groupImgUrl.contains("https://")) {
            URL url = new URL(groupImgUrl);
            big = ImageIO.read(url);
        } else {
            big = ImageIO.read(new File(groupImgUrl));
        }
        // 生成二维码地址
        String smallFilePath = drawLogoQRCode(big, groupId);
        // 合并二维码和背景图
        MultipartFile multipartFile = mergeImage(backgroundImgUrl, smallFilePath, "265", "630", interceptingGroupName(groupName), groupId);
        return multipartFile;
    }

    /**
     * @Description 二维码嵌套背景图的方法
     * @param bigPath 背景图 - 可传网络地址
     * @param smallPath 二维码地址 - 可传网络地址
     * @param  x 二维码x坐标
     * @param  y 二维码y坐标
     * @param  text 二维码描述文本
     * @Return
     * @Author yuan.shuai
     * @Date  2019/11/2
     * @Version 1.0.0
     */
    public static MultipartFile mergeImage(String bigPath, String smallPath, String x, String y, String text, String groupId) throws IOException {

        MultipartFile multipartFile = null;
        try {
            BufferedImage small;
            BufferedImage big;
            if (bigPath.contains("http://") || bigPath.contains("https://")) {
                URL url = new URL(bigPath);
                big = ImageIO.read(url);
            } else {
                big = ImageIO.read(new File(bigPath));
            }


            if (smallPath.contains("http://") || smallPath.contains("https://")) {
                URL url = new URL(smallPath);
                small = ImageIO.read(url);
            } else {
                small = ImageIO.read(new File(smallPath));
            }

            Graphics2D g = big.createGraphics();

            float fx = Float.parseFloat(x);
            float fy = Float.parseFloat(y);
            int x_i = (int) fx;
            int y_i = (int) fy;

            g.drawImage(small, x_i, y_i, small.getWidth(), small.getHeight(), null);

            Font font1 = new Font("微软雅黑", Font.BOLD, 40);// 添加字体的属性设置
            g.setFont(font1);
            Color color1 = new Color(29, 100, 38);
            g.setColor(color1);
            g.drawString(text,400,550);
            g.dispose();
            //ImageIO.write(big, "png", new File(newFilePath));

            StringBuffer outPath = new StringBuffer()
                    .append(new File("").getCanonicalPath() + "/RongCloudGroupShare/share/image")
                    .append(File.separatorChar)
                    .append("GP-" + groupId).append(".jpg");

            String format = "png";
            File file = new File(outPath.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            ImageIO.write(big, format, file);

            FileItemFactory factory = new DiskFileItemFactory(16, null);
            String textFieldName = "textField";
            FileItem item = factory.createItem(textFieldName, "text/plain", true, file.getName());
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            try {
                FileInputStream fis = new FileInputStream(file.getPath());
                OutputStream os = item.getOutputStream();
                while ((bytesRead = fis.read(buffer, 0, 8192)) != -1) {
                    os.write(buffer, 0, bytesRead);
                }
                os.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            multipartFile = new CommonsMultipartFile(item);

            //删除生成分享页文件
            ImageUtil.delFile(file.getPath(), file.getName());

            //删除生成二维码文件
            ImageUtil.delFile(new File(smallPath).getPath(), new File(smallPath).getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return multipartFile;
    }

    /**
     * @Description 处理群名称太长
     * @Param groupName
     * @Return String
     * @Author yuan.shuai
     * @Date  2019/11/2
     * @Version 1.0.0
     */
    private static String interceptingGroupName(String groupName) throws Exception{
        if (Objects.nonNull(groupName) && !Objects.equals(groupName,"")){
            groupName = groupName.replaceAll("\\(\\d\\)","");
            if (groupName.length() > 10){
                groupName = groupName.substring(0,9)+"...";
            }
        }
        return groupName;
    }
}
