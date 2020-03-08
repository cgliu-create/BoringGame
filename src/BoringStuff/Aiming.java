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
        if(Math.abs(dir)%360==45 || Math.abs(dir)%360==135 || Math.abs(dir)%360==225 || Math.abs(dir)%360==315)
            dx = (int)(dx * 1.5);
    }
    public void setdy() {
        int dir = thing.getDir();
        dy = (int)(10 * Math.sin(Math.toRadians(dir)));
        if(Math.abs(dir)%360==45 || Math.abs(dir)%360==135 || Math.abs(dir)%360==225 || Math.abs(dir)%360==315)
            dy = (int)(dy * 1.5);
    }
    public void draw(Graphics window) {
        int cx = thing.getXPos()+thing.getWidth()/2;
        int cy = thing.getYPos()+thing.getHeight()/2;
        setdx();setdy();
        int x = cx + dx*10;
        int y = cy + dy*10;
        window.setColor(Color.RED);
        window.drawLine(cx,cy,x,y);
    }
}
