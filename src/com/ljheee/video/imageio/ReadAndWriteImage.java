package com.ljheee.video.imageio;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class ReadAndWriteImage {
	static{System.loadLibrary(Core.NATIVE_LIBRARY_NAME);}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mat source=Imgcodecs.imread("F://7.png");//读取图像，参数为图像的存储路径
		System.out.println("channels="+source.channels());//灰度图=1，RGB=3
		Imgcodecs.imwrite("F://777.png", source);//存储图像，参数1为要存储的路径，参数2为要存储的Mat对象
	}

}
