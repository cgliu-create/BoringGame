package BoringScenes;
import BoringSprites.Particle;
import BoringSprites.Player;
import javax.swing.*;
import java.util.ArrayList;

public abstract class Scene extends JPanel {
    private PlayerInput playerInput = new PlayerInput();
    private int w,h;
    public Scene(int W, int H) {
        setSize(W,H);
        w=W;h=H;
    }
    public int getW() { return w; }
    public int getH() { return h; }
    public void updatePlayer() {
        Player player = playerInput.getPlayer();
        int x = player.getXPos()+player.getXspeed();
        int y = player.getYPos()+player.getYspeed();
        if (x>=0&&x<=w-player.getWidth()) //x bounds
            player.setXPos(x);
        if (y>=0&&y<=h-player.getHeight()) //y bounds
            player.setYPos(y);
    }
    // get and set from player input
    public Player getPlayer(){
        return playerInput.getPlayer();
    }
    public ArrayList<Particle> getParticles(){ return playerInput.getParticles(); }
    public void setPlayer(Player newplayer){ playerInput.setPlayer(newplayer); }
    public void setParticles(ArrayList<Particle> newparticles){ playerInput.setParticles(newparticles); }
    //get player input
    public PlayerInput getPlayerInput(){
        return playerInput;
    }
    public ParticleEffects getParticleEffects() {
        return playerInput.getParticleEffects();
    }
    //public void update(Graphics window) {}
    //public void paint(Graphics window) {}
    public abstract void updateOther();
}
