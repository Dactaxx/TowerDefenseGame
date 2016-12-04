package enemies;


import java.awt.Graphics2D;

public abstract class Enemy {
	private double x, y, angle, hp, xvel, yvel;
	
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
	
	public double getAngle() {
		return angle;
		
	}
	
	public void setAngle(double angle) {
		this.angle = angle;
		
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
	
	public double getHp() {
		return hp;
		
	}
	
	public void setHp(double hp) {
		this.hp = hp;
		
	}
	
}
