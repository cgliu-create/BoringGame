package BoringSprites;
import BoringImages.ImageGetter;

import java.awt.*;
public class Player extends Shooty {
    private ImageGetter i = new ImageGetter();
    private int img;
    public Player (int x, int y, int wd, int ht, int hp, int mp) {
        super(x, y, wd, ht, hp, mp);
        setDir(360);
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
        drawAim(window);
        i.DrawImage(window,getXPos(),getYPos(),img,getWidth(),getHeight());
    }
    public void switchBullet(){
        int b = this.getBullet()+1;
        if (b==2)
            setBullet(0);
        setBullet(b);
    }
}