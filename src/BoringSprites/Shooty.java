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
    public void drawSuper(Graphics window){
        super.draw(window);
    }
    public int getBullet() { return bulletType; }
    public void setBullet(int bulletType) { this.bulletType = bulletType; }
    public Particle getParticle(int x, int y, int dir) {
        if (bulletType == 1) {
            Bomb bomb = new Bomb(x, y, 50, 50, 100, 0, Color.black, 5+this.getSpeed());
            bomb.setDir(dir);
            return bomb;
        }
        Particle bullet = new Particle(x,y,25,25,100,0,Color.black,10+this.getSpeed());
        bullet.setDir(dir);
        return bullet;
    }
}
