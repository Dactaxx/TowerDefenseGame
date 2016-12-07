package GUI;

import towerdefense.*;

import java.awt.*;
import java.awt.Window;

import static GUI.GUI.resume;

public class Menu {
    public static void render(Graphics2D g2d) {
        g2d.setColor(new Color(0, 49, 100));
        g2d.drawString("HELLO!", 20, 20);
    }

    public static void tick() {

        if(TowerMain.paused && TowerMain.mouseX >(towerdefense.Window.width - resume.getWidth()) / 2 && TowerMain.mouseX < (towerdefense.Window.width - resume.getWidth()) / 2 + resume.getWidth() && TowerMain.mouseY > (towerdefense.Window.height - (resume.getHeight() * 2 + 50)) / 2 + resume.getHeight() + 50 && TowerMain.mouseY < (towerdefense.Window.height - (resume.getHeight() * 2 + 50)) / 2 + resume.getHeight() + 50 + resume.getHeight() && TowerMain.mouseDown) {
            System.exit(1);

        }

        if(TowerMain.paused && TowerMain.mouseX >(towerdefense.Window.width - resume.getWidth()) / 2 && TowerMain.mouseX < (towerdefense.Window.width - resume.getWidth()) / 2 + resume.getWidth() && TowerMain.mouseY > (resume.getHeight() * 2 + 50) / 2 && TowerMain.mouseY < (towerdefense.Window.height - (resume.getHeight() * 2 + 50)) / 2 + resume.getHeight() && TowerMain.mouseDown) {
            TowerMain.state = TowerMain.GAME;

        }

    }
}
