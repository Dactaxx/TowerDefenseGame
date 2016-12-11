package towerdefense;

import java.awt.Graphics2D;
import java.util.LinkedList;

import enemies.Enemy;

import static towerdefense.TowerMain.paused;

public class EnemyRenderer implements Runnable {
	public static LinkedList<Enemy> enemylist = new LinkedList<Enemy>();

	public static void start() {
		Thread thread = new Thread(new EnemyRenderer());
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
		for(int i = 0; i < enemylist.size(); i++) {
			enemylist.get(i).tick();
		}
	}
	
	//render is invoked in the main because of paintComponent reference jargon
	public static void render(Graphics2D g2d) {
		for(int i = 0; i < enemylist.size(); i++) {
			enemylist.get(i).render(g2d);
		}
	}
}
