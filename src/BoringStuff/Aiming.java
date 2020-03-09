package BoringStuff;
import BoringObjects.AliveObject;

import java.awt.*;

public class Aiming {
    private AliveObject thing;
    private int dx,dy;
    private int cx, cy;
    private int x, y;
    public Aiming(AliveObject thisThing){
        thing = thisThing;
    }
    public void setdx() {
        int dir = thing.getDir();
        dx = (int)(10 * Math.cos(Math.toRadians(dir)));
    }
    public void setdy() {
        int dir = thing.getDir();
        dy = (int)(10 * Math.sin(Math.toRadians(dir)));
    }
    public void checkEnemyInSight(AliveObject otherThing){
        //check if a line touches or intersects a circle
        //distance from a point to a line...
        cx = thing.getXPos()+thing.getWidth()/2;
        cy = thing.getYPos()+thing.getHeight()/2;

    }
    public void draw(Graphics window) {
        cx = thing.getXPos()+thing.getWidth()/2;
        cy = thing.getYPos()+thing.getHeight()/2;
        setdx();
        setdy();
        x = cx + dx*20;
        y = cy + dy*20;
        window.setColor(Color.RED);
        window.drawLine(cx,cy,x,y);
    }
}
