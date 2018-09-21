package com.opencv.simpleopencvsample.image;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;

import javax.swing.*;
import java.awt.*;

/**
 * @Author: nya
 * @Description: 视频捕获相关操作类VideoCapture使用
 * @Date: Created in 13:50 2018/9/21
 * @Modify by:
 */
public class VideoCaptureSample {
    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }
    private JFrame frame;
    private JLabel imageLabel;

    public static void main(String[] args) {
        VideoCaptureSample sample = new VideoCaptureSample();
        sample.initGUI();
        sample.runMainLoop();
    }

    private void initGUI(){
        frame = new JFrame("Camera Input Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(555,970);
        imageLabel = new JLabel();
        frame.add(imageLabel);
        frame.setVisible(true);
    }

    private void runMainLoop() {
        ImageViewer viewer = new ImageViewer();
        Mat webcamMatImage = new Mat();
        Image tempImage;
        VideoCapture capture = new VideoCapture("src/main/java/com/opencv/simpleopencvsample/sample/1.mp4");
        capture.set(Videoio.CAP_PROP_FRAME_WIDTH,550);
        capture.set(Videoio.CAP_PROP_FRAME_HEIGHT,960);
        int i = 0 ;
        double frameCount = capture.get(Videoio.CAP_PROP_FRAME_COUNT);// 总帧数
        double fps = capture.get(Videoio.CV_CAP_PROP_FPS); // 帧率
        double time = frameCount / fps; // 获取视频总时长
        System.out.println(time);
        double interval = 1000.0 / fps;
        System.out.println(interval); // 获取帧间隔
        if (capture.isOpened()) {
            while (true) {
                capture.read(webcamMatImage);
                if (!webcamMatImage.empty()) {
                    i++;
                    try {
                        tempImage = viewer.toBufferedImage(webcamMatImage);
                        ImageIcon imageIcon = new ImageIcon(tempImage,"Captured video");
                        imageLabel.setIcon(imageIcon);
                        frame.pack();
                        Thread.sleep((long)interval);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("mat count : " + i + " --- Frame not captured -- Break !");
                    break;
                }
            }
        } else {
            System.out.println("Couldn't open capture.");
        }
    }
}
