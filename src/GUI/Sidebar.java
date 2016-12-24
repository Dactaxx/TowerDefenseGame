package GUI;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import towerdefense.Window;
import towers.TowerControl;

public class Sidebar {
	public static LinkedList<Icon> icons = new LinkedList<Icon>();
	public static void init() {
		Sidebar sidebar = new Sidebar();
		icons.add(sidebar.new Icon(TowerControl.turret, (int)(1632 * Window.scale), (int)(16 * Window.scale)));
		icons.add(sidebar.new Icon(null, (int)(1776 * Window.scale), (int)(16 * Window.scale)));
		
	}
	class Icon {
		BufferedImage tower;
		int x, y;
		public Icon(BufferedImage tower, int x, int y) {
			this.tower = tower;
			this.x = x;
			this.y = y;
			
		}
		public void render(Graphics2D g2d) {
			g2d.drawImage(GUI.metal, (int)(x * Window.scale), (int)(y * Window.scale), 128, 128, null);
			g2d.drawImage(TowerControl.towerBase, (int)((x + 45) * Window.scale), (int)((y + 45 + 16) * Window.scale), (int)(38 * Window.scale), (int)(38 * Window.scale), null);
			g2d.drawImage(tower, (int)((x + 16) * Window.scale), (int)((y + 32) * Window.scale), (int)(96 * Window.scale), (int)(96 * Window.scale), null);
			
		}
	}
	public static void render(Graphics2D g2d) {
		for(int i = 0; i < icons.size(); i++) {
			icons.get(i).render(g2d);
		}
	}
	
}
