package BoringObjects;

import java.awt.*;

public class CollisObject extends GameObject {
    private Colliding c = new Colliding(this);
    public CollisObject  (int x, int y, int wd, int ht) {
        super(x, y, wd, ht);
    }
    @Override
    public void draw(Graphics window) {
        drawSuper(window);
    }
    //check colliding
    public boolean checkAllDir(GameObject other){ return c.checkAllDir(this,other);}
    @Override
    public String toString() {
        return "CollisObject {" + "\n" +
                "g=" + super.toString() + "\n" +
                '}';
    }
}