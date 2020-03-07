package BoringObjects;

public class Moving {
    //instance variables
    private int dir;
    private int speed;
    private int Xspeed;
    private int Yspeed;
    public Moving(){
        dir = speed = Xspeed = Yspeed = 0;
    }
    public Moving(int d, int s){
        dir = d;
        speed = s;
        setXspeed();
        setYspeed();
    }
    //set and get methods
    public void setSpeed( int s) { speed = s; setXspeed(); setYspeed();}
    public void setDir(int degrees) { dir = degrees; setXspeed(); setYspeed();}
    public void setXspeed() { Xspeed = (int)(speed * Math.cos(Math.toRadians(dir))); }
    public void setYspeed() { Yspeed = (int)(speed * Math.sin(Math.toRadians(dir))); }
    public int getSpeed() { return speed; }
    public int getDir() { return dir; }
    public int getXspeed() { return Xspeed; }
    public int getYspeed() { return Yspeed; }
    //toString
    @Override
    public String toString() {
        return "Moving{" +
                "dir=" + dir +
                ", speed=" + speed +
                ", Xspeed=" + Xspeed +
                ", Yspeed=" + Yspeed +
                '}';
    }
}
