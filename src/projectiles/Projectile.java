package projectiles;

import java.awt.Graphics2D;

public abstract class Projectile {
	private double x, y, xvel, yvel;
	
	public static enum projectileType {
		BASIC
	}
	
	private projectileType type;
	
	public abstract void tick();
	public abstract void render(Graphics2D g2d);
	
	public double getX() {
		return x;
		
	}

	public void setY(double y) {
		this.y = y;
		
	}

	public double getY() {
		return y;
		
	}

	public void setX(double x) {
		this.x = x;
		
	}
	
	public double getXvel() {
		return xvel;
		
	}

	public void setXvel(double xvel) {
		this.xvel = xvel;
		
	}

	public double getYvel() {
		return yvel;
		
	}

	public void setYvel(double yvel) {
		this.yvel = yvel;
		
	}
	public projectileType getType() {
		return type;
	}
	public void setType(projectileType type) {
		this.type = type;
	}
	
	
	
}
