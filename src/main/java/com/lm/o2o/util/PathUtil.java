package com.lm.o2o.util;

/**
 * @author LuoMan
 */
public class PathUtil {
    private static String separator = System.getProperty("file.separator");

    static String getImgBasePath() {
        String os = System.getProperty("os.name");
        String basePath;
        if (os.toLowerCase().startsWith("win")) {
            basePath = "D:/projectDev/image/";
        } else {
            basePath = "/home/LuoMan/image/";
        }
        basePath = basePath.replace("/", separator);
        return basePath;
    }

    public static String getShopImagePath(long shopId) {
        String imagePath = "upload/item/shop/" + shopId + "/";
        return imagePath.replace("/", separator);
    }
}
