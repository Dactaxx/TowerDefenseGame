package enemies;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import tracks.Track;
import tracks.TrackRenderer;

import projectiles.ProjectileControl;
import projectiles.Projectile;

public class BasicEnemy extends Enemy {
	public BasicEnemy(int x, int y) {
		this.setX(x);
		this.setY(y);
		this.setSpeed(5);
		this.setHp(10);
		this.setMaxHp(10);
		
	}
	
	@Override
	public void tick() {
		boolean searching = true;
		int index = 0;
		while(searching && index < TrackRenderer.tracks.size()) {
			double trackX = TrackRenderer.tracks.get(index).getX();
			double trackY = TrackRenderer.tracks.get(index).getY();
			if(Math.abs((this.getX() - trackX)) <= 32 && Math.abs(this.getY() - trackY) <= 32) {
				searching = false;
				Track.trackType typeCurrent = TrackRenderer.tracks.get(index).getType();
				switch(typeCurrent) {
					case STRAIGHTLEFT:
						this.setX(this.getX() - this.getSpeed());
						this.setY(trackY);
					break;
				
					case STRAIGHTRIGHT:
						this.setX(this.getX() + this.getSpeed());
						this.setY(trackY);
					break;
					
					case STRAIGHTDOWN:
						this.setX(trackX);
						this.setY(this.getY() + this.getSpeed());
					break;
					
					case BENTLEFTDOWN:
						this.setX(this.getX() + this.getSpeed() / Math.sqrt(2));
						this.setY(this.getY() + this.getSpeed());
					break;
					
					case BENTUPLEFT:
						this.setX(this.getX() - this.getSpeed());
						this.setY(this.getY() + this.getSpeed() / Math.sqrt(2));
					break;
					
				}
				
			}
			index++;
		}
		
		searching = true;
		index = 0;
		while(searching && index < ProjectileControl.projectiles.size()) {
			double projX = ProjectileControl.projectiles.get(index).getX();
			double projY = ProjectileControl.projectiles.get(index).getY();
			if(Math.abs((this.getX() - projX)) <= 50 && Math.abs(this.getY() - projY) <= 50) {
				searching = false;
				Projectile.projectileType typeCurrent = ProjectileControl.projectiles.get(index).getType();
				switch(typeCurrent) {
					case BASIC:
						this.setHp(this.getHp() - 1);
						ProjectileControl.projectiles.remove(index);
					break;

				}
				
			}
			index++;
		}
		
		
	}
	
	@Override
	public void render(Graphics2D g2d) {
		g2d.setColor(new Color(0, 194, 255));
		g2d.fillRect((int)this.getX() - 25, (int)this.getY() - 25, 50, 50);
		
		//health bar
		g2d.setColor(new Color(255, 0, 0));
		g2d.fillRect((int)this.getX() - 25, (int)this.getY() - 40, 50, 10);
		
		g2d.setColor(new Color(0, 255, 0));
		g2d.fillRect((int)this.getX() - 25, (int)this.getY() - 40, (int)(50 * (this.getHp() / this.getMaxHp())), 10);
		
		//health text
		g2d.setColor(new Color(255, 255, 255));
		g2d.setFont(new Font("Arial", Font.PLAIN, 25));
		g2d.drawString(Integer.toString((int)this.getHp()), (int)this.getX() - Integer.toString((int)this.getHp()).length() * 5 - 5, (int)this.getY() + 8);
		
	}
	
}
