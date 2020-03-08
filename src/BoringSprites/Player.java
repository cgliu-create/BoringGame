package BoringSprites;
import BoringObjects.AliveObject;
import BoringImages.ImageGetter;
import BoringStuff.Aiming;

import java.awt.*;
public class Player extends AliveObject {
    private ImageGetter i = new ImageGetter();
    private int img;
    private Aiming a = new Aiming(this);
    private Bomb b = new Bomb(0,0,50,50,100,0,Color.black, 10);
    public Player (int x, int y, int wd, int ht, int hp, int mp) {
        super(x, y, wd, ht, hp, mp);
        setDir(360);
    }
    public void drawSuper(Graphics window){
        super.draw(window);
    }
    @Override
    public void draw(Graphics window) {
        if(Math.abs(getDir())%360==0)
            img = 0;
        if(Math.abs(getDir())%360==45)
            img = 1;
        if(Math.abs(getDir())%360==90)
            img = 2;
        if(Math.abs(getDir())%360==135)
            img = 3;
        if(Math.abs(getDir())%360==180)
            img = 4;
        if(Math.abs(getDir())%360==225)
            img = 5;
        if(Math.abs(getDir())%360==270)
            img = 6;
        if(Math.abs(getDir())%360==315)
            img = 7;
        a.draw(window);
        i.DrawImage(window,getXPos(),getYPos(),img,getWidth(),getHeight());
    }
    @Override
    public Particle getParticle() {
        return b;
    }
}