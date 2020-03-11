package BoringScenes;
import BoringObjects.GameObject;
import BoringSprites.Particle;
import BoringSprites.Player;
import BoringStuff.PlayerInput;
import javax.swing.*;
import java.util.ArrayList;

public abstract class Scene extends JPanel {
    //player input includes player and player particles
    private PlayerInput playerInput = new PlayerInput();
    //other objects
    private ArrayList<Particle> badparticles = new ArrayList<>();
    private ArrayList<GameObject> Obstructions = new ArrayList<>();
    //panel size
    private int w,h;
    //scene number/status
    private int scenenum;
    public Scene(int W, int H, int scenenum) {
        setSize(W,H);
        w=W;h=H;
        this.scenenum = scenenum;
    }
    //changing scenes
    public int getScenenum() { return scenenum; }
    public void setScenenum(int scenenum) { this.scenenum = scenenum; }
    //size
    public int getW() { return w; }
    public int getH() { return h; }
    public void setW(int w) { this.w = w; }
    public void setH(int h) { this.h = h; }
    //get and set from player input
    public Player getPlayer(){
        return playerInput.getPlayer();
    }
    public ArrayList<Particle> getParticles(){ return playerInput.getParticles(); }
    public void setPlayer(Player newplayer){ playerInput.setPlayer(newplayer); }
    public void setParticles(ArrayList<Particle> newparticles){ playerInput.setParticles(newparticles); }
    //get other particles and obstructions
    public ArrayList<Particle> getBadparticles() { return badparticles; }
    public ArrayList<GameObject> getObstructions() { return Obstructions; }
    public void setBadparticles(ArrayList<Particle> badparticles) { this.badparticles = badparticles; }
    public void setObstructions(ArrayList<GameObject> obstructions) { Obstructions = obstructions; }
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
