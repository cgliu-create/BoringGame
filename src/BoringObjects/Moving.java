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
    }
    public void setYspeed() {
        Yspeed = (int)(speed * Math.sin(Math.toRadians(dir)));
    }
//ACCESSING SPEED AND DIRECTION
    public int getSpeed() { return speed; }
    public int getDir() { return dir; }
    public int getXspeed() { return Xspeed; }
    public int getYspeed() { return Yspeed; }
    public void turnRight(){
        if(getDir()==720){ setDir(360);} //fix
        setDir(getDir()+45);
    }
    public void turnLeft(){
        if(getDir()==0){ setDir(360);}
        setDir(getDir()-45);
    }
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
