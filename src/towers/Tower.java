package towers;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public abstract class Tower {
	private double x, y, angle, range, speed;
	private boolean isShooting;
	public static BufferedImage turret;
	
	public abstract void tick();
	public abstract void render(Graphics2D g2d);
	public abstract void trackEnemy();
	
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
	public double getAngle() {
		return angle;
		
	}
	
	public void setAngle(double angle) {
		this.angle = angle;

	}
	
	public double getRange() {
		return range;
	}
	
	public void setRange(double range) {
		this.range = range;
	}
	
	public double getSpeed() {
		return speed;
	}
	
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public boolean isShooting() {
		return isShooting;
	}
	
	public void setShooting(boolean isShooting) {
		this.isShooting = isShooting;
	}

}
