package BoringStuff;

import BoringSprites.Bomb;
import BoringSprites.Particle;
import BoringSprites.Shooty;
import java.awt.*;
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
        particles.add(p);
    }
//ADDING SPECIFIC
    public void addParticle(ArrayList<Particle> particles, Particle thisParticle){
        particles.add(thisParticle);
    }
//CREATING EXPLOSION
    public void KaBoom(ArrayList<Particle> particles, int x, int y, Color color, int num){
        for (int i = 0; i<num; i++){ addParticle(particles,x,y,color);}
    }
    public void KaBoom(ArrayList<Particle> particles, int x, int y){
        KaBoom(particles, x, y, Color.RED, 3); 
        KaBoom(particles, x, y, Color.ORANGE, 3);  
        KaBoom(particles, x, y, Color.YELLOW, 3);
    }
    public void BigKaBoom(ArrayList<Particle> particles, int x, int y, int w, int h){
        KaBoom(particles,x,y); 
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
        int x = guy.getXPos()+guy.getWidth()/2;
        int y = guy.getYPos()+guy.getHeight()/2;
        addParticle(particles, guy.getParticle(x, y, dir));
    }
    public void muzzleFlash(ArrayList<Particle> particles, Shooty guy){
        int x = guy.getXPos();
        int y = guy.getYPos();
        int w = guy.getWidth();
        int h = guy.getHeight();
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
    public void DrawAllParticles(CopyOnWriteArrayList<Particle> particles, Graphics window){
        for(int i = 0; i <= particles.size() - 1;i++){ particles.get(i).draw(window);}
    }
}