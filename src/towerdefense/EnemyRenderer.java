package towerdefense;

import java.awt.Graphics2D;
import java.util.LinkedList;

import enemies.Enemy;

import static towerdefense.TowerMain.paused;

public class EnemyRenderer implements Runnable {
	public static LinkedList<Enemy> enemylist = new LinkedList<Enemy>();
	public static Thread thread;
	
	public static void start() {
		thread = new Thread(new EnemyRenderer());
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
