package enemies;

import java.awt.Color;
import java.awt.Graphics2D;

import tracks.*;

public class BasicEnemy extends Enemy {
	public BasicEnemy(int x, int y) {
		this.setX(x);
		this.setY(y);
		
	}
	
	@Override
	public void tick() {
		boolean searching = true;
		int index = 0;
		while(searching && index < TrackRenderer.tracks.size()) {
			double trackX = TrackRenderer.tracks.get(index).getX();
			double trackY = TrackRenderer.tracks.get(index).getY();
			if(Math.abs((this.getX() - trackX)) <= 32 && Math.abs(this.getY() - trackY) <= 32) {
				searching = false;
				Track.trackType typeCurrent = TrackRenderer.tracks.get(index).getType();
				switch(typeCurrent) {
					case STRAIGHTRIGHT:
						this.setX(this.getX()+10);
						this.setY(trackY);
					break;
					
					case BENTLEFTDOWN:
						this.setX(this.getX() + 7);
						this.setY(this.getY() + 10);
					break;
					
				}
				
			}
			index++;
		}
		
	}
	
	@Override
	public void render(Graphics2D g2d) {
		g2d.setColor(new Color(0, 194, 255));
		g2d.fillRect((int)this.getX() - 25, (int)this.getY() - 25, 50, 50);
		
	}
	
}
