package BoringObjects;

import java.awt.*;

public abstract class GameObject {
//Position
    private int xPos,yPos;
//Space
    private int width,height;
//Radius
    private int radius;
//CONSTRUCTING
    public GameObject(int x, int y, int wd, int ht) {
        xPos = x; yPos = y; width = wd; height = ht; radius = wd/2;
    }
//CHANGING SIZE AND POSITION
    public void setWidth(int w) { width = w; }
    public void setHeight(int h) { height = h; }
    public void setXPos(int xp) { xPos = xp; }
    public void setYPos(int yp) { yPos = yp; }
    public void setRadius(int r){ radius = r; }
//ACCESSING SIZE AND POSITION
    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public int getXPos() { return xPos; }
    public int getYPos() { return yPos; }
    public int getRadius(){return radius;}
//FINDING CENTER
    public int getCenterX(){ return getXPos() + getWidth()/2;}
    public int getCenterY(){ return getYPos() + getHeight()/2;}
//UNDEFINED RENDERING
    public abstract void draw(Graphics window);
//RENDERING THE DEFAULT
    public void drawSuper(Graphics window){
        window.setColor(Color.WHITE);
        window.drawOval(getXPos(),getYPos(),getWidth(),getHeight());
        //radius
        window.fillRect(getCenterX(),getCenterY(),2,2);
        window.drawLine(getCenterX(),getCenterY(),getCenterX()+getRadius(),getCenterY());
    }
//PRINTING
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
//CHECKING IF EQUAL
    public boolean equals(Object o){
        GameObject other = (GameObject)o;
        return other.getXPos() == this.getXPos() && other.getYPos() == this.getYPos()
                && other.getWidth() == this.getWidth() && other.getHeight() == this.getHeight();
    }
}