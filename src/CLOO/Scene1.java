package CLOO;

import javax.swing.*;
import java.awt.*;

public class Scene1 extends JPanel {
    private SpritePlayer player = new SpritePlayer(100,100,100,100);
    public Scene1(int W, int H) {
        setSize(W,H);
        setBackground(Color.cyan);
        player.setSpeed(1);
        player.setDir(0);
    }
    //update data
    public void movePlayer(){
        int x = player.getXPos(); int y = player.getYPos();
        int xs = player.getxSpeed(); int ys = player.getySpeed();
        player.setXPos(x+xs); player.setYPos(y+ys);
    }
    //repaint
    public void update(Graphics window) {
        paint(window);
    }
    public void paint(Graphics window) {
        player.draw(window);
    }
}
