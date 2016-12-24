package tracks;

import java.awt.Graphics2D;

import towerdefense.Window;

public class StraightUp extends Track {
	public StraightUp(double x, double y) {
		this.setX(x);
		this.setY(y);
		this.setType(Track.trackType.STRAIGHTUP);
		
	}
	
	@Override
	public void render(Graphics2D g2d) {
		g2d.drawImage(TrackRenderer.stone, (int)((this.getX() - 32) * Window.scale), (int)((this.getY() - 32) * Window.scale), (int)(64 * Window.scale), (int)(64 * Window.scale), null);
		
	}
}
