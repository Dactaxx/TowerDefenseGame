package towerdefense;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Window {
	public static JFrame frame = new JFrame("Tower Defense");
	public static int width, height;
	public static double scale;
	
	public static void createWindow() {
		Window.width = Toolkit.getDefaultToolkit().getScreenSize().width;
		Window.height = Toolkit.getDefaultToolkit().getScreenSize().height;

		double aspectRatio = (double)width / (double)height;
		if(aspectRatio < 1920d/1080d) {
			Window.height = (int)((double)Window.width / (1920d/1080d));
		} else if(aspectRatio > 1920d/1080d) {
			Window.width = (int)((double)Window.height * (1920d/1080d));
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
