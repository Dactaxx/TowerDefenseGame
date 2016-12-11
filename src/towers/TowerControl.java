package towers;

import towerdefense.TowerMain;

import java.awt.Graphics2D;
import java.util.LinkedList;

import static towerdefense.TowerMain.paused;
import static towerdefense.TowerMain.state;

public class TowerControl implements Runnable {
	public static LinkedList<towers.Tower> towerlist = new LinkedList<towers.Tower>();

	public static synchronized void start() {
		Thread thread = new Thread(new TowerControl());
		thread.start();
	}
	
	@Override
	public void run() {
		long then = System.currentTimeMillis();
		while(TowerMain.running) {
			long now = System.currentTimeMillis();
			if(now - then >= 16) {
				then = System.currentTimeMillis();
				if(TowerMain.state == TowerMain.GAME && !paused)
					tick();
			}
			now = System.currentTimeMillis();
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
