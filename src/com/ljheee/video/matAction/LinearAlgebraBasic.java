package com.ljheee.video.matAction;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

public class LinearAlgebraBasic {
	static{System.loadLibrary(Core.NATIVE_LIBRARY_NAME);}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mat m1=new Mat(2,2,CvType.CV_32FC1);//2*2的矩阵m1，元素类型是1通道浮点型，因为32位，所以是float类型
		m1.put(0, 0, new float[]{1,2,3,4});//为m1矩阵赋值
		System.out.println("m1矩阵为："+m1.dump());
		System.out.println("m1的转置矩阵为："+m1.t().dump());//m1.t()为m1的转置矩阵
		System.out.println("m1的逆矩阵为："+m1.inv().dump());//m1.inv()为m1的逆矩阵
		Mat m2=new Mat();
		m2.push_back(m1);//将m1矩阵的所有值放到m2矩阵的后面
		m2.push_back(m1);
		System.out.println("m2是将m1放置其后两次的结果："+m2.dump());
		
		Mat m3=Mat.eye(2, 2, CvType.CV_8UC1);//创建2*2的单位矩阵
		Mat m4=Mat.ones(2, 2, CvType.CV_8UC1);//创建2*2的全1矩阵
		Mat m5=Mat.zeros(2, 2, CvType.CV_8UC1);//创建2*2的全0矩阵
		System.out.println("创建的单位矩阵："+m3.dump());
		System.out.println("创建的全1矩阵："+m4.dump());
		System.out.println("创建的全0矩阵："+m5.dump());
	}

}
