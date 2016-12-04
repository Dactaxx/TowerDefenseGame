package towerdefense;

import java.awt.Graphics2D;
import java.util.LinkedList;

import enemies.Enemy;

public class EnemyRenderer implements Runnable {
	public static LinkedList<Enemy> enemylist = new LinkedList<Enemy>();

	public static void start() {
		Thread thread = new Thread(new EnemyRenderer());
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
