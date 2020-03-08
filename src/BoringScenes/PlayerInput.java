package BoringScenes;
import BoringSprites.Particle;
import BoringSprites.Player;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class PlayerInput implements KeyListener {
    //player
    private Player player = new Player(100,100,100,100, 100,100);
    //pew pew
    ArrayList<Particle> particles = new ArrayList<>();
    private ParticleEffects particleEffects = new ParticleEffects();
    //get and set methods
    public ParticleEffects getParticleEffects() {
        return particleEffects;
    }
    public Player getPlayer(){
        return player;
    }
    public ArrayList<Particle> getParticles(){
        return particles;
    }
    public void setPlayer(Player newplayer){
        player = newplayer;
    }
    public void setParticles(ArrayList<Particle> newparticles){
        particles = newparticles;
    }
    //keylistener
    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            player.setSpeed(0);
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            player.setSpeed(3);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            int dir = player.getDir();
            player.setDir(dir - 45);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            int dir = player.getDir();
            player.setDir(dir + 45);
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            particleEffects.Shoot(particles, player);
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }
}
