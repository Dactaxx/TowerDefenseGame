package towers;

import towerdefense.TowerMain;

import java.awt.Graphics2D;
import java.util.LinkedList;

import static towerdefense.TowerMain.paused;

public class TowerControl implements Runnable {
	public static LinkedList<towers.Tower> towerlist = new LinkedList<towers.Tower>();

	public static synchronized void start() {
		Thread thread = new Thread(new TowerControl());
		thread.start();
	}
	
	@Override
	public void run() {
		long then = System.nanoTime();
		while(TowerMain.running && TowerMain.state == TowerMain.GAME || !paused) {
			long now = System.nanoTime();
			if(now - then >= 16666667) {
				then = System.nanoTime();
				if(TowerMain.state == TowerMain.GAME && !paused)
					tick();
			}
			now = System.nanoTime();
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