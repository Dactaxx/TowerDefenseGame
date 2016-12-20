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
		for(int i = 0; i < projectiles.size(); i++) {
			if(i < projectiles.size()) {
				try {
					projectiles.get(i).tick();
					if(Math.abs(projectiles.get(i).getX() - towerdefense.Window.width / 2) > towerdefense.Window.width || Math.abs(projectiles.get(i).getY() - towerdefense.Window.height / 2) > towerdefense.Window.height / 2) {
						ProjectileControl.projectiles.remove(i);
					}
				} catch(NullPointerException e) {

				}
			}
			
		}
	}
	
	public static void render(Graphics2D g2d) {
		for(int i = 0; i < projectiles.size(); i++) {
			try {
				if(i < projectiles.size()) projectiles.get(i).render(g2d);
			} catch(NullPointerException e) {

			}
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
