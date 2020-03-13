package BoringObjects;

import java.awt.*;

public class BreakObject extends CollisObject {
//Quality
    private Living l;
//CONSTRUCTING  
    public BreakObject (int x, int y, int wd, int ht, int hp, int mp) {
        super(x, y, wd, ht);
        l = new Living(hp, mp);
    }
//RENDERING DEFAULT
    @Override
    public void draw(Graphics window) {
        drawSuper(window);
    }
//CHANGING STATUS
    public void setHP(int hp) { l.setHP(hp); }
    public void setMP(int mp) { l.setMP(mp); }
//ACCESSING STATUS
    public int getHP() { return l.getHP(); }
    public int getMP() { return l.getMP(); }
//PRINTING
    @Override
    public String toString() {
        return "BreakObject{" + "\n" +
                super.toString() + "\n" +
                ", l=" + l + "\n" +
                '}';
    }
}