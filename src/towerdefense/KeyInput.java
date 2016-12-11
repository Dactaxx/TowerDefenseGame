package towerdefense;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static towerdefense.Sound.clip;
import static towerdefense.TowerMain.paused;

public class KeyInput implements KeyListener {

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_ESCAPE && TowerMain.state == TowerMain.GAME) {
            if(paused) {
                paused = false;
                clip.start();
            } else {
                paused = true;
                clip.stop();
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
