package GUI;

import towerdefense.EnemyRenderer;
import towerdefense.TowerMain;
import towerdefense.TowerRenderer;
import towerdefense.Window;

import java.awt.*;

import static GUI.GUI.*;

public class Game {

    public static void render(Graphics2D g2d) {
        TowerRenderer.render(g2d);
        EnemyRenderer.render(g2d);
        if(TowerMain.paused) {
            renderMenu(g2d);
        }
    }

    public static void tick() {

    }

    public static void renderMenu(Graphics2D g2d) {
        g2d.drawImage(resume, (Window.width - resume.getWidth()) / 2, (Window.height - (resume.getHeight() * 2 + 50)) / 2, null);
        g2d.drawImage(exit, (Window.width - exit.getWidth()) / 2, (Window.height - (exit.getHeight() * 2 + 50)) / 2 + exit.getHeight() + 50, null);

        if(TowerMain.mouseX >(Window.width - exith.getWidth()) / 2 && TowerMain.mouseX < (Window.width - resume.getWidth()) / 2 + resume.getWidth() && TowerMain.mouseY > (Window.height - (resume.getHeight() * 2 + 50)) / 2 + resume.getHeight() + 50 && TowerMain.mouseY < (Window.height - (resume.getHeight() * 2 + 50)) / 2 + resume.getHeight() + 50 + resume.getHeight()) {
            g2d.drawImage(exith, (Window.width - exith.getWidth()) / 2, (Window.height - (exith.getHeight() * 2 + 50)) / 2 + exith.getHeight() + 50, null);

        }

        if(TowerMain.mouseX >(Window.width - resume.getWidth()) / 2 && TowerMain.mouseX < (Window.width - resume.getWidth()) / 2 + resume.getWidth() && TowerMain.mouseY > (Window.height - (resume.getHeight() * 2 + 50)) / 2 && TowerMain.mouseY < (Window.height - (resume.getHeight() * 2 + 50)) / 2 + resume.getHeight()) {
            g2d.drawImage(resumeh, (Window.width - resumeh.getWidth()) / 2, (Window.height - (resumeh.getHeight() * 2 + 50)) / 2, null);

        }
    }
}
