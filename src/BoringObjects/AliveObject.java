package BoringObjects;

import BoringSprites.Particle;
import java.awt.*;

public class AliveObject extends GameObject {
    private Colliding c = new Colliding(this);
    private Moving m = new Moving();
    private Living l;
    public AliveObject (int x, int y, int wd, int ht, int hp, int mp) {
        super(x, y, wd, ht);
        l = new Living(hp, mp);
    }
    @Override
    public void draw(Graphics window) {
        drawSuper(window);
    }
    //check colliding
    public boolean checkAllDir(GameObject other){ return c.checkAllDir(this,other);}
    //set and get moving
    public void setSpeed( int s) { m.setSpeed(s);}
    public void setDir(int degrees) { m.setDir(degrees);}
    public int getDir() { return m.getDir(); }
    public int getSpeed() { return m.getSpeed(); }
    public int getXspeed() { return m.getXspeed(); }
    public int getYspeed() { return m.getYspeed(); }
    //set and get living
    public void setHP(int hp) { l.setHP(hp); }
    public void setMP(int mp) { l.setMP(mp); }
    public int getHP() { return l.getHP(); }
    public int getMP() { return l.getMP(); }
    @Override
    public String toString() {
        return "AliveObject{" + "\n" +
                "g=" + super.toString() + "\n" +
                ", m=" + m + "\n" +
                ", l=" + l + "\n" +
                '}';
    }
}