package com.ljheee.videotest;

import java.awt.Dimension;
import java.awt.image.BufferedImage;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;
/**
 *
 * 支持AVI, MPEG,DIVX格式的文件
 * Xvid（旧称为DIVX）是一个开放源代码的MPEG-4视频编解码器
 * 
 * ffdshow是一套免费的编解码软件，可支持H.264、FLV、WMV、MPEG-1、MPEG-2以及MPEG-4等格式视频档。ffdshow本身并不包含器媒体播放，但各种媒体播放器都可以使用ffdshow进行解码
 * Bug:播放字幕是反的
 */
public class VideoDemo {

    public static void main(String[] args) {
    	
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        // 打开摄像头或者视频文件
        VideoCapture capture = new VideoCapture();
        //capture.open(0);
//        capture.open("D:/vcprojects/images/768x576.avi");
        capture.open("D:/迅雷下载/喜h你_bd.mp4");
        if(!capture.isOpened()) {
            System.out.println("could not load video data...");
            return;
        }
        
        int frame_width = (int)capture.get(3);
        int frame_height = (int)capture.get(4);
        ImageGUI gui = new ImageGUI();
        gui.createWin("OpenCV + Java视频读与播放演示", new Dimension(frame_width, frame_height));
        Mat frame = new Mat();
        while(true) {
            boolean have = capture.read(frame);
            Core.flip(frame, frame, 1);// Win上摄像头
            if(!have) break;
            if(!frame.empty()) {
                gui.imshow(conver2Image(frame));
                gui.repaint();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static BufferedImage conver2Image(Mat mat) {
        int width = mat.cols();
        int height = mat.rows();
        int dims = mat.channels();
        int[] pixels = new int[width*height];
        byte[] rgbdata = new byte[width*height*dims];
        mat.get(0, 0, rgbdata);
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        int index = 0;
        int r=0, g=0, b=0;
        for(int row=0; row<height; row++) {
            for(int col=0; col<width; col++) {
                if(dims == 3) {
                    index = row*width*dims + col*dims;
                    b = rgbdata[index]&0xff;
                    g = rgbdata[index+1]&0xff;
                    r = rgbdata[index+2]&0xff;
                    pixels[row*width+col] = ((255&0xff)<<24) | ((r&0xff)<<16) | ((g&0xff)<<8) | b&0xff; 
                }
                if(dims == 1) {
                    index = row*width + col;
                    b = rgbdata[index]&0xff;
                    pixels[row*width+col] = ((255&0xff)<<24) | ((b&0xff)<<16) | ((b&0xff)<<8) | b&0xff; 
                }
            }
        }
        setRGB( image, 0, 0, width, height, pixels);
        return image;
    }

    /**
     * A convenience method for setting ARGB pixels in an image. This tries to avoid the performance
     * penalty of BufferedImage.setRGB unmanaging the image.
     */
    public static void setRGB( BufferedImage image, int x, int y, int width, int height, int[] pixels ) {
        int type = image.getType();
        if ( type == BufferedImage.TYPE_INT_ARGB || type == BufferedImage.TYPE_INT_RGB )
            image.getRaster().setDataElements( x, y, width, height, pixels );
        else
            image.setRGB( x, y, width, height, pixels, 0, width );
    }

}
