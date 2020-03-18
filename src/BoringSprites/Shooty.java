package BoringSprites;

import BoringObjects.AliveObject;
import BoringStuff.Aiming;
import java.awt.*;

public abstract class Shooty extends AliveObject {
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
            Bomb bomb = new Bomb(x, y,50,50,50,0,Color.black, 5);
            bomb.setDir(dir);
            return bomb;
        }
        Bullet bullet = new Bullet(x,y,50,50,50,0,Color.black,10);
        bullet.setDir(dir);
        return bullet;
    }
}
