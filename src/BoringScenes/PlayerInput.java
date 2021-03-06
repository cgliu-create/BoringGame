package BoringScenes;

import BoringSprites.Enemy;
import BoringSprites.Particle;
import BoringSprites.Player;
import BoringEffects.ParticleEffects;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class PlayerInput implements KeyListener {
//Player
    private Player player = new Player(100,100,50,50, 100,100);
//Pew pew
    private ArrayList<Particle> particles = new ArrayList<>();
    private ParticleEffects particleEffects = new ParticleEffects();
//ACCESSING PLAYER AND PARTICLES
    public Player getPlayer(){ return player;}
    public ArrayList<Particle> getParticles(){ return particles;}
//CHANGING PLAYER AND PARTICLES
    public void setPlayer(Player newplayer){ player = newplayer;}
    public void setParticles(ArrayList<Particle> newparticles){ particles = newparticles;}
    public void resetPlayer(){
        player.setXPos(100);
        player.setYPos(100);
        player.setDir(0);
        player.setSpeed(0);
    }
//KEYLISTENING
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyPressed(KeyEvent e) {
    //accelerate
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if(player.checkIfAlive()){
                if(player.getSpeed()>-4){ player.setSpeed(player.getSpeed()-2);}
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if(player.checkIfAlive()){
                if(player.getSpeed()<4){ player.setSpeed(player.getSpeed()+2);}
            }
        }
    //turn
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if(player.checkIfAlive()) {
                player.turnLeft();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if(player.checkIfAlive()){
                player.turnRight();
            }
        }
    //change bullet type
        if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
            player.switchBullet();
        }
        if (e.getKeyCode() == KeyEvent.VK_1) {
            player.switchBullet(0);
        }
        if (e.getKeyCode() == KeyEvent.VK_2) {
            player.switchBullet(1);
        }
        if (e.getKeyCode() == KeyEvent.VK_3) {
            player.switchBullet(2);
        }
        if (e.getKeyCode() == KeyEvent.VK_4) {
            player.switchBullet(3);
        }
        if (e.getKeyCode() == KeyEvent.VK_5) {
            player.switchBullet(4);
        }
        if (e.getKeyCode() == KeyEvent.VK_6) {
            player.switchBullet(5);
        }
    //shoot
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if(player.checkIfAlive()) {
                if (player.getMP() > 0) {
                    particleEffects.Shoot(particles, player);
                    player.setMP(player.getMP() - 1);
                }
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_R) {
            player.changeMP(10);
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }
    //testing
}