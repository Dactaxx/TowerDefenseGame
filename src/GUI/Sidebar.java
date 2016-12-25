package GUI;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import towerdefense.TowerMain;
import towerdefense.Window;
import towers.TowerControl;

public class Sidebar {
	public static LinkedList<Icon> icons = new LinkedList<Icon>();
	public static LinkedList<fakeTower> fakeTowers = new LinkedList<fakeTower>();
	public static Sidebar sidebar = new Sidebar();
	public static void init() {
		icons.add(sidebar.new Icon(TowerControl.turret, (int)(1632), (int)(16)));
		icons.add(sidebar.new Icon(null, (int)(1776), (int)(16)));
		
	}
	class Icon {
		private BufferedImage tower;
		private int x, y;
		public Icon(BufferedImage tower, int x, int y) {
			this.tower = tower;
			this.x = x;
			this.y = y;
			
		}
		public void render(Graphics2D g2d) {
			g2d.drawImage(GUI.metal, (int)(x * Window.scale), (int)(y * Window.scale), (int)(128 * Window.scale), (int)(128 * Window.scale), null);
			g2d.drawImage(TowerControl.towerBase, (int)((x + 45) * Window.scale), (int)((y + 45 + 16) * Window.scale), (int)(38 * Window.scale), (int)(38 * Window.scale), null);
			g2d.drawImage(tower, (int)((x + 16) * Window.scale), (int)((y + 32) * Window.scale), (int)(96 * Window.scale), (int)(96 * Window.scale), null);
			
		}
		
		public int getX() {
			return x;
		}
		public int getY() {
			return y;
		}
		public BufferedImage getTower() {
			return tower;
		}
	}
	
	class fakeTower {
		private double x, y;
		private BufferedImage tower;
		public fakeTower(double x, double y, BufferedImage tower) {
			this.setX(x);
			this.setY(y);
			this.setTower(tower);
		}
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
		public BufferedImage getTower() {
			return tower;
		}
		public void setTower(BufferedImage tower) {
			this.tower = tower;
		}
		
		public void tick()	{
			this.x = TowerMain.mouseX / Window.scale;
			this.y = TowerMain.mouseY / Window.scale;
			
			if(!TowerMain.mouseDown) {
				fakeTowers.remove(this);
				TowerControl.towerlist.add(new towers.Turret(this.x, this.y));
				
			}
		}
		
		public void render(Graphics2D g2d) {
			g2d.drawImage(TowerControl.towerBase, (int)((this.getX() - TowerControl.towerBase.getWidth() / 2) * Window.scale), (int)((this.getY() - TowerControl.towerBase.getHeight() / 2) * Window.scale), (int)(TowerControl.towerBase.getWidth() * Window.scale), (int)(TowerControl.towerBase.getHeight() * Window.scale), null);
			g2d.drawImage(tower, (int)((this.getX() - 64) * Window.scale), (int)((this.getY() - 64) * Window.scale), (int)(128 * Window.scale), (int)(128 * Window.scale), null);
			
			g2d.setColor(new Color(255, 255, 255));
			g2d.drawOval((int)((this.getX() - 300) * Window.scale), (int)((this.getY() - 300) * Window.scale), (int)((300 * 2) * Window.scale), (int)((300 * 2) * Window.scale));
		}
	}
	
	public static void tick() {
		for(Icon i : icons) {
			if(TowerMain.mouseDown && (Math.abs(TowerMain.mouseX / Window.scale - i.getX() - 64)) < 64 && (Math.abs(TowerMain.mouseY / Window.scale - i.getY() - 64 * Window.scale) < 64) && fakeTowers.size() == 0) {
				fakeTowers.add(sidebar.new fakeTower(i.getX(), i.getY(), i.getTower()));
				
			}
			
		}
	}
	
	public static void render(Graphics2D g2d) {
		for(int i = 0; i < icons.size(); i++) {
			icons.get(i).render(g2d);
		}
		
		for(fakeTower i : fakeTowers) {
			i.tick();
			i.render(g2d);
			
		}
	}
	
}
