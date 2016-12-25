package GUI;

import static GUI.GUI.HUD;
import static GUI.GUI.menuBack;
import static GUI.GUI.menuIconOver;
import static GUI.GUI.menuIconReg;
import static towerdefense.TowerMain.mouseDown;
import static towerdefense.TowerMain.mouseX;
import static towerdefense.TowerMain.mouseY;
import static towerdefense.TowerMain.paused;
import static towerdefense.Window.height;
import static towerdefense.Window.width;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import kuusisto.tinysound.Music;
import kuusisto.tinysound.Sound;
import towerdefense.EnemyRenderer;
import towers.TowerControl;
import tracks.TrackRenderer;
import projectiles.ProjectileControl;

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
        g2d.drawImage(GUI.grass, 0, 0, towerdefense.Window.width, towerdefense.Window.height, null);
        TrackRenderer.render(g2d);
        EnemyRenderer.render(g2d);
        TowerControl.render(g2d);
        ProjectileControl.render(g2d);
        if (paused) {
        	renderMenu(g2d);
        	g2d.drawImage(HUD, 0, 0, width, height, null);
        } //HUD
        if(mouseX < menuCenterX + 15 && mouseY < menuCenterY + 15 && mouseX > menuCenterX - 15 && mouseY > menuCenterY - 15) { //Pause button
            g2d.drawImage(menuIconReg, menuCenterX - 15, menuCenterY - 15, 30, 30, null);
        } else {
            g2d.drawImage(menuIconOver, menuCenterX - 15, menuCenterY - 15, 30, 30, null);
        }
        renderShopBar();
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
        g2d.setComposite(AlphaComposite.getInstance(3, 0.7f));
        g2d.setColor(new Color(0, 255, 255));
        g2d.drawImage(menuBack, width / 2 - width / 8, height / 2 - height / 3, width / 4, height * 2 / 3, null); //Paused shading
        g2d.fillRect(0, 0, width, height); //Menu Background
        g2d.setComposite(AlphaComposite.getInstance(3, 1f));
        g2d.setColor(new Color(0, 0, 0));
        //g2d.setFont(dataControl);
        g2d.drawString("Sound Effects", width - 70, 60 + height / 36);
        g2d.drawString("Master Volume", width - 70, 60 + height / 40);
    }

    public static void renderShopBar() {

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

    public static Music getMusic() {
        return towerdefense.Sound.transmissionStream;
    }
}
