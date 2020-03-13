package BoringSprites;

import BoringImages.ImageGetter;
import BoringObjects.AliveObject;
import java.awt.*;
import java.util.ArrayList;

public class Enemy extends Shooty {
//Image
    private ImageGetter i = new ImageGetter();
    private int img;
//CONSTRUCTING 
    public Enemy(int x, int y, int wd, int ht, int hp, int mp) {
        super(x, y, wd, ht, hp, mp);
    }
//MAKING ATTACK
    public void attack(ArrayList<Particle> badparticles, AliveObject player){
        getAiming().checkEnemyInSight(badparticles, player);
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
        drawAim(window);
        i.DrawImage(window,getXPos(),getYPos(),img,getWidth(),getHeight());
    }
}