package GUI;

import towerdefense.TowerMain;
import towerdefense.Window;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GUI {
	//if h concludes an image name, it denotes that it is the hovered version of an image
	public static BufferedImage resume, exit, resumeh, exith;
	public static void init() throws IOException {
		resume = ImageIO.read(new File("res/resume.png"));
		exit = ImageIO.read(new File("res/exit.png"));
		resumeh = ImageIO.read(new File("res/resumeh.png"));
		exith = ImageIO.read(new File("res/exith.png"));

	}
	
	public static void tick() {
		if(TowerMain.state == TowerMain.PAUSED && TowerMain.mouseX >(Window.width - resume.getWidth()) / 2 && TowerMain.mouseX < (Window.width - resume.getWidth()) / 2 + resume.getWidth() && TowerMain.mouseY > (Window.height - (resume.getHeight() * 2 + 50)) / 2 + resume.getHeight() + 50 && TowerMain.mouseY < (Window.height - (resume.getHeight() * 2 + 50)) / 2 + resume.getHeight() + 50 + resume.getHeight() && TowerMain.mouseDown) {
			System.exit(1);
			
		}
		
		if(TowerMain.state == TowerMain.PAUSED && TowerMain.mouseX >(Window.width - resume.getWidth()) / 2 && TowerMain.mouseX < (Window.width - resume.getWidth()) / 2 + resume.getWidth() && TowerMain.mouseY > (resume.getHeight() * 2 + 50) / 2 && TowerMain.mouseY < (Window.height - (resume.getHeight() * 2 + 50)) / 2 + resume.getHeight() && TowerMain.mouseDown) {
			TowerMain.state = TowerMain.GAME;
			
		}
		
	}

	public static void render(Graphics2D g2d) {
		
	}
	
	public static void renderMenu(Graphics2D g2d) {
		g2d.drawImage(resume, (Window.width - resume.getWidth()) / 2, (Window.height - (resume.getHeight() * 2 + 50)) / 2, null);
		g2d.drawImage(exit, (Window.width - exit.getWidth()) / 2, (Window.height - (exit.getHeight() * 2 + 50)) / 2 + exit.getHeight() + 50, null);
		
		if(TowerMain.mouseX >(Window.width - exith.getWidth()) / 2 && TowerMain.mouseX < (Window.width - resume.getWidth()) / 2 + resume.getWidth() && TowerMain.mouseY > (Window.height - (resume.getHeight() * 2 + 50)) / 2 + resume.getHeight() + 50 && TowerMain.mouseY < (Window.height - (resume.getHeight() * 2 + 50)) / 2 + resume.getHeight() + 50 + resume.getHeight()) {
			g2d.drawImage(exith, (Window.width - exith.getWidth()) / 2, (Window.height - (exith.getHeight() * 2 + 50)) / 2 + exith.getHeight() + 50, null);
			
		}
		
		if(TowerMain.mouseX >(Window.width - resume.getWidth()) / 2 && TowerMain.mouseX < (Window.width - resume.getWidth()) / 2 + resume.getWidth() && TowerMain.mouseY > (Window.height - (resume.getHeight() * 2 + 50)) / 2 && TowerMain.mouseY < (Window.height - (resume.getHeight() * 2 + 50)) / 2 + resume.getHeight()) {
			g2d.drawImage(resumeh, (Window.width - resumeh.getWidth()) / 2, (Window.height - (resumeh.getHeight() * 2 + 50)) / 2, null);
			
		}
	}
	
}
