package BoringSprites;

import BoringImages.BoringImage;
import BoringImages.ImageGetter;
import BoringObjects.AliveObject;
import BoringStuff.Aiming;
import java.awt.*;
import java.io.IOException;

public abstract class Shooty extends AliveObject {
    //Image
    private ImageGetter i = new ImageGetter();
    private String img;
//Aiming
    private Aiming a = new Aiming(this);
//Bullet type
    private int bulletType;
//CONSTRUCTING    
    public Shooty(int x, int y, int wd, int ht, int hp, int mp) {
        super(x, y, wd, ht, hp, mp);
    }
//RENDERING
    public void drawAim(Graphics window){ a.draw(window);}
    public void drawStatus(Graphics window, int x, int y, Color color){
        window.setColor(color);
        window.setFont(new Font("TAHOMA",Font.BOLD,20));
        window.drawString("HP"+this.getHP(), x, y);
        window.drawString("MP"+this.getMP(), x, y+40);
        window.drawString("Dir"+(this.getDir()-360), x, y+80);
        window.drawString("Spd"+(this.getSpeed()/2), x, y+120);
    }
    public Aiming getAiming(){return a;}
//IDENTIFYING BULLETS
    public int getBullet() { return bulletType;}
    public void setBullet(int bulletType) { this.bulletType = bulletType;}
    public Particle getParticle(int x, int y, int dir) {
        if (bulletType == 1) {
            Bomb bomb = new Bomb(x, y,50,50,35,0,Color.black, 5);
            bomb.setDir(dir);
            return bomb;
        }
        Bullet bullet = new Bullet(x,y,50,50,35,0,Color.black,10);
        bullet.setDir(dir);
        return bullet;
    }
    //death
    @Override
    public void draw(Graphics window) throws IOException {
        if(Math.abs(getDir())%360==0){ img = BoringImage.dead0.getImgLoc();}
        if(Math.abs(getDir())%360==45){ img = BoringImage.dead45.getImgLoc();}
        if(Math.abs(getDir())%360==90){ img = BoringImage.dead90.getImgLoc();}
        if(Math.abs(getDir())%360==135){ img = BoringImage.dead135.getImgLoc();}
        if(Math.abs(getDir())%360==180){ img = BoringImage.dead180.getImgLoc();}
        if(Math.abs(getDir())%360==225){ img = BoringImage.dead225.getImgLoc();}
        if(Math.abs(getDir())%360==270){ img = BoringImage.dead270.getImgLoc();}
        if(Math.abs(getDir())%360==315){ img = BoringImage.dead315.getImgLoc();}
        drawAim(window);
        i.DrawImage(window, getXPos(), getYPos(), getWidth(), getHeight(), img);
        // window.drawString(""+getDir(),600,100);
    }
}
