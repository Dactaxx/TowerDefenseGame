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

import projectiles.*;

public class Turret extends Tower {
	private BufferedImage turret;
	
	public Turret(double x, double y) throws IOException {
		this.setX(x);
		this.setY(y);
		this.setRange(300);
		turret = ImageIO.read(new File("res/towers/turret.png"));
		this.setSpeed(0);
		
	}
	
	@Override
	public void tick() {

/*		if(TowerMain.mouseX < this.getX()) {
			this.setAngle(Math.atan((this.getY() - TowerMain.mouseY) / (this.getX() - TowerMain.mouseX)) - Math.toRadians(90));
		}
		
		if(TowerMain.mouseX > this.getX()) {
			this.setAngle(Math.atan((this.getY() - TowerMain.mouseY) / (this.getX() - TowerMain.mouseX)) - Math.toRadians(90) + Math.toRadians(180));
		}
*/		
		trackEnemy();
		if(this.getSpeed() >= 60) {
			this.setSpeed(0);
		}
		
		if(!this.isShooting() && this.getSpeed() != 0) {
			this.setSpeed(this.getSpeed() + 1);
		}
		
	}

	@Override
	public void render(Graphics2D g2d) {
		g2d.drawImage(TowerControl.towerBase, (int)(this.getX() - TowerControl.towerBase.getWidth() / 2), (int)(this.getY() - TowerControl.towerBase.getHeight() / 2), null);
		
		//rotation; currently just points toward mouse; add enemy tracking later
		AffineTransform trans = AffineTransform.getRotateInstance(this.getAngle(), turret.getWidth() / 2, turret.getHeight() / 2);
		AffineTransformOp op = new AffineTransformOp(trans, AffineTransformOp.TYPE_BILINEAR);
		
		g2d.drawImage(op.filter(turret, null), (int)(this.getX() - 64), (int)(this.getY() - 64), 128, 128, null);
		
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
			
			this.setShooting(true);
			if(this.getSpeed() == 0) this.shoot(ex, ey);
			this.setSpeed(this.getSpeed() + 1);
			
		} else {
			this.setShooting(false);
		}
		
	}

	private void shoot(double enemyX, double enemyY) {
		ProjectileControl.projectiles.add(new BasicProjectile(this.getX(), this.getY(), .2 * (enemyX  - this.getX()), .2 * (enemyY - this.getY())));
		
	}
	
}
