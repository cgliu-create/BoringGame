package BoringStuff;

import BoringSprites.Particle;
import BoringSprites.Player;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class PlayerInput implements KeyListener {
//Player
    private Player player = new Player(100,100,70,70, 100,100);
//Pew pew
    private ArrayList<Particle> particles = new ArrayList<>();
    private ParticleEffects particleEffects = new ParticleEffects();
//ACCESSING PLAYER AND PARTICLES
    public Player getPlayer(){ return player;}
    public ArrayList<Particle> getParticles(){ return particles;}
//CHANGING PLAYER AND PARTICLES
    public void setPlayer(Player newplayer){ player = newplayer;}
    public void setParticles(ArrayList<Particle> newparticles){ particles = newparticles;}
//KEYLISTENING
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyPressed(KeyEvent e) {
    //accelerate
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if(player.getSpeed()>-4){ player.setSpeed(player.getSpeed()-2);}
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if(player.getSpeed()<4){ player.setSpeed(player.getSpeed()+2);}
        }
    //turn
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            player.setDir(player.getDir() - 45);
            if(player.getDir()==0){ player.setDir(360);}
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.setDir(player.getDir() + 45);
            if(player.getDir()==720){ player.setDir(360);}
        }
    //change bullet type
        if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
            player.switchBullet();
        }
    //shoot
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if(player.getMP()>0){
                particleEffects.Shoot(particles, player);
                player.setMP(player.getMP()-1);
            }
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {}
}