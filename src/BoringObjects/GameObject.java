package BoringObjects;
import BoringGame.Game;
import BoringSprites.Particle;

import java.awt.*;
public abstract class GameObject {
    //instance variables
    private int xPos,yPos;
    private int width,height;
    private int radius;
    public GameObject(int x, int y, int wd, int ht) {
        xPos = x;
        yPos = y;
        width = wd;
        height = ht;
        radius = wd/2;
    }
    //set and get methods
    public void setWidth(int w) { width = w; }
    public void setHeight(int h) { height = h; }
    public void setXPos(int xp) { xPos = xp; }
    public void setYPos(int yp) { yPos = yp; }
    public void setRadius(int r){ radius = r; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public int getXPos() { return xPos; }
    public int getYPos() { return yPos; }
    public int getRadius(){return radius;}
    //paint
    public abstract void draw(Graphics window);
    public void drawSuper(Graphics window){
        window.setColor(Color.WHITE);
        window.drawOval(getXPos(),getYPos(),getWidth(),getHeight());
        //center
        window.fillRect(getXPos()+getWidth()/2,getYPos()+getHeight()/2,2,2);
        //radius
        window.drawLine(getXPos()+getWidth()/2,getYPos()+getHeight()/2,getXPos()+getWidth()/2+getRadius(),getYPos()+getHeight()/2);
    }
    //toString
    @Override
    public String toString() {
        return "GameObject{" +
                "xPos=" + xPos +
                ", yPos=" + yPos +
                ", width=" + width +
                ", height=" + height +
                ", radius=" + radius +
                '}';
    }
    //equals
    public boolean equals(Object o){
        GameObject other = (GameObject)o;
        return other.getXPos() == this.getXPos() && other.getYPos() == this.getYPos()
                && other.getWidth() == this.getWidth() && other.getHeight() == this.getHeight();
    }
}