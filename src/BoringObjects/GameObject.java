package BoringObjects;
import java.awt.*;
public abstract class GameObject {
    //instance variables
    private int xPos,yPos;
    private int width,height;
    public GameObject(int x, int y, int wid, int ht) {
        xPos = x;
        yPos =y;
        width = wid;
        height = ht;
    }
    //set and get methods
    public void setWidth(int w) { width = w; }
    public void setHeight(int h) { height = h; }
    public void setXPos(int xp) { xPos = xp; }
    public void setYPos(int yp) { yPos = yp; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public int getXPos() { return xPos; }
    public int getYPos() { return yPos; }
    //paint
    public abstract void draw(Graphics window);
    //toString
    @Override
    public String toString() {
        return "GameObject{" +
                "xPos=" + xPos +
                ", yPos=" + yPos +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}