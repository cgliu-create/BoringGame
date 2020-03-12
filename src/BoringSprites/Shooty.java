package BoringSprites;

import BoringObjects.AliveObject;
import BoringStuff.Aiming;

import java.awt.*;

public abstract class Shooty extends AliveObject {
    private Aiming a = new Aiming(this);
    private int bulletType;
    public Shooty(int x, int y, int wd, int ht, int hp, int mp) {
        super(x, y, wd, ht, hp, mp);
    }
    public void drawAim(Graphics window){ a.draw(window);}
    public Aiming getAiming(){return a;}
    public int getBullet() { return bulletType; }
    public void setBullet(int bulletType) { this.bulletType = bulletType; }
    public Particle getParticle(int x, int y, int dir) {
        if (bulletType == 1) {
            Bomb bomb = new Bomb(x, y,30,30,0,0,Color.black, 5);
            bomb.setDir(dir);
            return bomb;
        }
        Bullet bullet = new Bullet(x,y,25,25,100,0,Color.black,10);
        bullet.setDir(dir);
        return bullet;
    }
}
