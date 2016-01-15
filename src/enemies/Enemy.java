package enemies;

public abstract class Enemy {
	private double x, y, hp, xvel, yvel;
	
	public abstract void tick();
	public abstract void render();
	
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
