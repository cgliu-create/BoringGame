package BoringScenes;
import BoringSprites.Particle;
import BoringSprites.Player;
import BoringStuff.PlayerInput;
import javax.swing.*;
import java.util.ArrayList;

public abstract class Scene extends JPanel {
    private PlayerInput playerInput = new PlayerInput();
    private int w,h;
    int scenenum;
    public Scene(int W, int H, int scenenum) {
        setSize(W,H);
        w=W;h=H;
        this.scenenum = scenenum;
    }
    public int getScenenum() { return scenenum; }
    public int getW() { return w; }
    public int getH() { return h; }
    public void setScenenum(int scenenum) { this.scenenum = scenenum; }
    public void setW(int w) { this.w = w; }
    public void setH(int h) { this.h = h; }
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
    //to be implemented
    public abstract void updatePlayer();
    public abstract void updateOther();
    //public void update(Graphics window) {}
    //public void paint(Graphics window) {}
}
