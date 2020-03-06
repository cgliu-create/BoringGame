package CLOO;
import javax.swing.*;
import java.awt.*;
public abstract class Scene extends JPanel {
    private PlayerInput playerInput = new PlayerInput();
    private int w,h;
    public Scene(int W, int H) {
        setSize(W,H);
        w=W;h=H;
    }
    public void updateSprite() {
        SpritePlayer player = playerInput.getPlayer();
        int x = player.getXPos()+player.getxSpeed();
        int y = player.getYPos()+player.getySpeed();
        if (x>=0&&x<=w-player.getWidth()) //x bounds
            player.setXPos(x);
        if (y>=0&&y<=h-player.getHeight()) //y bounds
            player.setYPos(y);
    }
    public SpritePlayer getPlayer(){
        return playerInput.getPlayer();
    }
    public void setPlayer(SpritePlayer newplayer){ playerInput.setPlayer(newplayer); }
    public PlayerInput getPlayerInput(){
        return playerInput;
    }
    //public void update(Graphics window) {}
    //public void paint(Graphics window) {}
}
