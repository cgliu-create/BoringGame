package BoringObjects;

import java.awt.*;
import java.io.IOException;

public class CollisObject extends GameObject {
//Quality
    private Colliding c = new Colliding(this);
//CONSTRUCTING  
    public CollisObject  (int x, int y, int wd, int ht) {
        super(x, y, wd, ht);
    }
//RENDERING DEFAULT
    @Override
    public void draw(Graphics window) throws IOException {
        drawSuper(window);
    }
//CHECKING COLLISION
    public boolean checkAllDir(GameObject other){ return c.checkAllDir(this,other);}
//PRINTING
    @Override
    public String toString() {
        return "CollisObject {" + "\n" +
                "g=" + super.toString() + "\n" +
                '}';
    }
}