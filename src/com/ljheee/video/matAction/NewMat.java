package com.ljheee.video.matAction;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

public class NewMat {
	
	static{System.loadLibrary(Core.NATIVE_LIBRARY_NAME);}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Mat���󴴽�
		Mat m=new Mat(4,3,CvType.CV_8UC1);//3��3�У�����Ԫ�����ͣ�1��ͨ����8λ�޷��ţ�
		m.put(0, 0, new byte[]{1,2,3,4,5,6,7,8,9,10,11,12});//��0��0�п�ʼ���þ�����ÿ��Ԫ�ص�ֵ
		System.out.println("�����������"+m.rows());
		System.out.println("�����������"+m.cols());
		System.out.println("�����Ԫ�ظ�����"+m.total());
		System.out.println("�����Size��"+m.size());
		System.out.println("�����1�е�2�е�Ԫ��ֵΪ��"+m.get(0, 1)[0]);
		System.out.println(m.dump());//��������
	}

}
