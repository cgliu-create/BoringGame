package BoringSprites;

import BoringImages.ImageGetter;
import BoringObjects.AliveObject;
import BoringStuff.EnemyAI;
import java.awt.*;
import java.util.ArrayList;

public class Enemy extends Shooty {
//Image
    private ImageGetter i = new ImageGetter();
    private int img;
//Behavior
    private EnemyAI ai;
//CONSTRUCTING 
    public Enemy(int x, int y, int wd, int ht, int hp, int mp) {
        super(x, y, wd, ht, hp, mp); ai = new EnemyAI(this);
    }
//ATTACKING
    public void attack(ArrayList<Particle> badparticles, AliveObject player){
        ai.checkEnemyInSight(badparticles, player);
    }
//RENDERING 
    @Override
    public void draw(Graphics window) {
        if(Math.abs(getDir())%360==0){ img = 8;}
        if(Math.abs(getDir())%360==45){ img = 9;}
        if(Math.abs(getDir())%360==90){ img = 10;}
        if(Math.abs(getDir())%360==135){ img = 11;}
        if(Math.abs(getDir())%360==180){ img = 12;} 
        if(Math.abs(getDir())%360==225){ img = 13;}    
        if(Math.abs(getDir())%360==270){ img = 14;} 
        if(Math.abs(getDir())%360==315){ img = 15;}
        i.DrawImage(window,getXPos(),getYPos(),img,getWidth(),getHeight());
    }
}