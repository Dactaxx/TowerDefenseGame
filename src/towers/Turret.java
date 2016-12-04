package towers;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import towerdefense.EnemyRenderer;

public class Turret extends Tower {
	private BufferedImage base, turret;
	
	public Turret(double x, double y) throws IOException {
		this.setX(x);
		this.setY(y);
		this.setRange(300);
		base = ImageIO.read(new File("res/towerbase.png"));
		turret = ImageIO.read(new File("res/towers/turret.png"));
		
	}
	
	@Override
	public void tick() {

/*		if(TowerMain.mousex < this.getX()) {
			this.setAngle(Math.atan((this.getY() - TowerMain.mousey) / (this.getX() - TowerMain.mousex)) - Math.toRadians(90));
			
		}
		
		if(TowerMain.mousex > this.getX()) {
			this.setAngle(Math.atan((this.getY() - TowerMain.mousey) / (this.getX() - TowerMain.mousex)) - Math.toRadians(90) + Math.toRadians(180));
			
		}
*/		
		trackEnemy();
		
	}

	@Override
	public void render(Graphics2D g2d) {
		g2d.drawImage(base, (int)(getX() - base.getWidth() / 2), (int)(getY() - base.getHeight() / 2), null);
		
		//rotation; currently just points toward mouse; add enemy tracking later
		AffineTransform trans = AffineTransform.getRotateInstance(this.getAngle(), turret.getWidth() / 2, turret.getHeight() / 2);
		AffineTransformOp op = new AffineTransformOp(trans, AffineTransformOp.TYPE_BILINEAR);
		
		g2d.drawImage(op.filter(turret, null), (int)(getX() - turret.getWidth() / 2), (int)(getY() - turret.getHeight() / 2), null);
		
		//draws range circle
		g2d.setColor(new Color(255, 255, 255));
		g2d.drawOval((int)this.getX() - (int)this.getRange(), (int)this.getY() - (int)this.getRange(), (int)this.getRange() * 2, (int)this.getRange() * 2);
		
		
	}

	@Override
	public void trackEnemy() {
		int closestEnemy = 0;
		double closestEnemyDistance = 69420;
		for(int i = 0; i < EnemyRenderer.enemylist.size(); i++) {
			double distance = Math.sqrt(Math.pow(this.getX() - EnemyRenderer.enemylist.get(i).getX(), 2) + Math.pow(this.getY() - EnemyRenderer.enemylist.get(i).getY(), 2));
			if(distance < closestEnemyDistance) {
				closestEnemyDistance = distance;
				closestEnemy = i;
				
			}
			
		}
		
		if(closestEnemyDistance <= this.getRange()) {
			double ex = EnemyRenderer.enemylist.get(closestEnemy).getX();
			double ey = EnemyRenderer.enemylist.get(closestEnemy).getY();
			
			if(ex < this.getX()) {
				this.setAngle(Math.atan((this.getX() - ey)/(this.getX() - ex)) - Math.toRadians(90));
			
			}
			
			if(ex > this.getX()) {
				this.setAngle(Math.atan((this.getX() - ey)/(this.getX() - ex)) - Math.toRadians(90) + Math.toRadians(180));
			
			}
			
		}
		
	}
	
	
	
}
