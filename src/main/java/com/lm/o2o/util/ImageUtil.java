package com.lm.o2o.util;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 图片工具类
 *
 * @author LuoMan
 */
public class ImageUtil {
    private static String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final Random RANDOM = new Random();

    public static String generateThumbnail(InputStream thumbnail, String fileName, String targetAddr) {
        System.out.println(basePath);
        String realFileName = getRandomFileName();
        String extension = getFileExtension(fileName);
        makeDirPath(targetAddr);
        String relativeAddr = targetAddr + realFileName + extension;
        File dest = new File(PathUtil.getImgBasePath() + relativeAddr);
        try {
            Thumbnails.of(thumbnail).size(200, 200).watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(new File(basePath) + "/watermark.png")), 0.25f).outputQuality(0.8f).toFile(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return relativeAddr;
    }

    /**
     * 创建目标路径所涉及到的目录，即/home/work/../xx.jpg
     *
     * @param targetAddr 真实文件地址
     */
    private static void makeDirPath(String targetAddr) {
        String realFileParentPath = PathUtil.getImgBasePath() + targetAddr;
        File dirPath = new File(realFileParentPath);
        if (!dirPath.exists()) {
            dirPath.mkdirs();
        }
    }

    /**
     * 获取输入文件流的扩展名
     *
     * @return 返回扩展名
     */
    private static String getFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    /**
     * 生成随机文件名，当前年月日小时分钟秒+五位随机数
     *
     * @return 随机出的字符串
     */
    private static String getRandomFileName() {
        //获取随机的五位数
        int ranNum = RANDOM.nextInt(89999) + 10000;
        synchronized (SIMPLE_DATE_FORMAT) {
            String nowTimeStr = SIMPLE_DATE_FORMAT.format(new Date());
            return nowTimeStr + ranNum;
        }
    }

    public static void main(String[] args) throws IOException {

        System.out.println(basePath);
        Thumbnails.of(new File(basePath + "1.png")).size(200, 200).watermark(Positions.BOTTOM_RIGHT, ImageIO.read(new File(basePath + "1.png")), 0.25f).outputQuality(0.8f).toFile(basePath + "2.png");
    }
}
