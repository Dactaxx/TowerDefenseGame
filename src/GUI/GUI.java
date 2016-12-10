package GUI;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import towerdefense.TowerMain;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;

public class GUI {
	//if h concludes an image name, it denotes that it is the hovered version of an image
	public static BufferedImage resume, exit, resumeh, exith, menuBack, menuIconReg, menuIconOver, visor;
    public static Font dataControl;
    public static Media transition;
    public static MediaPlayer backgroundMusicPlayer;

	public static void init() throws IOException {
		resume = ImageIO.read(new File("res/resume.png"));
		exit = ImageIO.read(new File("res/exit.png"));
		resumeh = ImageIO.read(new File("res/resumeh.png"));
		exith = ImageIO.read(new File("res/exith.png"));
        menuBack = ImageIO.read(new File("res/menuBack.png"));
        menuIconReg = ImageIO.read(new File("res/menuIconReg.png"));
        menuIconOver = ImageIO.read(new File("res/menuIconOver.png"));
        visor = ImageIO.read(new File("res/visor.png"));

        try {
            dataControl = Font.createFont(Font.TRUETYPE_FONT, new File("res/someTimeLater.otf"));

        } catch (Exception ex) {}
        //backgroundMusicPlayer = new MediaPlayer(new Media("res/Transmission.mp3"));
        //AudioPlayer.player.start(new AudioStream(new FileInputStream("res/Transmission.mp3")));
	}

	public static void tick() {
	    switch(TowerMain.state) {
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
        switch(TowerMain.state) {
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
