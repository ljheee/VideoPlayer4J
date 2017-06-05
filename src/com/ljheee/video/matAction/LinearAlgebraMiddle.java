package com.ljheee.video.matAction;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

public class LinearAlgebraMiddle {
	static{System.loadLibrary(Core.NATIVE_LIBRARY_NAME);}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mat m1=new Mat(2,2,CvType.CV_32FC1);//m1����2��2�У�Ԫ������float
		m1.put(0, 0, new float[]{1,2,3,4});
		
		Mat m2=m1.clone();//����m1��m2��m2��m1һ��
		
		System.out.println("����m1:"+m1.dump());
		System.out.println("����m2:"+m2.dump());
		
		//����ӷ�
		Mat m3=new Mat();
		Core.add(m1, m2, m3);//m1��m2��ӣ�����m3
		System.out.println("m1��m2��ӣ�"+m3.dump());
		
		//�������
		Mat m4=new Mat();
		Core.subtract(m1, m2, m4);//m1��m2���������m4
		System.out.println("m1��m2�����"+m4.dump());
		
		//����˷�
		Mat m5=new Mat();
		Core.gemm(m1, m2, 1, new Mat(), 0, m5);
		System.out.println("m1��m2��ˣ�"+m5.dump());
	}

}
