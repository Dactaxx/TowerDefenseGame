package towerdefense;

import static towerdefense.TowerMain.state;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

import GUI.GUI;

public class Sound {
	public static Clip clip;
    public static AudioInputStream transmissionStream, jumpUpStream, crystalWaters;
    public static int prevState = -1, masterVolume = 100, musicVolume = 100;
    public static FloatControl gainControl;
    
    public static void init() {
        try {
            clip = AudioSystem.getClip();
            transmissionStream = AudioSystem.getAudioInputStream(GUI.class.getClassLoader().getResourceAsStream("Transmission.wav"));
            jumpUpStream = AudioSystem.getAudioInputStream(GUI.class.getClassLoader().getResourceAsStream("Jump_Up.wav"));
            crystalWaters = AudioSystem.getAudioInputStream(GUI.class.getClassLoader().getResourceAsStream("res/Crystal_Waters.wav"));
        }	catch (Exception ex) {
            	System.out.println(ex);
        	}
    }
    
    public static void tick() {
        if (state != prevState){
	        prevState = state;
            clip.close();
            try {
                clip = AudioSystem.getClip();
                switch(state) {
                    case TowerMain.MENU:
                        clip.open(jumpUpStream);
                        break;
                    case TowerMain.GAME:
                        clip.open(transmissionStream);
                        break;
                    case TowerMain.SETTINGS:
                        clip.open(crystalWaters);
                        break;
                }
                } catch (Exception ex) {
                System.out.println(ex);
            }
            clip.loop(-1);
            gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(6.0206f * masterVolume * musicVolume / 10000);
            clip.start();
        }
    }
	
}
