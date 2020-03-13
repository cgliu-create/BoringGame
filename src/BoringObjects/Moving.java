package BoringObjects;

public class Moving {
//Direction and speed
    private int dir, speed, Xspeed, Yspeed;
//CONSTRUCTING  
    public Moving(){
        dir = speed = Xspeed = Yspeed = 0;
    }
    public Moving(int d, int s){
        dir = d; speed = s; setXspeed(); setYspeed();
    }
//CHANGING SPEED AND DIRECTION
    public void setSpeed( int s) { speed = s; setXspeed(); setYspeed();}
    public void setDir(int degrees) { dir = degrees; setXspeed(); setYspeed();}
    public void setXspeed() {
        Xspeed = (int)(speed * Math.cos(Math.toRadians(dir)));
        if(Math.abs(getDir())%360==45 || Math.abs(getDir())%360==135 || Math.abs(getDir())%360==225 || Math.abs(getDir())%360==315)
            Xspeed = (int)(Xspeed * 1.5);
    }
    public void setYspeed() {
        Yspeed = (int)(speed * Math.sin(Math.toRadians(dir)));
        if(Math.abs(getDir())%360==45 || Math.abs(getDir())%360==135 || Math.abs(getDir())%360==225 || Math.abs(getDir())%360==315)
            Yspeed = (int)(Yspeed * 1.5);
    }
//ACCESSING SPEED AND DIRECTION
    public int getSpeed() { return speed; }
    public int getDir() { return dir; }
    public int getXspeed() { return Xspeed; }
    public int getYspeed() { return Yspeed; }
//PRINTING
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
