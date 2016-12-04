package enemies;

import java.awt.Graphics2D;

public class BasicEnemy extends Enemy {
	public BasicEnemy(int x, int y) {
		this.setX(x);
		this.setY(y);
		
	}
	
	@Override
	public void tick() {
		this.setX(this.getX() + 5);
		
	}

	@Override
	public void render(Graphics2D g2d) {
		g2d.fillRect((int)this.getX(), (int)this.getY(), (int)this.getX() + 50, (int)this.getY() + 50);
		
	}
	
	public void render() {
		
		
	}
	
}
