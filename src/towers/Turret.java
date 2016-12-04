package towers;

import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Turret extends Tower {
	private BufferedImage base, turret;
	
	public Turret(double x, double y) throws IOException {
		this.setX(x);
		this.setY(y);
		base = ImageIO.read(new File("res/towerbase.png"));
		turret = ImageIO.read(new File("res/towers/turret.png"));
		
	}
	
	@Override
	public void tick() {
		if(MouseInfo.getPointerInfo().getLocation().getX() > this.getX()) {
			this.setAngle(Math.atan((this.getY() - MouseInfo.getPointerInfo().getLocation().getY()) / (this.getX() - MouseInfo.getPointerInfo().getLocation().getX())) + Math.toRadians(90));
		
		}
		
		if(MouseInfo.getPointerInfo().getLocation().getX() < this.getX()) {
			this.setAngle(Math.toRadians(180) + Math.atan((this.getY() - MouseInfo.getPointerInfo().getLocation().getY()) / (this.getX() - MouseInfo.getPointerInfo().getLocation().getX())) + Math.toRadians(90));
		
		}
		
	}

	@Override
	public void render(Graphics2D g2d) {
		g2d.drawImage(base, (int)(getX() - base.getWidth() / 2), (int)(getY() - base.getHeight() / 2), null);
		
		//rotation; currently just points toward mouse; add enemy tracking later
		AffineTransform trans = AffineTransform.getRotateInstance(this.getAngle(), turret.getWidth() / 2, turret.getHeight() / 2);
		AffineTransformOp op = new AffineTransformOp(trans, AffineTransformOp.TYPE_BILINEAR);
		
		g2d.drawImage(op.filter(turret, null), (int)(getX() - turret.getWidth() / 2), (int)(getY() - turret.getHeight() / 2), null);
		
	}
	
	
	
}
