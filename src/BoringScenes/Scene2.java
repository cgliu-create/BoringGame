package BoringScenes;
import BoringObjects.GameObject;
import BoringSprites.Enemy;
import BoringSprites.JustImage;
import BoringSprites.Player;

import java.awt.*;

public class Scene2 extends Scene {
    Player player = super.getPlayer();
    Player temp = new Player(player.getXPos(),player.getYPos(),player.getWidth(),player.getHeight(),0,0);
    private Enemy enemy = new Enemy(300,100,100,100, 100, 100);
    private JustImage background = new JustImage(0,0, getW(), getH(),9);
    public Scene2(int W, int H) {
        super(W, H);
        //setBackground(Color.black);
        setVisible(true);
    }

    public void update(Graphics window) { paint(window);}
    public void paint(Graphics window) {
        background.draw(window);
        enemy.draw(window);
        super.getPlayer().draw(window);}
}