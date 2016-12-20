package towers;

import static towerdefense.TowerMain.paused;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;

import towerdefense.TowerMain;

public class TowerControl implements Runnable {
	public static LinkedList<towers.Tower> towerlist = new LinkedList<towers.Tower>();
	public static BufferedImage towerBase;
	
	public static void init() {
		try {
		towerBase = ImageIO.read(new File("res/towerbase.png"));
		}	catch(IOException e) {
			
		}
		
	}
	public static synchronized void start() {
		Thread thread = new Thread(new TowerControl());
		thread.start();
	}
	
	@Override
	public void run() {
		while(TowerMain.running) {
			try {
				Thread.sleep(16);
			} catch (InterruptedException e) {
				
			}	
			if(TowerMain.state == TowerMain.GAME && !paused) tick();
		}
	}
	
	public static void tick() {
		for(int i = 0; i < towerlist.size(); i++) {
			towerlist.get(i).tick();
		}
	}
	
	//render is invoked in the main because of paintComponent reference jargon
	public static void render(Graphics2D g2d) {
		for(int i = 0; i < towerlist.size(); i++) {
			towerlist.get(i).render(g2d);
		}
	}
}
