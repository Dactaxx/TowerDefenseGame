package GUI;

import towerdefense.EnemyRenderer;
import towerdefense.TowerMain;
import towerdefense.TowerRenderer;
import towerdefense.Window;

import java.awt.*;

import static GUI.GUI.*;
import static towerdefense.TowerMain.*;
import static towerdefense.Window.height;
import static towerdefense.Window.width;

public class Game {

    public static int menuDropInc = 0;
    public static boolean clicked = false;
    public static double clickedX = 0;
    public static double clickedY = 0;

    public static void render(Graphics2D g2d) {
        TowerRenderer.render(g2d);
        EnemyRenderer.render(g2d);
        renderMenu(g2d);
    }

    public static void tick() {
        if(mouseDown && !clicked) {
            clicked = true;
            clickedX = mouseX;
            clickedY = mouseY;
        }
        if(!mouseDown && clicked)
            clicked();

        if(paused && menuDropInc < height / 4)
            menuDropInc += 10;
        if(!paused && menuDropInc > 0)
            menuDropInc -= 10;
        if(menuDropInc < 0)
            menuDropInc = 0;
        if(menuDropInc > height / 4)
            menuDropInc = height / 4;
        if(paused) {



        }
    }

    public static void renderMenu(Graphics2D g2d) {
        if(mouseX < width - 30 && mouseY < 60 && mouseX > width - 60 && mouseY > 30) {
            g2d.drawImage(menuIconReg, width - 60, 30, 30, 30, null);
        } else {
            g2d.drawImage(menuIconOver, width - 60, 30, 30, 30, null);
        }
        g2d.setColor(new Color(0, 0, 0));
        g2d.drawImage(menuBack, width - 90, height / 4, width - 1, menuDropInc, null);
        if (menuDropInc > height / 40) { //Top row
            //g2d.setFont(dataControl);
            g2d.drawString("Sound Effects", width - 70, 60 + height / 36);
            g2d.drawString("Master Volume", width - 70, 60 + height / 40);
        }
    }

    public static void clicked() {
        clicked = false;
        if(mouseX < width - 30 && mouseY < 60 && mouseX > width - 60 && mouseY > 30 && clickedX < width - 30 && clickedY < 60 && clickedX > width - 60 && clickedY > 30) {
            if(paused) {
                paused = false;
            } else {
                paused = true;
            }
        }
    }
}
