package GUI;

import towerdefense.EnemyRenderer;
import towers.TowerControl;

import java.awt.*;

import static GUI.GUI.*;
import static towerdefense.TowerMain.*;
import static towerdefense.Window.height;
import static towerdefense.Window.width;

public class Game {

    public static int menuHeight, menuWidth, menuCenterX, menuCenterY;
    public static boolean clicked = false;
    public static double clickedX = 0;
    public static double clickedY = 0;

    public static void render(Graphics2D g2d) {
        menuHeight = height / 2;
        menuWidth = width / 10;
        menuCenterX = width - width / 8;
        menuCenterY = height / 4;
        TowerControl.render(g2d);
        EnemyRenderer.render(g2d);
        if (paused)
        renderMenu(g2d);
        g2d.drawImage(visor, 0, 0, width, height, null);
        if(mouseX < menuCenterX + 15 && mouseY < menuCenterY + 15 && mouseX > menuCenterX - 15 && mouseY > menuCenterY - 15) {
            g2d.drawImage(menuIconReg, menuCenterX - 15, menuCenterY - 15, 30, 30, null);
        } else {
            g2d.drawImage(menuIconOver, menuCenterX - 15, menuCenterY - 15, 30, 30, null);
        }

    }

    public static void tick() {
        if(mouseDown && !clicked) {
            clicked = true;
            clickedX = mouseX;
            clickedY = mouseY;
        }
        if(!mouseDown && clicked)
            clicked();

        if(paused) {



        }
    }

    public static void renderMenu(Graphics2D g2d) {
        g2d.drawImage(menuBack, 0, 0, width, height, null); //Menu Background
        g2d.setColor(new Color(0, 0, 0));
        //g2d.setFont(dataControl);
        g2d.drawString("Sound Effects", width - 70, 60 + height / 36);
        g2d.drawString("Master Volume", width - 70, 60 + height / 40);
    }

    public static void shopBar() {

    }

    public static void clicked() {
        clicked = false;
        if(mouseX < menuCenterX + 15 && mouseY < menuCenterY + 15 && mouseX > menuCenterX - 15 && mouseY > menuCenterY - 15 && clickedX < menuCenterX + 15 && clickedY < menuCenterY + 15 && clickedX > menuCenterX - 15 && clickedY > menuCenterY - 15) {
            if(paused) {
                paused = false;
            } else {
                paused = true;
            }
        }
    }
}
