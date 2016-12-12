package tracks;

import java.awt.Graphics2D;

public abstract class Track {
	private double x, y, position;
	public static enum trackType {
		STRAIGHTLEFT, STRAIGHTRIGHT, BENTLEFTDOWN
	}
	
	private trackType type;

	public abstract void render(Graphics2D g2d);
	
	
	public double getX() {
		return x;
		
	}

	public void setX(double x) {
		this.x = x;
		
	}

	public double getY() {
		return y;
		
	}

	public void setY(double y) {
		this.y = y;
		
	}

	public double getPosition() {
		return position;
		
	}

	public void setPosition(double position) {
		this.position = position;
		
	}
	
	
	public trackType getType() {
		return type;
	}


	public void setType(trackType type) {
		this.type = type;
	}
	
}
