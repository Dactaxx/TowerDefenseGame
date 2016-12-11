package Tracks;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class StraightLeft extends Track {
	BufferedImage track;
	public StraightLeft(double x, double y) throws IOException {
		this.setX(x);
		this.setY(y);
		track = ImageIO.read(new File("res/stone.png"));
		 
	}
	
	@Override
	public void render(Graphics2D g2d) {
		g2d.drawImage(track, 64, 64, (int)this.getX() - 64, (int)this.getY(), null);
		g2d.drawImage(track, 64, 64, (int)this.getX(), (int)this.getY(), null);
		g2d.drawImage(track, 64, 64, (int)this.getX() + 64, (int)this.getY(), null);
		
	}
	
}