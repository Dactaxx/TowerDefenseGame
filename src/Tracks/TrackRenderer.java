package tracks;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;

public class TrackRenderer {
	public static BufferedImage stone;
	public static LinkedList<Track> tracks = new LinkedList<Track>();
	public static void init() {
		try {
			stone = ImageIO.read(new File("res/stone.png"));
		}	catch(IOException e) {
			e.printStackTrace();
		}
		
		for(int i = 0; i < 20; i++) {
			tracks.add(new StraightRight(i * 64, 350));
			
		}
		
		tracks.add(new BentLeftDown(1280, 350));
		
	}
	
	public static void render(Graphics2D g2d) {
		for(int i = 0; i < tracks.size(); i++) {
			tracks.get(i).render(g2d);
			
		}
		
	}
	
}
