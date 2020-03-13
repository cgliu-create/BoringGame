package BoringObjects;

import java.awt.*;

public class MoveObject extends GameObject {
//Qualities      
    private Colliding c = new Colliding(this);
    private Moving m = new Moving();
//CONSTRUCTING  
    public MoveObject (int x, int y, int wd, int ht) {
        super(x, y, wd, ht);
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
//PRINTING   
    @Override
    public String toString() {
        return "MoveObject{" + "\n" +
                "g=" + super.toString() + "\n" +
                ", m=" + m + "\n" +
                '}';
    }
}
