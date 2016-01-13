package towerdefense;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.LinkedList;

public class TowerRenderer implements Runnable {
	public static LinkedList<towers.Tower> towerlist = new LinkedList<towers.Tower>();

	public static synchronized void start() {
		Thread thread = new Thread(new TowerRenderer());
		thread.start();
		
	}
	
	@Override
	public void run() {
		long then = System.nanoTime();
		while(TowerMain.running && TowerMain.state == TowerMain.GAME || TowerMain.state == TowerMain.PAUSED) {
			long now = System.nanoTime();
			if(now - then >= 16666667) {
				then = System.nanoTime();
				if(TowerMain.state == TowerMain.GAME) tick();
				
			}
			now = System.nanoTime();
			
		}
		
	}
	
	public static void tick() {
		for(int i = 0; i < towerlist.size(); i++) {
			towerlist.get(i).tick();
			
		}
		
	}
	
	public static void render(Graphics2D g2d) {
		for(int i = 0; i < towerlist.size(); i++) {
			towerlist.get(i).render(g2d);
		
		}
		
	}
	
	
}
