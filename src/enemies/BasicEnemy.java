package enemies;

import java.awt.Color;
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
		g2d.setColor(new Color(255, 0, 0));
		g2d.fillRect((int)this.getX() - 25, (int)this.getY() - 25, 50, 50);
		
	}
	
}
