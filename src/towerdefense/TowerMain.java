package towerdefense;

import GUI.GUI;

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
	public static int state;
	public static int PAUSED = 2;
	
	public static double mouseX, mouseY;
	
	public static boolean mouseDown = false;
	
	public static void main(String[] args) throws IOException {
		start();
		TowerRenderer.start();
		
	}

	public void init() throws IOException {
		Window.createWindow();
		Window.frame.addMouseListener(new MouseInput());
		Window.frame.addKeyListener(new KeyInput());

		towers.Turret turret = new towers.Turret(500, 500);
		TowerRenderer.towerlist.add(turret);
		
		enemies.BasicEnemy basicEnemy = new enemies.BasicEnemy(0, 350);
		EnemyRenderer.enemylist.add(basicEnemy);
		
		GUI.init();
		
	}
	
	public static synchronized void start() throws IOException {
		running = true;
		
		Thread thread = new Thread(new TowerMain());
		thread.start();
		TowerRenderer.start();
		EnemyRenderer.start();
		state = GAME;
		
	}
	
	@Override
	public void run() {
		try {
			init();
			
		}	catch (IOException e) {
			e.printStackTrace();
			
			}
		
		long then = System.nanoTime();
		while(running) {
			long now = System.nanoTime();
			if(now - then >= 16666667) {
				then = System.nanoTime();
				tick();
				Window.frame.repaint();
				
			}
			now = System.nanoTime();
			
		}
		
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.setColor(new Color(0, 0, 0));
		
		g2d.fillRect(0, 0, Window.width, Window.height);
		
		if(state == GAME || state == PAUSED) {
			TowerRenderer.render(g2d);
			EnemyRenderer.render(g2d);
			GUI.render(g2d);
			
		}
		
		if(state == PAUSED) {
			GUI.renderMenu(g2d);
			
		}
		
		g2d.setColor(new Color(255, 0, 0));
		g2d.fillRect(500, 500, 100, 100);
		
		g2d.setColor(new Color(0, 255, 0));
		g2d.fillRect(525, 525, 50, 50);
		
	}
	
	public void tick() {
		mouseX = MouseInfo.getPointerInfo().getLocation().getX();
		mouseY = MouseInfo.getPointerInfo().getLocation().getY();
		
		GUI.tick();
		
	}
	
}
