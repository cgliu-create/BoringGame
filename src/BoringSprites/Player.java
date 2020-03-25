package BoringSprites;

import BoringImages.BoringImage;
import BoringImages.ImageGetter;
import java.awt.*;
import java.io.IOException;

public class Player extends Shooty {
//Image
    private ImageGetter i = new ImageGetter();
    private String img;
//CONSTRUCTING 
    public Player (int x, int y, int wd, int ht, int hp, int mp) {
        super(x, y, wd, ht, hp, mp, true);
    }
//RENDERING 
    @Override
    public void draw(Graphics window) throws IOException {
        if(checkIfAlive()){
            if(Math.abs(getDir())%360==0){ img = BoringImage.player0.getImgLoc();}
            if(Math.abs(getDir())%360==45){ img = BoringImage.player45.getImgLoc();}
            if(Math.abs(getDir())%360==90){ img = BoringImage.player90.getImgLoc();}
            if(Math.abs(getDir())%360==135){ img = BoringImage.player135.getImgLoc();}
            if(Math.abs(getDir())%360==180){ img = BoringImage.player180.getImgLoc();}
            if(Math.abs(getDir())%360==225){ img = BoringImage.player225.getImgLoc();}
            if(Math.abs(getDir())%360==270){ img = BoringImage.player270.getImgLoc();}
            if(Math.abs(getDir())%360==315){ img = BoringImage.player315.getImgLoc();}
            drawAim(window);
            i.DrawImage(window, getXPos(), getYPos(), getWidth(), getHeight(), img);
        } else { super.draw(window);}
    }
//CHANGING BULLET
    public void switchBullet(){
        int b = this.getBullet()+1;
        if (b==4) {
            setBullet(0);
            b = 0;
        }
        setBullet(b);
    }
}