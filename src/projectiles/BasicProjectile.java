package projectiles;

import java.awt.Color;
import java.awt.Graphics2D;

public class BasicProjectile extends Projectile {
	public BasicProjectile(double x, double y, double xvel, double yvel) {
		this.setX(x);
		this.setY(y);
		this.setXvel(xvel);
		this.setYvel(yvel);
		this.setType(Projectile.projectileType.BASIC);
		
	}
	
	@Override
	public void tick() {
		this.setX(this.getX() + this.getXvel());
		this.setY(this.getY() + this.getYvel());
		
	}

	@Override
	public void render(Graphics2D g2d) {
		g2d.setColor(new Color(0, 0, 0));
		g2d.fillRect((int)this.getX() - 10, (int)this.getY() - 10, 20, 20);
		
	}

}
