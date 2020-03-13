package BoringObjects;

import java.awt.*;

public class AliveObject extends GameObject {
//Qualities
    private Colliding c = new Colliding(this);
    private Moving m = new Moving();
    private Living l;
//CONSTRUCTING  
    public AliveObject (int x, int y, int wd, int ht, int hp, int mp) {
        super(x, y, wd, ht);
        l = new Living(hp, mp);
    }
//RENDERING DEFAULT
    @Override
    public void draw(Graphics window) {
        drawSuper(window);
    }
//CHECKING COLLISION
    public boolean checkAllDir(GameObject other){ return c.checkAllDir(this,other);}
//CHANGING SPEED AND DIRECTION
    public void setSpeed( int s) { m.setSpeed(s);}
    public void setDir(int degrees) { m.setDir(degrees);}
//ACCESSING SPEED AND DIRECTION
    public int getDir() { return m.getDir(); }
    public int getSpeed() { return m.getSpeed(); }
    public int getXspeed() { return m.getXspeed(); }
    public int getYspeed() { return m.getYspeed(); }
//CHANGING STATUS
    public void setHP(int hp) { l.setHP(hp); }
    public void setMP(int mp) { l.setMP(mp); }
//ACCESSING STATUS
    public int getHP() { return l.getHP(); }
    public int getMP() { return l.getMP(); }
//PRINTING
    @Override
    public String toString() {
        return "AliveObject{" + "\n" +
                "g=" + super.toString() + "\n" +
                ", m=" + m + "\n" +
                ", l=" + l + "\n" +
                '}';
    }
}