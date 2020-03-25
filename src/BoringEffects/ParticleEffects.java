package BoringEffects;

import BoringSprites.*;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class ParticleEffects {
//REMOVING
    public void RemoveParticles(ArrayList<Particle> particles){
        ArrayList<Particle> toRemove = new ArrayList<>();
        for(int i = particles.size()- 1; i>=0; i--){
            if(particles.get(i).update()) {//changes particle values, removes if life = 0
                Particle p = particles.get(i);
                if (p instanceof Bomb) { BigKaBoom(particles, p.getXPos(), p.getYPos(), p.getWidth(), p.getHeight());}
                if (p instanceof Grenade) { ShootAllDir(particles, (Grenade)p);}
                if (p instanceof Bomba) { ShootAllDir(particles, (Bomba)p);}
                if (p instanceof LavaBall) { BigKaBoom(particles, p.getCenterX(), p.getCenterY(), p.getWidth(), p.getHeight());}
                toRemove.add(particles.get(i));
            }
        }//explodes regardless if timer/life runs out
        particles.removeAll(toRemove);
        toRemove.clear();
    }
//ADDING RANDOM
    public void addParticle(ArrayList<Particle> particles, int x, int y, Color c){
        int spd = (int)(Math.random()*2)+2; int dir = (int)(Math.random()*360);
        int size = (int) (Math.random()*10)+2; int life = (int) (Math.random()*50)+10;
        Particle p = new Particle(x,y,size,size,life,0,c);
        p.setSpeed(spd); p.setDir(dir); 
        particles.add(p); // random speed, size, direction and duration
    }
//ADDING SPECIFIC
    public void addParticle(ArrayList<Particle> particles, Particle thisParticle){
        particles.add(thisParticle);
    }
//CREATING EXPLOSION
    public void KaBoom(ArrayList<Particle> particles, int x, int y, Color color, int num){
        for (int i = 0; i<num; i++){ addParticle(particles,x,y,color);} //set number of random particles
    }
    public void KaBoom(ArrayList<Particle> particles, int x, int y){
        KaBoom(particles, x, y, Color.RED, 3); 
        KaBoom(particles, x, y, Color.ORANGE, 3);  
        KaBoom(particles, x, y, Color.YELLOW, 3);
    }
    public void BigKaBoom(ArrayList<Particle> particles, int x, int y, int w, int h){
        KaBoom(particles,x,y); //Kaboom with 4 more in 4 directions
        KaBoom(particles,x,y+h/2);
        KaBoom(particles,x,y-h/2);
        KaBoom(particles,x+w/2,y);
        KaBoom(particles,x-w/2,y);
    }
//SHOOTING
    public void Shoot(ArrayList<Particle> particles, Shooty guy){
        int dir = 0;
        if(Math.abs(guy.getDir())%360==0){ dir = 0;}
        if(Math.abs(guy.getDir())%360==45){ dir = 45;}      
        if(Math.abs(guy.getDir())%360==90){ dir = 90;}       
        if(Math.abs(guy.getDir())%360==135){ dir = 135;}    
        if(Math.abs(guy.getDir())%360==180){ dir = 180;}
        if(Math.abs(guy.getDir())%360==225){ dir = 225;}
        if(Math.abs(guy.getDir())%360==270){ dir = 270;}
        if(Math.abs(guy.getDir())%360==315){ dir = 315;}
        int x = guy.getCenterX();
        int y = guy.getCenterY();
        muzzleFlash(particles, guy);
        addParticle(particles, guy.getParticle(x, y, dir)); //shoots a specific particle from center in dir
    }
    public void ShootThere(ArrayList<Particle> particles, Shooty guy,int dir){
        int x = guy.getCenterX();
        int y = guy.getCenterY();
        muzzleFlash(particles, guy);
        addParticle(particles, guy.getParticle(x, y, dir)); //shoots a specific particle from center in dir
    }
    public void ShootAllDir(ArrayList<Particle> particles, Shooty guy){
        ShootThere(particles,guy,0);
        ShootThere(particles,guy,45);
        ShootThere(particles,guy,90);
        ShootThere(particles,guy,135);
        ShootThere(particles,guy,180);
        ShootThere(particles,guy,225);
        ShootThere(particles,guy,270);
        ShootThere(particles,guy,315);
    }
    public void muzzleFlash(ArrayList<Particle> particles, Shooty guy){
        int x = guy.getXPos();
        int y = guy.getYPos();
        int w = guy.getWidth();
        int h = guy.getHeight(); //explosion off center
        if(Math.abs(guy.getDir())%360==0){ KaBoom(particles, x+w, y+h/2);}
        if(Math.abs(guy.getDir())%360==45){ KaBoom(particles, x+w, y+h);}
        if(Math.abs(guy.getDir())%360==90){ KaBoom(particles, x+w/2, y+h);}
        if(Math.abs(guy.getDir())%360==135){ KaBoom(particles, x, y+h);}    
        if(Math.abs(guy.getDir())%360==180){ KaBoom(particles, x, y+h/2);}
        if(Math.abs(guy.getDir())%360==225){ KaBoom(particles, x, y);}
        if(Math.abs(guy.getDir())%360==270){ KaBoom(particles, x+w/2, y);}
        if(Math.abs(guy.getDir())%360==315){ KaBoom(particles, x+w, y);}   
    }
//RENDERING
    public void DrawAllParticles(CopyOnWriteArrayList<Particle> particles, Graphics window) throws IOException {
        for(int i = 0; i <= particles.size() - 1;i++){ particles.get(i).draw(window);}
    }
}