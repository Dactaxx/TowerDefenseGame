package Tracks;

import java.awt.Graphics2D;

public abstract class Track {
	private double x, y, position;
	
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
	
}
