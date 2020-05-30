package com.aichu.common.util.common;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ImageUtil
 * @Description 群组微信九宫格头像插件
 * @Author Melon
 * @Date 2019/10/17 10:44
 * @Version 1.0.0
 **/
public class ImageUtil {

    /**
     * 图片的间隙
     */
    private static final int SIDE = 3;
    /**
     * 画板尺寸
     */
    private static final int CANVANS_W = 112;
    private static final int CANVANS_H = 112;

    /**
     * 尺寸1 （小）
     */
    private static final int ONE_IMAGE_SIZE = CANVANS_H - (2 * SIDE);
    /**
     * 尺寸2 （中）
     */
    private static final int TWO_IMAGE_SIZE = (CANVANS_H - (3 * SIDE)) / 2;
    /**
     * 尺寸3 （大）
     */
    private static final int FIVE_IMAGE_SIZE = (CANVANS_H - (4 * SIDE)) / 3;

    private ImageUtil() {
    }

    /***
     * @Author Melon
     * @Description 生成群组头像
     * @Date 11:36 2019/10/17
     * @Param [paths --图片链接, dir--输出路径, groupId--群编号]
     * @Return multipartFile
     **/
    public static MultipartFile getCombinationOfhead(List<String> paths, String groupId)
            throws IOException {
        List<BufferedImage> bufferedImages = new ArrayList<BufferedImage>();

        int imageSize = 0;
        if (paths.size() <= 1) {
            //若为一张图片
            imageSize = ONE_IMAGE_SIZE;
        } else if (paths.size() > 1 && paths.size() < 5) {
            //若为2-4张图片

            imageSize = TWO_IMAGE_SIZE;
        } else {
            //若>=5张图片
            imageSize = FIVE_IMAGE_SIZE;
        }

        for (int i = 0; i < paths.size(); i++) {
            BufferedImage resize2 = ImageUtil.resize2(paths.get(i), imageSize, imageSize, true);
            bufferedImages.add(resize2);
        }

        BufferedImage outImage = new BufferedImage(CANVANS_W, CANVANS_H, BufferedImage.TYPE_INT_RGB);

        // 生成画布
        Graphics g = outImage.getGraphics();

        Graphics2D g2d = (Graphics2D) g;

        // 设置背景色
        g2d.setBackground(new Color(238, 238, 238));

        // 通过使用当前绘图表面的背景色进行填充来清除指定的矩形。
        g2d.clearRect(0, 0, CANVANS_W, CANVANS_H);

        // 开始拼凑 根据图片的数量判断该生成那种样式的组合头像目前为九种

        for (int i = 1; i <= bufferedImages.size(); i++) {
            Integer size = bufferedImages.size();
            switch (size) {
                case 1:
                    g2d.drawImage(bufferedImages.get(i - 1), SIDE, SIDE, null);
                    break;
                case 2:
                    if (i == 1) {
                        g2d.drawImage(bufferedImages.get(i - 1), SIDE, (CANVANS_W - imageSize) / 2, null);
                    } else {
                        g2d.drawImage(bufferedImages.get(i - 1), 2 * SIDE + imageSize, (CANVANS_W - imageSize) / 2, null);
                    }
                    break;
                case 3:
                    if (i == 1) {
                        g2d.drawImage(bufferedImages.get(i - 1), (CANVANS_W - imageSize) / 2, SIDE, null);
                    } else {
                        g2d.drawImage(bufferedImages.get(i - 1), (i - 1) * SIDE + (i - 2) * imageSize, imageSize + (2 * SIDE), null);

                    }
                    break;
                case 4:

                    if (i <= 2) {
                        g2d.drawImage(bufferedImages.get(i - 1), i * SIDE + (i - 1) * imageSize, SIDE, null);

                    } else {
                        g2d.drawImage(bufferedImages.get(i - 1), (i - 2) * SIDE + (i - 3) * imageSize, imageSize + 2 * SIDE, null);

                    }
                    break;
                case 5:
                    if (i <= 2) {
                        g2d.drawImage(bufferedImages.get(i - 1), (CANVANS_W - 2 * imageSize - SIDE) / 2 + (i - 1) * imageSize + (i - 1) * SIDE, (CANVANS_W - 2 * imageSize - SIDE) / 2, null);

                    } else {
                        g2d.drawImage(bufferedImages.get(i - 1), (i - 2) * SIDE + (i - 3) * imageSize, ((CANVANS_W - 2 * imageSize - SIDE) / 2) + imageSize + SIDE, null);

                    }
//
                    break;
                case 6:
                    if (i <= 3) {
                        g2d.drawImage(bufferedImages.get(i - 1), SIDE * i + imageSize * (i - 1), (CANVANS_W - 2 * imageSize - SIDE) / 2, null);
                    } else {
                        g2d.drawImage(bufferedImages.get(i - 1), ((i - 3) * SIDE) + ((i - 4) * imageSize), ((CANVANS_W - 2 * imageSize - SIDE) / 2) + imageSize + SIDE, null);
                    }
                    break;
                case 7:
                    if (i <= 1) {
                        g2d.drawImage(bufferedImages.get(i - 1), 2 * SIDE + imageSize, SIDE, null);
                    }
                    if (i <= 4 && i > 1) {
                        g2d.drawImage(bufferedImages.get(i - 1), ((i - 1) * SIDE) + ((i - 2) * imageSize), 2 * SIDE + imageSize, null);
                    }
                    if (i <= 7 && i > 4) {
                        g2d.drawImage(bufferedImages.get(i - 1), ((i - 4) * SIDE) + ((i - 5) * imageSize), 3 * SIDE + 2 * imageSize, null);
                    }
                    break;
                case 8:
                    if (i <= 2) {
                        g2d.drawImage(bufferedImages.get(i - 1), (CANVANS_W - 2 * imageSize - SIDE) / 2 + (i - 1) * imageSize + (i - 1) * SIDE, SIDE, null);
                    }
                    if (i <= 5 && i > 2) {
                        g2d.drawImage(bufferedImages.get(i - 1), ((i - 2) * SIDE) + ((i - 3) * imageSize), 2 * SIDE + imageSize, null);
                    }
                    if (i <= 8 && i > 5) {
                        g2d.drawImage(bufferedImages.get(i - 1), ((i - 5) * SIDE) + ((i - 6) * imageSize), 3 * SIDE + 2 * imageSize, null);
                    }
                    break;
                case 9:
                    if (i <= 3) {
                        g2d.drawImage(bufferedImages.get(i - 1), (i * SIDE) + ((i - 1) * imageSize), SIDE, null);
                    }
                    if (i <= 6 && i > 3) {
                        g2d.drawImage(bufferedImages.get(i - 1), ((i - 3) * SIDE) + ((i - 4) * imageSize), 2 * SIDE + imageSize, null);
                    }
                    if (i <= 9 && i > 6) {
                        g2d.drawImage(bufferedImages.get(i - 1), ((i - 6) * SIDE) + ((i - 7) * imageSize), 3 * SIDE + 2 * imageSize, null);
                    }
                    break;
                default:
                    break;
            }
        }

        StringBuffer outPath = new StringBuffer()
                .append(new File("").getCanonicalPath() + "/rongCloud/group/image")
                .append(File.separatorChar)
                .append("GP-" + groupId).append(".jpg");

        String format = "JPG";
        File file = new File(outPath.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        ImageIO.write(outImage, format, file);

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
        MultipartFile multipartFile = new CommonsMultipartFile(item);

        //删除文件
        delFile(file.getPath(), file.getName());
        return multipartFile;
    }

    /***
     * @Author Melon
     * @Description 图片缩放
     * @Date 12:11 2019/10/17
     * @Param [filePath--图片路径, height--高度, width--宽度, bb--比例不对时是否需要补白]
     * @Return java.awt.image.BufferedImage
     **/
    public static BufferedImage resize2(String filePath, int height, int width,
                                        boolean bb) {
        try {
            double ratio = 0; // 缩放比例
            BufferedImage bi = null;
            if (filePath.indexOf("http://") == 0) {
                bi = ImageIO.read(new URL(filePath));
            } else {
                bi = ImageIO.read(new File(filePath));
            }
            Image itemp = bi.getScaledInstance(width, height,
                    Image.SCALE_SMOOTH);
            // 计算比例
            if ((bi.getHeight() > height) || (bi.getWidth() > width)) {
                if (bi.getHeight() > bi.getWidth()) {
                    ratio = (new Integer(height)).doubleValue()
                            / bi.getHeight();
                } else {
                    ratio = (new Integer(width)).doubleValue() / bi.getWidth();
                }
                AffineTransformOp op = new AffineTransformOp(
                        AffineTransform.getScaleInstance(ratio, ratio), null);
                itemp = op.filter(bi, null);
            }
            if (bb) {
                BufferedImage image = new BufferedImage(width, height,
                        BufferedImage.TYPE_INT_RGB);
                Graphics2D g = image.createGraphics();
                g.setColor(Color.white);
                g.fillRect(0, 0, width, height);
                if (width == itemp.getWidth(null)) {
                    g.drawImage(itemp, 0, (height - itemp.getHeight(null)) / 2,
                            itemp.getWidth(null), itemp.getHeight(null),
                            Color.white, null);
                } else {
                    g.drawImage(itemp, (width - itemp.getWidth(null)) / 2, 0,
                            itemp.getWidth(null), itemp.getHeight(null),
                            Color.white, null);
                }
                g.dispose();
                itemp = image;
            }
            return (BufferedImage) itemp;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /***
     * @Author Melon
     * @Description 删除文件
     * @Date 12:12 2019/10/17
     * @Param [path, filename]
     * @Return void
     **/
    public static void delFile(String path, String filename) {
        File file = new File(path + "/" + filename);

        if (file.exists() && file.isFile()) {
            file.delete();
        }
    }

    /**
     * 可依次生成九种情况的群头像
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Integer groupId = 0;
        for (int i = 1; i < 10; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                //本地图片路径或者网络图片路径
                list.add("http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKycDpBjeJZdPaZgU2W7puBGBQbS4kHrWADjDzmvmicPibiaObCNqumJHdsXAqQDM4zYFrpibK2nlGOsg/132");
            }
            File file = new File("");
            //生成目录
            String path = file.getCanonicalPath() + "/src/main/webapp/temp/";
            groupId++;
            ImageUtil.getCombinationOfhead(list, groupId.toString());
        }
    }
}