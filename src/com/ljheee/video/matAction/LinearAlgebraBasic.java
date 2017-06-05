package com.ljheee.video.matAction;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

public class LinearAlgebraBasic {
	static{System.loadLibrary(Core.NATIVE_LIBRARY_NAME);}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mat m1=new Mat(2,2,CvType.CV_32FC1);//2*2�ľ���m1��Ԫ��������1ͨ�������ͣ���Ϊ32λ��������float����
		m1.put(0, 0, new float[]{1,2,3,4});//Ϊm1����ֵ
		System.out.println("m1����Ϊ��"+m1.dump());
		System.out.println("m1��ת�þ���Ϊ��"+m1.t().dump());//m1.t()Ϊm1��ת�þ���
		System.out.println("m1�������Ϊ��"+m1.inv().dump());//m1.inv()Ϊm1�������
		Mat m2=new Mat();
		m2.push_back(m1);//��m1���������ֵ�ŵ�m2����ĺ���
		m2.push_back(m1);
		System.out.println("m2�ǽ�m1����������εĽ����"+m2.dump());
		
		Mat m3=Mat.eye(2, 2, CvType.CV_8UC1);//����2*2�ĵ�λ����
		Mat m4=Mat.ones(2, 2, CvType.CV_8UC1);//����2*2��ȫ1����
		Mat m5=Mat.zeros(2, 2, CvType.CV_8UC1);//����2*2��ȫ0����
		System.out.println("�����ĵ�λ����"+m3.dump());
		System.out.println("������ȫ1����"+m4.dump());
		System.out.println("������ȫ0����"+m5.dump());
	}

}
