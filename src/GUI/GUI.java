package GUI;

import towerdefense.TowerMain;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

import static towerdefense.TowerMain.state;

public class GUI {
	//if h concludes an image name, it denotes that it is the hovered version of an image
	public static BufferedImage resume, exit, resumeh, exith, menuBack, menuIconReg, menuIconOver, HUD;
    public static Font dataControl;
    public static Clip clip;
    public static AudioInputStream transmissionStream, jumpUpStream, crystalWaters;
    public static int prevState = -1, masterVolume = 100, musicVolume = 100;
    public static FloatControl gainControl;

	public static void init() throws IOException {
		resume = ImageIO.read(new File("res/resume.png"));
		exit = ImageIO.read(new File("res/exit.png"));
		resumeh = ImageIO.read(new File("res/resumeh.png"));
		exith = ImageIO.read(new File("res/exith.png"));
        menuBack = ImageIO.read(new File("res/menuBack.png"));
        menuIconReg = ImageIO.read(new File("res/menuIconReg.png"));
        menuIconOver = ImageIO.read(new File("res/menuIconOver.png"));
        HUD = ImageIO.read(new File("res/HUD.png"));

        try {
            dataControl = Font.createFont(Font.TRUETYPE_FONT, new File("res/someTimeLater.otf"));
            clip = AudioSystem.getClip();
            transmissionStream = AudioSystem.getAudioInputStream(GUI.class.getClassLoader().getResourceAsStream("Transmission.wav"));
            jumpUpStream = AudioSystem.getAudioInputStream(GUI.class.getClassLoader().getResourceAsStream("Jump_Up.wav"));
            crystalWaters = AudioSystem.getAudioInputStream(GUI.class.getClassLoader().getResourceAsStream("Crystal_Waters.wav"));
        } catch (Exception ex) {
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

	    switch(state) {
            case TowerMain.MENU:
                Menu.tick();
                break;
            case TowerMain.GAME:
                Game.tick();
                break;
            case TowerMain.SETTINGS:
                Settings.tick();
                break;
        }
	}

	public static void render(Graphics2D g2d) {
        switch(state) {
            case TowerMain.MENU:
                Menu.render(g2d);
                break;
            case TowerMain.GAME:
                Game.render(g2d);
                break;
            case TowerMain.SETTINGS:
                Settings.render(g2d);
                break;
        }
	}
}
