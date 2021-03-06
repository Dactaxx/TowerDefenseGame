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

import kuusisto.tinysound.Music;
import kuusisto.tinysound.Sound;
import kuusisto.tinysound.TinySound;

import static towerdefense.TowerMain.state;

public class GUI {
	//if h concludes an image name, it denotes that it is the hovered version of an image
	public static BufferedImage resume, exit, resumeh, exith, menuBack, menuIconReg, menuIconOver, HUD, grass, metal;
    public static Font dataControl;

    public static int prevState = -1, masterVolume = 100, musicVolume = 100;

	public static void init() throws IOException {
		resume = ImageIO.read(new File("res/menu/resume.png"));
		exit = ImageIO.read(new File("res/menu/exit.png"));
		resumeh = ImageIO.read(new File("res/menu/resumeh.png"));
		exith = ImageIO.read(new File("res/menu/exith.png"));
        menuBack = ImageIO.read(new File("res/menuBack.png"));
        menuIconReg = ImageIO.read(new File("res/menuIconReg.png"));
        menuIconOver = ImageIO.read(new File("res/menuIconOver.png"));
        HUD = ImageIO.read(new File("res/HUD.png"));
        grass = ImageIO.read(new File("res/grass.png"));
        metal = ImageIO.read(new File("res/menu/metal.png"));


        try {
            dataControl = Font.createFont(Font.TRUETYPE_FONT, new File("res/someTimeLater.otf"));
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

	public static void tick() {

        if (state != prevState){
	        prevState = state;

        }

	    switch(state) {
            case TowerMain.MENU:
                Menu.tick();
                break;
            case TowerMain.GAME:
                Game.tick();
                Sidebar.tick();
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
            	Sidebar.render(g2d);
                break;
            case TowerMain.SETTINGS:
                Settings.render(g2d);
                break;
        }
	}
}
