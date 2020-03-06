package CLOO;
import java.awt.*;
public class Scene1 extends Scene{
    private int w,h;
    private SpritePlayer player = new SpritePlayer(100,100,100,100);
    public Scene1(int W, int H) {
        super(W, H); w = W; h = H;
    }
    //update data
    public void ActionLeft(){
        int dir = player.getDir();
        player.setDir(dir + 45);
    }
    public void ActionRight(){
        int dir = player.getDir();
        player.setDir(dir - 45);
    }
    public void ActionDown(){
        int spd = player.getSpeed();
        player.setSpeed(spd - 1);
    }
    public void ActionUp(){
        int spd = player.getSpeed();
        player.setSpeed(spd + 1);
    }
    public void updateSprite() {
        int x = player.getXPos()+player.getxSpeed();
        int y = player.getYPos()+player.getySpeed();
        if (x>=0&&x<=w-player.getWidth()) //x bounds
            player.setXPos(x);
        if (y>=0&&y<=h-player.getHeight()) //y bounds
            player.setYPos(y);
    }
    public void update(Graphics window) { paint(window);}
    public void paint(Graphics window) {player.draw(window);}
}
