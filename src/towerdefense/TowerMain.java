package towerdefense;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class TowerMain extends JPanel implements Runnable {
	private static final long serialVersionUID = 8291911686213150373L;
	public static boolean running = false;
	public static int MENU = 0;
	public static int GAME = 1;
	public static int PAUSED = 2;
	public static int state;
	
	public static double mousex, mousey;
	
	public static boolean mousedown = false;
	
	public static BufferedImage resume, resumeh, exit, exith;
	
	public static void main(String[] args) throws IOException {
		start();

		
	}

	public void init() throws IOException {
		Window.createWindow();
		Window.frame.addMouseListener(new MouseInput());
		Window.frame.addKeyListener(new KeyInput());

		towers.Turret turret = new towers.Turret(500, 500);
		TowerRenderer.towerlist.add(turret);
		
	}
	
	public static synchronized void start() throws IOException {
		running = true;
		
		resume = ImageIO.read(new File("res/resume.png"));
		exit = ImageIO.read(new File("res/exit.png"));
		resumeh = ImageIO.read(new File("res/resumeh.png"));
		exith = ImageIO.read(new File("res/exith.png"));
		
		Thread thread = new Thread(new TowerMain());
		thread.start();
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
		
		if(state == GAME) {
			TowerRenderer.render(g2d);
			
		}
		
		if(state == PAUSED) 	{
			g2d.drawImage(resume, (Window.width - resume.getWidth()) / 2, (Window.height - (resume.getHeight() * 2 + 50)) / 2, null);
			g2d.drawImage(exit, (Window.width - exit.getWidth()) / 2, (Window.height - (exit.getHeight() * 2 + 50)) / 2 + exit.getHeight() + 50, null);
			
			if(mousex >(Window.width - exith.getWidth()) / 2 && mousex < (Window.width - resume.getWidth()) / 2 + resume.getWidth() && mousey > (Window.height - (resume.getHeight() * 2 + 50)) / 2 + resume.getHeight() + 50 && mousey < (Window.height - (resume.getHeight() * 2 + 50)) / 2 + resume.getHeight() + 50 + resume.getHeight()) {
				g2d.drawImage(exith, (Window.width - exith.getWidth()) / 2, (Window.height - (exith.getHeight() * 2 + 50)) / 2 + exith.getHeight() + 50, null);
				
			}
			
			if(mousex >(Window.width - resume.getWidth()) / 2 && mousex < (Window.width - resume.getWidth()) / 2 + resume.getWidth() && mousey > (resume.getHeight() * 2 + 50) / 2 && mousey < (Window.height - (resume.getHeight() * 2 + 50)) / 2 + resume.getHeight()) {
				g2d.drawImage(resumeh, (Window.width - resumeh.getWidth()) / 2, (Window.height - (resumeh.getHeight() * 2 + 50)) / 2, null);
				
			}
			
		}
		
/*		g2d.setColor(new Color(255, 0, 0));
		g2d.fillRect(500, 500, 100, 100);
		
		g2d.setColor(new Color(0, 255, 0));
		g2d.fillRect(525, 525, 50, 50);
*/		
	}
	
	public void tick() {
		mousex = MouseInfo.getPointerInfo().getLocation().getX();
		mousey = MouseInfo.getPointerInfo().getLocation().getY();
		
		if(state == PAUSED && mousex >(Window.width - resume.getWidth()) / 2 && mousex < (Window.width - resume.getWidth()) / 2 + resume.getWidth() && mousey > (Window.height - (resume.getHeight() * 2 + 50)) / 2 + resume.getHeight() + 50 && mousey < (Window.height - (resume.getHeight() * 2 + 50)) / 2 + resume.getHeight() + 50 + resume.getHeight() && mousedown) {
			System.exit(1);
			
		}
		
		if(state == PAUSED && mousex >(Window.width - resume.getWidth()) / 2 && mousex < (Window.width - resume.getWidth()) / 2 + resume.getWidth() && mousey > (resume.getHeight() * 2 + 50) / 2 && mousey < (Window.height - (resume.getHeight() * 2 + 50)) / 2 + resume.getHeight() && mousedown) {
			state = GAME;
			
		}
		
	}
	
}
