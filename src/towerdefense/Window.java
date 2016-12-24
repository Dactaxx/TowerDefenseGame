package towerdefense;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Window {
	public static JFrame frame = new JFrame("Tower Defense");
	public static int width, height, nativeWidth, nativeHeight;
	public static double scale;
	
	public static void createWindow() {
		Window.nativeWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		Window.nativeHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

		double aspectRatio = (double)nativeWidth / (double)nativeHeight;
		if(aspectRatio < 1920d/1080d) {
			Window.height = (int)((double)Window.nativeWidth / (1920d/1080d));
			Window.width = nativeWidth;
		} else if(aspectRatio > 1920d/1080d) {
			Window.width = (int)((double)Window.nativeHeight * (1920d/1080d));
			Window.height = nativeHeight;
		}
		
		System.out.println(width);
		System.out.println(height);
		
		scale = (double)width / 1920;
		
		frame.setUndecorated(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		TowerMain towermain = new TowerMain();
		frame.add(towermain);
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		gd.setFullScreenWindow(frame);
		frame.setVisible(true);
		
	}
	
}
