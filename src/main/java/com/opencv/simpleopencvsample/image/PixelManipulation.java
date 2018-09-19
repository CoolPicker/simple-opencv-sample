package com.opencv.simpleopencvsample.image;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;

/**
 * @Author: nya
 * @Description: 像素操作
 * @Date: Created in 17:52 2018/9/19
 * @Modify by:
 */
public class PixelManipulation {
    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public static void main(String[] args) {
        // 三通道 字节数组{1,2,3} 1-blue 2-green 3-red
        Mat image = new Mat(new Size(3,3), CvType.CV_8UC3);
        for (int i = 0 ; i < image.rows() ; i++) {
            for (int j = 0 ; j < image.cols() ; j++) {
                image.put(i,j,new byte[]{1,2,3});
            }
        }
        System.out.println(image.dump());

        // 获取任一像素 ， 并将蓝色通道像素值置为0
        int totalBytes = (int) (image.total() * image.elemSize()) ;
        byte[] bytePixels = new byte[totalBytes];
        image.get(0,0,bytePixels);
        for (int i = 0 ; i < totalBytes ; i++) {
            if (i % 3 == 0) bytePixels[i] = 0 ;
        }
        image.put(0,0,bytePixels);
        System.out.println(image.dump());

        // 以实际图片测试 ， 去除绿色
        Mat test = Imgcodecs.imread("F:\\opencv-1\\1.jpg",Imgcodecs.CV_LOAD_IMAGE_COLOR);
        int total = (int) (test.total() * test.elemSize()) ;
        byte[] buffer = new byte[total];
        test.get(0,0,buffer);
        for (int i = 0 ; i < total ; i++) {
            if (i % 3 == 2 ) buffer[i] = 0 ;
        }
        test.put(0,0,buffer);
        System.out.println(buffer.length);
        Imgcodecs.imwrite("F:\\opencv-1\\1-filterRed.jpg",test);
    }
}
