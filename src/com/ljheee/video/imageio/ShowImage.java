package com.ljheee.video.imageio;

import java.awt.EventQueue;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

import com.ljheee.video.tool.mat2BufferedImage;


public class ShowImage {
	
	static{System.loadLibrary(Core.NATIVE_LIBRARY_NAME);}

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowImage window = new ShowImage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ShowImage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 800, 450);
		frame.getContentPane().add(label);
		
		Mat source=Imgcodecs.imread("F://lena.jpg");//加载lena图像为Mat格式
		BufferedImage image=mat2BufferedImage.matToBufferedImage(source);
		label.setIcon(new ImageIcon(image));
	}

}
