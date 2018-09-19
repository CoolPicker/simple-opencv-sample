package com.opencv.simpleopencvsample.image;

import org.opencv.core.*;

/**
 * @Author: nya
 * @Description: Mat 矩阵 及 相关认知操作
 * @Date: Created in 15:11 2018/9/19
 * @Modify by:
 */
public class MatSample {

    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public static void main(String[] args) {
        System.out.println("Welcome to OpenCv " + Core.VERSION);
        Mat mat = new Mat(5,10, CvType.CV_8UC1,new Scalar(0));
        // CvType : 矩阵 ， 像素大小 8 - 0-255 U 无符号整数 S 有符号整数 F 浮点数 C 通道数
        System.out.println("OpenCv mat : " + mat);
        Mat mr1 = mat.row(1);
        mr1.setTo(new Scalar(1));
        Mat mc5 = mat.col(5);
        mc5.setTo(new Scalar(5));
        System.out.println("OpenCV Mat data:\n" + mat.dump());

        System.out.println("---------------------------");

        Mat image2 = new Mat(480,640,CvType.CV_8UC3);
        Mat image3 = new Mat(new Size(640,480),CvType.CV_8UC3);
        System.out.println(image2 + "rows " + image2.rows() + " cols " +
                image2.cols() + " elementsize " + image2.elemSize());
        System.out.println(image3 + "rows " + image3.rows() + " cols " +
                image3.cols() + " elementsize " + image3.elemSize());

        Mat image = new Mat(new Size(3,3),CvType.CV_8UC3,new Scalar(new double[]{128,3,4}));
        System.out.println(image);
        String dump = image.dump(); // 获取 mat 矩阵对应的数据集
        System.out.println(dump);
    }

}
