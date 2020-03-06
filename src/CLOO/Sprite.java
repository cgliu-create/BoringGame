package CLOO;
import java.awt.*;
public abstract class Sprite {
    //instance variables
    private int xPos,yPos;
    private int width,height;
    private int dir;
    private int speed, xSpeed, ySpeed;
    public Sprite(int x, int y, int wid, int ht) {
        xPos = x;
        yPos =y;
        width = wid;
        height = ht;
        dir = 0;
        speed = 0;
        xSpeed = 0;
        ySpeed = 0;
    }
    //set and get methods
    public void setWidth(int w) { width = w; }
    public void setHeight(int h) { height = h; }
    public void setXPos(int xp) { xPos = xp; }
    public void setYPos(int yp) { yPos = yp; }
    public void setSpeed( int s) { speed = s; setxSpeed(); setySpeed();}
    public void setDir(int degrees) { dir = degrees; setxSpeed(); setySpeed();}
    public void setxSpeed() { xSpeed = (int)(speed * Math.cos(Math.toRadians(dir))); }
    public void setySpeed() { ySpeed = (int)(speed * Math.sin(Math.toRadians(dir))); }
    public int getxSpeed() { return xSpeed; }
    public int getySpeed() { return ySpeed; }
    public int getDir() { return dir; }
    public int getSpeed() { return speed; }
    public int getXPos() { return xPos; }
    public int getYPos() { return yPos; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public abstract void draw(Graphics window);
    public String toString() { return xPos+" "+yPos+" "+width+" "+height+" "+speed+" "+dir; }
}