package BoringSprites;
import BoringObjects.*;
import images.ImageGetter;
import java.awt.*;
public class Player extends GameObject {
    private ImageGetter i = new ImageGetter();
    private Colliding c = new Colliding();
    private Moving m = new Moving();
    private Living l = new Living();
    public Player (int x, int y, int wid, int ht) { super(x, y, wid, ht); }
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
    //draw
    @Override
    public void draw(Graphics window) {
        i.DrawRotatedImage(window,getXPos(),getYPos(),0,
                getWidth(),getHeight(),m.getDir());
    }
}