package towerdefense;

import static towerdefense.TowerMain.state;

import GUI.Game;
import kuusisto.tinysound.TinySound;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class Sound {
    public static kuusisto.tinysound.Music transmissionStream, jumpUpStream, crystalWaters;
    public static int prevState = -1, masterVolume = 100, musicVolume = 50, effectVolume = 50;

    public static void init() {
        System.out.println("Init");
        TinySound.init();
        transmissionStream = TinySound.loadMusic("Transmission.wav");
        jumpUpStream = TinySound.loadMusic("Jump_Up.wav");
        crystalWaters = TinySound.loadMusic("Crystal_Waters.wav");
        transmissionStream.play(true, (double)musicVolume * (double)masterVolume / 10000);
    }
    
    public static void tick() {
        if (state != prevState){
            System.out.println("Change");
	        prevState = state;
	        jumpUpStream.stop();
	        transmissionStream.stop();
	        crystalWaters.stop();
            switch(state) {
                case TowerMain.MENU:
                    TinySound.init();
                    jumpUpStream.play(true,(double)musicVolume * (double)masterVolume / 10000);
                    break;
                case TowerMain.GAME:
                    Game.getMusic().play(true, (double)musicVolume * (double)masterVolume / 10000);
                    break;
                case TowerMain.SETTINGS:
                    crystalWaters.play(true, (double)musicVolume * (double)masterVolume / 10000);
                    break;
                }
        }
    }

    public void playSound(kuusisto.tinysound.Sound sound) {
        sound.play(masterVolume * effectVolume / 10000);
    }
}
