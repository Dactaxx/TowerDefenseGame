package projectiles;

import static towerdefense.TowerMain.paused;

import java.awt.Graphics2D;
import java.util.LinkedList;

import towerdefense.TowerMain;

public class ProjectileControl implements Runnable {
	public static LinkedList<Projectile> projectiles = new LinkedList<Projectile>();
	
	public static synchronized void start() {
		Thread thread = new Thread(new ProjectileControl());
		thread.start();
		
	}
	
	public static void tick() {
		for(Projectile i : projectiles) {
			i.tick();
			if(Math.abs(i.getX() - towerdefense.Window.width / 2) > towerdefense.Window.width || Math.abs(i.getY() - towerdefense.Window.height / 2) > towerdefense.Window.height / 2) {
				ProjectileControl.projectiles.remove(i);
			}
		}
	}
	
	public static void render(Graphics2D g2d) {
		for(Projectile i : projectiles) {
			i.render(g2d);
		}
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
}
