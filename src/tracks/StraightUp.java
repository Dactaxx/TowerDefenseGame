package tracks;

import java.awt.Graphics2D;

public class StraightUp extends Track {
	public StraightUp(double x, double y) {
		this.setX(x);
		this.setY(y);
		this.setType(Track.trackType.STRAIGHTUP);
		
	}
	
	@Override
	public void render(Graphics2D g2d) {
		g2d.drawImage(TrackRenderer.stone, (int)this.getX() - 32, (int)this.getY() - 32, 64, 64, null);
		
	}
}
