package com.opencv.simpleopencvsample.image;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

/**
 * @Author: nya
 * @Description:
 * @Date: Created in 15:43 2018/9/19
 * @Modify by:
 */
public class ReadAndWrite {

    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public static void main(String[] args) {
        Mat mat = Imgcodecs.imread("F:\\opencv-1\\1.jpg",Imgcodecs.CV_LOAD_IMAGE_GRAYSCALE);
        System.out.println("height : " + mat.height() + " width:" + mat.width() + " channels : " + mat.channels());
        System.out.println("-----------------------");
        int cols = mat.cols();
        int rows = mat.rows();
        System.out.println(mat.dump());
//        byte[] bytePixels = new byte[cols * rows];
//        mat.get(0,0,bytePixels);
//        int[] pixels = new int[bytePixels.length];
//        for (int i = 0 ; i < pixels.length; i++) {
//            System.out.println(i);
//            byte bytePixel = bytePixels[i];
//            System.out.println(bytePixel);
//            int item = bytePixel & 0xff;
//            pixels[i] = item;
//            System.out.println(item);
//            System.out.println("--------------------");
//        }

    }
}
