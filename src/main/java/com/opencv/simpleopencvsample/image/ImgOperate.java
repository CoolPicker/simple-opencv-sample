package com.opencv.simpleopencvsample.image;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

/**
 * @Author: nya
 * @Description:
 * @Date: Created in 10:27 2018/9/21
 * @Modify by:
 */
public class ImgOperate {
    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public static void main(String[] args) {
        // String path = "F:\\opencv-1\\1.jpg"; 绝对路径下的图片path
        String path = "src/main/java/com/opencv/simpleopencvsample/sample/1.jpg"; // 项目相对路径下的图片path
        Mat openFile = null;
        try {
            openFile = openFile(path);
            Mat clone = openFile.clone();
            System.out.println(openFile);
            Imgproc.resize(openFile,clone,new Size(640,480));
            System.out.println(clone);
            ImageViewer imageViewer = new ImageViewer();
            imageViewer.show(clone,"Loaded image");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // comment ： never forget to release the matrix
            if (openFile != null ) {
                openFile.release();
            }
        }
        System.out.println(openFile);
    }

    public static Mat openFile(String path) throws Exception {
        // imread 将本地文件转成matrix矩阵 param1-path,param2-img type
        Mat image = Imgcodecs.imread(path,Imgcodecs.CV_LOAD_IMAGE_COLOR);
        if (image.dataAddr() == 0) {
            throw new Exception("could not open the path" + path);
        }
        return image;
    }
}
