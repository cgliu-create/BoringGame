package BoringStuff;
import BoringObjects.AliveObject;

import java.awt.*;

public class Aiming {
    private AliveObject thing;
    private int dx,dy;
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
    public void draw(Graphics window) {
        int cx = thing.getXPos()+thing.getWidth()/2;
        int cy = thing.getYPos()+thing.getHeight()/2;
        setdx();setdy();
        int x = cx + dx*20;
        int y = cy + dy*20;
        window.setColor(Color.RED);
        window.drawLine(cx,cy,x,y);
    }
}
