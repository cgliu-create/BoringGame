package CLOO;

import javax.swing.*;
import java.awt.*;

public class Scene extends JPanel {
    private SpritePlayer player = new SpritePlayer(100,100,100,100);
    public Scene(int W, int H) {
        setSize(W,H);
        setBackground(Color.black);
    }
    //update data
    public void movePlayer(){
        int x = player.getXPos(); int y = player.getYPos();
        int xs = player.getxSpeed(); int ys = player.getySpeed();
        player.setXPos(x+xs); player.setYPos(y+ys);
    }
    public void rotPlayerL(){
        int dir = player.getDir();
        player.setDir(dir + 45);
    }
    public void rotPlayerR(){
        int dir = player.getDir();
        player.setDir(dir - 45);
    }
    public void accelPlayerF(){
        int spd = player.getSpeed();
        player.setSpeed(spd + 1);
    }
    public void accelPlayerB(){
        int spd = player.getSpeed();
        player.setSpeed(spd - 1);
    }
    //repaint
    public void update(Graphics window) {
        paint(window);
    }
    public void paint(Graphics window) {
        player.draw(window);
    }
}
