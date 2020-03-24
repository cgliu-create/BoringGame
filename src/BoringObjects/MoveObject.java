package BoringObjects;

import java.awt.*;
import java.io.IOException;

public class MoveObject extends CollisObject {
//Qualities
    private Moving m = new Moving();
//CONSTRUCTING  
    public MoveObject (int x, int y, int wd, int ht) {
        super(x, y, wd, ht);
        setDir(360);
    }
//RENDERING DEFAULT    
    @Override
    public void draw(Graphics window) throws IOException {
        drawSuper(window);
    }
//CHANGING SPEED AND DIRECTION
    public void setSpeed( int s) { m.setSpeed(s);}
    public void setDir(int degrees) { m.setDir(degrees);}
//ACCESSING SPEED AND DIRECTION   
    public int getDir() { return m.getDir(); }
    public int getSpeed() { return m.getSpeed(); }
    public int getXspeed() { return m.getXspeed(); }
    public int getYspeed() { return m.getYspeed(); }
    //TURNING
    public void turnRight(){ m.turnRight();}
    public void turnLeft(){ m.turnLeft();}
    public void turn(int degree){m.setDir(m.getDir()+degree);}
//PRINTING   
    @Override
    public String toString() {
        return "MoveObject{" + "\n" +
                super.toString() + "\n" +
                ", m=" + m + "\n" +
                '}';
    }
}
