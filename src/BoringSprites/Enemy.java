package BoringSprites;

import BoringEffects.ParticleEffects;
import BoringImages.BoringImage;
import BoringImages.ImageGetter;
import BoringObjects.AliveObject;
import BoringStuff.EnemyAI;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Enemy extends Shooty {
    //Effect
    private ParticleEffects particleEffects = new ParticleEffects();
//Image
    private ImageGetter i = new ImageGetter();
    private String img;
//Behavior
    private EnemyAI ai;
//CONSTRUCTING 
    public Enemy(int x, int y, int wd, int ht, int hp, int mp) {
        super(x, y, wd, ht, hp, mp); ai = new EnemyAI(this);
        setDir(360);
    }
//ATTACKING
    public void attack(ArrayList<Particle> badparticles, Shooty player){
        if(ai.checkEnemyInSight(badparticles, player)){
            particleEffects.Shoot(badparticles, this);
        }
    }
//RENDERING 
    @Override
    public void draw(Graphics window) throws IOException {
        if(Math.abs(getDir())%360==0){ img = BoringImage.enemy0.getImgLoc();}
        if(Math.abs(getDir())%360==45){ img = BoringImage.enemy45.getImgLoc();}
        if(Math.abs(getDir())%360==90){ img = BoringImage.enemy90.getImgLoc();}
        if(Math.abs(getDir())%360==135){ img = BoringImage.enemy135.getImgLoc();}
        if(Math.abs(getDir())%360==180){ img = BoringImage.enemy180.getImgLoc();}
        if(Math.abs(getDir())%360==225){ img = BoringImage.enemy225.getImgLoc();}
        if(Math.abs(getDir())%360==270){ img = BoringImage.enemy270.getImgLoc();}
        if(Math.abs(getDir())%360==315){ img = BoringImage.enemy315.getImgLoc();}
        i.DrawImage(window,getXPos(),getYPos(),getWidth(),getHeight(),img);
        ai.draw(window);
    }
}