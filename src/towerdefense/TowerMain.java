package towerdefense;

import GUI.GUI;
import towers.TowerControl;
import projectiles.ProjectileControl;

import static towerdefense.TowerMain.paused;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.io.IOException;

import javax.swing.JPanel;

public class TowerMain extends JPanel implements Runnable {
	private static final long serialVersionUID = 8291911686213150373L;
	public static boolean running = false;
	public static final int MENU = 0;
	public static final int GAME = 1;
	public static final int SETTINGS = 2;
	public static int state;
	public static boolean paused = false;
	public static double mouseX, mouseY;
	public static boolean mouseDown = false;
	public static long now;
	
	public static void main(String[] args) throws IOException {
		start();
		TowerControl.start();
		
	}

	public void init() throws IOException {
		Window.createWindow();
		Window.frame.addMouseListener(new MouseInput());
		Window.frame.addKeyListener(new KeyInput());

		towers.Turret turret = new towers.Turret(500, 500);
		TowerControl.towerlist.add(turret);
		
		enemies.BasicEnemy basicEnemy = new enemies.BasicEnemy(0, 350);
		EnemyRenderer.enemylist.add(basicEnemy);
		
		GUI.init();
		Sound.init();
		towers.TowerControl.init();
		tracks.TrackRenderer.init();
		
	}
	
	public static synchronized void start() throws IOException {
		running = true;
		Thread thread = new Thread(new TowerMain());
		thread.start();
		TowerControl.start();
		EnemyRenderer.start();
		ProjectileControl.start();
		state = GAME;
		
	}
	
	@Override
	public void run() {
		try {
			init();
			
		}	catch (IOException e) {
			e.printStackTrace();
			}
		
		while(TowerMain.running) {
			try {
				Thread.sleep(16);
			} catch (InterruptedException e) {
				
			}	
			if(TowerMain.state == TowerMain.GAME && !paused) tick();
			Window.frame.repaint();
		}
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		GUI.render(g2d);
		g2d.setColor(new Color(0, 0, 0));
		g2d.drawRect(0, 0, Window.width, Window.height);
	}
	
	public void tick() {
		mouseX = MouseInfo.getPointerInfo().getLocation().getX();
		mouseY = MouseInfo.getPointerInfo().getLocation().getY();
		GUI.tick();
	}
}
