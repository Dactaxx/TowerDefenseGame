package towerdefense;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener {

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_ESCAPE) {
			if(TowerMain.state == TowerMain.GAME) {
				TowerMain.state = TowerMain.PAUSED;
				
			}	else if(TowerMain.state == TowerMain.PAUSED) {
					TowerMain.state = TowerMain.GAME;
				
				}
			
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
