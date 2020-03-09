package BoringStuff;

import BoringSprites.Bomb;
import BoringSprites.Particle;
import BoringSprites.Shooty;

import java.awt.*;
import java.util.ArrayList;

public class ParticleEffects {
    // Particle Stuff
    public void RemoveParticles(ArrayList<Particle> particles){
        for(int i = particles.size()- 1; i>=0; i--){
            if(particles.get(i).update()) { // changes particle values, removes if life = 0
                Particle p = particles.get(i);
                if (p instanceof Bomb) {
                    KaBoom(particles, p.getXPos(), p.getYPos());
                    KaBoom(particles, p.getXPos(), p.getYPos() + p.getHeight() / 2);
                    KaBoom(particles, p.getXPos(), p.getYPos() - p.getHeight() / 2);
                    KaBoom(particles, p.getXPos() + p.getWidth() / 2, p.getYPos());
                    KaBoom(particles, p.getXPos() - p.getWidth() / 2, p.getYPos());
                }
                particles.remove(i);
            }
        }
    }
    public void DrawAllParticles(ArrayList<Particle> particles, Graphics window){
        for(int i = 0; i <= particles.size() - 1;i++){
            particles.get(i).draw(window); // draws/redraw all particles
        }
    }
    //random particle
    public void addParticle(ArrayList<Particle> particles, int x, int y, Color c){
        int spd = (int)(Math.random()*2)+2;
        int dir = (int)(Math.random()*360);
        int size = (int) (Math.random()*10)+2;
        int life = (int) (Math.random()*50)+10;
        Particle p = new Particle(x,y,size,size,life,0, c);
        p.setDir(dir);
        p.setSpeed(spd);
        particles.add(p);
    }
    // cool stuff
    public void KaBoom(ArrayList<Particle> particles, int x, int y){
        addParticle(particles,x,y,Color.RED); addParticle(particles,x,y,Color.RED);
        addParticle(particles,x,y,Color.ORANGE); addParticle(particles,x,y,Color.ORANGE);
        addParticle(particles,x,y,Color.YELLOW); addParticle(particles,x,y,Color.YELLOW);
        addParticle(particles,x,y,Color.RED); addParticle(particles,x,y,Color.RED);
        addParticle(particles,x,y,Color.ORANGE); addParticle(particles,x,y,Color.ORANGE);
        addParticle(particles,x,y,Color.YELLOW); addParticle(particles,x,y,Color.YELLOW);
    }
    public void KaBoom(ArrayList<Particle> particles, int x, int y, Color color, int num){
        for (int i = 0; i<num; i++) {
            addParticle(particles,x,y,color);
        }
    }
    //add specific particle
    public void addParticle(ArrayList<Particle> particles, Particle thisParticle){
        //shoots bombs
        particles.add(thisParticle);
    }
    public void Shoot(ArrayList<Particle> particles, Shooty guy){
        int dir = 0;
        if(Math.abs(guy.getDir())%360==0)
            dir = 0;
        if(Math.abs(guy.getDir())%360==45)
            dir = 45;
        if(Math.abs(guy.getDir())%360==90)
            dir = 90;
        if(Math.abs(guy.getDir())%360==135)
            dir = 135;
        if(Math.abs(guy.getDir())%360==180)
            dir = 180;
        if(Math.abs(guy.getDir())%360==225)
            dir = 225;
        if(Math.abs(guy.getDir())%360==270)
            dir = 270;
        if(Math.abs(guy.getDir())%360==315)
            dir = 315;
        int x = guy.getXPos()+guy.getWidth()/2;
        int y = guy.getYPos()+guy.getHeight()/2;
        addParticle(particles, guy.getParticle(x, y, dir));
    }
}