package BoringObjects;

import java.awt.*;
import java.io.IOException;

public class AliveObject extends MoveObject {
//Qualities
    private Living l;
//CONSTRUCTING  
    public AliveObject (int x, int y, int wd, int ht, int hp, int mp) {
        super(x, y, wd, ht);
        l = new Living(hp, mp);
    }
//RENDERING DEFAULT
    @Override
    public void draw(Graphics window) throws IOException {
        drawSuper(window);
    }
//CHANGING STATUS
    public void setHP(int hp) { l.setHP(hp); }
    public void setMP(int mp) { l.setMP(mp); }
//ACCESSING STATUS
    public int getHP() { return l.getHP(); }
    public int getMP() { return l.getMP(); }
    //CHANGING AND CHECKING STATUS
    public boolean checkIfAlive(){
        return l.getHP() > 0;
    }
    public void changeHP(int dHP){
        l.setHP(l.getHP() + dHP);
    }
    public void changeMP(int dMP){
        l.setMP(l.getMP() + dMP);
    }
//PRINTING
    @Override
    public String toString() {
        return "AliveObject{" + "\n" +
                super.toString() + "\n" +
                ", l=" + l + "\n" +
                '}';
    }
}