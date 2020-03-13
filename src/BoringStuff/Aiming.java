package BoringStuff;

import java.awt.Color;
import java.awt.Graphics;
import BoringSprites.Shooty;

public class Aiming {
//Shooty
    private Shooty guy;
//Slope
    private int dx,dy;
//Center
    private int cx, cy;
//End
    private int x, y;
//CONSTRUCTING   
    public Aiming(Shooty thisGuy){
        guy = thisGuy;
    }
//DETERMINING SLOPE
    public void setdx(){ dx = (int)(10 * Math.cos(Math.toRadians(guy.getDir())));}
    public void setdy(){ dy = (int)(10 * Math.sin(Math.toRadians(guy.getDir())));}
//CALCULATING ENDPOINT
    public void calcPoints(){
        //enemy center
        cx = guy.getCenterX(); cy = guy.getCenterY();
        //direction
        setdx(); setdy();
        //endpoint
        x = cx + dx*20; y = cy + dy*20;
    }
//ACCESSING ENDPOINT AND CENTER
    public int getX() { return x;}
    public int getY() { return y;}
    public int getCx() { return cx;}
    public int getCy() { return cy;}
//RENDERING
    public void draw(Graphics window) {
        calcPoints();
        window.setColor(Color.RED);
        window.drawLine(cx,cy,x,y);
    }
}
