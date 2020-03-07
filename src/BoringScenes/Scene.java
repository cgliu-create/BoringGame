package BoringScenes;
import BoringSprites.Player;

import javax.swing.*;

public abstract class Scene extends JPanel {
    private PlayerInput playerInput = new PlayerInput();
    private int w,h;
    public Scene(int W, int H) {
        setSize(W,H);
        w=W;h=H;
    }
    public int getW() { return w; }
    public int getH() { return h; }
    public void updateSprite() {
        Player player = playerInput.getPlayer();
        int x = player.getXPos()+player.getXspeed();
        int y = player.getYPos()+player.getYspeed();
        if (x>=0&&x<=w-player.getWidth()) //x bounds
            player.setXPos(x);
        if (y>=0&&y<=h-player.getHeight()) //y bounds
            player.setYPos(y);
    }
    public Player getPlayer(){
        return playerInput.getPlayer();
    }
    public void setPlayer(Player newplayer){ playerInput.setPlayer(newplayer); }
    public PlayerInput getPlayerInput(){
        return playerInput;
    }
    //public void update(Graphics window) {}
    //public void paint(Graphics window) {}
}
