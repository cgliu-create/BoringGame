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
            if(player.getSpeed()>-4){ player.setSpeed(player.getSpeed()-2);}
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if(player.getSpeed()<4){ player.setSpeed(player.getSpeed()+2);}
        }
    //turn
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            player.turnLeft();
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            player.turnRight();
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
        if (e.getKeyCode() == KeyEvent.VK_T) {
            testenemy.turnRight();
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }
    //testing
    private Enemy testenemy = new Enemy(400,400,50,50,100,100);
    public Enemy getTestenemy() {
        return testenemy;
    }
}