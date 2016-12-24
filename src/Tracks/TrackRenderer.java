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
		
		tracks.add(new BentRightDown(1280, 350));

		for(int i = 0; i < 5; i++) {
			tracks.add(new StraightDown(1280, 350 + 64 + i * 64));
			
		}
		
		tracks.add(new BentUpLeft(1280, 320 + 350 + 64));
		
		for(int i  = 0; i < 15; i++) {
			tracks.add(new StraightLeft(1280 - 64 - i * 64, 320 + 350 + 64));
			
		}
		
		tracks.add(new BentLeftUp(1280 - 64 - 15 * 64, 320 + 350 + 64));
		tracks.add(new StraightUp(1280 - 64 - 15 * 64, 320 + 350));
		tracks.add(new BentDownLeft(1280 - 64 - 15 * 64, 320 + 350 - 64));
		tracks.add(new StraightLeft(1280 - 64 - 15 * 64 - 64, 320 + 350 - 64));
		tracks.add(new BentLeftDown(1280 - 64 - 15 * 64 - 128, 320 + 350 - 64));
		tracks.add(new StraightDown(1280 - 64 - 15 * 64 - 128, 320 + 350));
		tracks.add(new StraightDown(1280 - 64 - 15 * 64 - 128, 320 + 350 + 64));
		tracks.add(new StraightDown(1280 - 64 - 15 * 64 - 128, 320 + 350 + 128));
		tracks.add(new BentUpRight(1280 - 64 - 15 * 64 -128, 320 + 350 + 128 + 64));
		
	}
	
	public static void render(Graphics2D g2d) {
		for(int i = 0; i < tracks.size(); i++) {
			tracks.get(i).render(g2d);
			
		}
		
	}
	
}
