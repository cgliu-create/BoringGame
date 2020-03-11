package BoringStuff;
import BoringSprites.Particle;
import BoringSprites.Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class PlayerInput implements KeyListener {
    //player
    private Player player = new Player(100,100,70,70, 100,100);
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
            if(player.getSpeed()>-4)
                player.setSpeed(player.getSpeed()-2);
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if(player.getSpeed()<4)
                player.setSpeed(player.getSpeed()+2);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            int dir = player.getDir();
            player.setDir(dir - 45);
            if(player.getDir()==0){
                player.setDir(360);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            int dir = player.getDir();
            player.setDir(dir + 45);
            if(player.getDir()==720){
                player.setDir(360);
            }
        }
        // for fun
        if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
            player.switchBullet();
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if(player.getMP()>0){
                int x = player.getXPos();
                int y = player.getYPos();
                int w = player.getWidth();
                int h = player.getHeight();
                if(Math.abs(player.getDir())%360==0)
                    particleEffects.KaBoom(particles, x+w, y+h/2);
                if(Math.abs(player.getDir())%360==45)
                    particleEffects.KaBoom(particles, x+w, y+h);
                if(Math.abs(player.getDir())%360==90)
                    particleEffects.KaBoom(particles, x+w/2, y+h);
                if(Math.abs(player.getDir())%360==135)
                    particleEffects.KaBoom(particles, x, y+h);
                if(Math.abs(player.getDir())%360==180)
                    particleEffects.KaBoom(particles, x, y+h/2);
                if(Math.abs(player.getDir())%360==225)
                    particleEffects.KaBoom(particles, x, y);
                if(Math.abs(player.getDir())%360==270)
                    particleEffects.KaBoom(particles, x+w/2, y);
                if(Math.abs(player.getDir())%360==315)
                    particleEffects.KaBoom(particles, x+w, y);
                //nice
                particleEffects.Shoot(particles, player);
                player.setMP(player.getMP()-1);
            }
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        //if(player.getSpeed()!=0)
        //    player.setSpeed(0);
    }
}
