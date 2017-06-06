package com.ljheee.video.imageio;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

import com.ljheee.video.tool.mat2BufferedImage;

import javafx.scene.layout.Border;

public class TestUI {
	
	
	static{
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	}

	private JFrame frame;
	private static JLabel lblNewLabel;
	static boolean isPause = false;
	static VideoCapture capture;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestUI window = new TestUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		
		
		//我们的操作
		capture=new VideoCapture("D:/迅雷下载/喜h你_bd.mp4");//读取视频
		if (!capture.isOpened()) {
			System.out.println("Error");
		} else {
			
			//总帧数
			double frameCount = capture.get(opencv_highgui.CV_CAP_PROP_FRAME_COUNT);
			System.out.println("视频总帧数:"+frameCount);
			
			Mat webcam_image = new Mat();
			capture.read(webcam_image);
			
			while (!isPause) {
				capture.read(webcam_image);
				if( !webcam_image.empty() ){
					BufferedImage b=mat2BufferedImage.matToBufferedImage(webcam_image);
					lblNewLabel.setIcon(new ImageIcon(b));
				}else{
					System.out.println("视频已结束!");  
			           capture.release();
			           break;  
				}
				
			}
		}
	}

	/**
	 * Create the application.
	 */
	public TestUI() {
		initialize();
	}

	JButton btnPause;
	JButton btnStart;
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 900, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel();
		lblNewLabel.setBounds(0, 0, 900, 700);
		frame.add(lblNewLabel);
		
		btnPause = new JButton("btnPause");
		btnStart = new JButton("btnStart");
		JLabel jlLabel = new JLabel();
		JPanel jpPanel = new JPanel();
		jpPanel.add(jlLabel);
		jpPanel.add(btnPause);
		jpPanel.add(btnStart);
		
		frame.add(jpPanel, BorderLayout.SOUTH);
		
		
		
	}

	
	class VideoHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(btnPause == e.getSource()){
				isPause = true;
			} else if(btnStart == e.getSource()){
				if(isPause = true){
					isPause = false;
				}
			}
			
		}
		
	}
	
}
