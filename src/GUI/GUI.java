package GUI;

import com.sun.org.apache.xml.internal.security.utils.JavaUtils;
import towerdefense.EnemyRenderer;
import towerdefense.TowerMain;
import towerdefense.TowerRenderer;
import towerdefense.Window;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GUI {
	//if h concludes an image name, it denotes that it is the hovered version of an image
	public static BufferedImage resume, exit, resumeh, exith, menuBack, menuIconReg, menuIconOver;
    public static Font dataControl;

	public static void init() throws IOException {
		resume = ImageIO.read(new File("res/resume.png"));
		exit = ImageIO.read(new File("res/exit.png"));
		resumeh = ImageIO.read(new File("res/resumeh.png"));
		exith = ImageIO.read(new File("res/exith.png"));
        menuBack = ImageIO.read(new File("res/menuBack.png"));
        menuIconReg = ImageIO.read(new File("res/menuIconReg.png"));
        menuIconOver = ImageIO.read(new File("res/menuIconOver.png"));
        try {
            dataControl = Font.createFont(Font.TRUETYPE_FONT, new File("res/someTimeLater.otf"));

        } catch (Exception ex) {}
        System.out.println(dataControl);
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
