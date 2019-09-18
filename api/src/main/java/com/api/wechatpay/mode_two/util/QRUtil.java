package com.api.wechatpay.mode_two.util;

import com.google.zxing.common.BitMatrix;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 二唯码工具类
 */
public class QRUtil {
    private static final int BLACK = 0xFF000000;
    private static final int WHITE = 0xFFFFFFFF;

    public QRUtil() {
    }

    public static void writeToStream(BitMatrix bitMatrix, String format, OutputStream stream) {
        try {
            BufferedImage image = toBufferedImage(bitMatrix);
            if (!ImageIO.write(image, format, stream)) {
                throw new IOException("无法写入图片格式：" + format);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static BufferedImage toBufferedImage(BitMatrix bitMatrix) {
        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                image.setRGB(i, j, bitMatrix.get(i, j) ? BLACK : WHITE);
            }
        }
        return image;
    }

    public static void writeToFile(BitMatrix bitMatrix, String format, File file){
        BufferedImage image = toBufferedImage(bitMatrix);
        try {
            if (!ImageIO.write(image, format, file)){
                throw new IOException("格式图片："+format+" 无法写入到 "+file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
