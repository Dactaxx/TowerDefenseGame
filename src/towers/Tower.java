package towers;

import java.awt.Graphics2D;

public abstract class Tower {
	private double x, y;
	
	public abstract void tick();
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

}
