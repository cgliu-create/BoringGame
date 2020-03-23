package BoringStuff;

import BoringObjects.AliveObject;
import BoringObjects.MoveObject;
import BoringSprites.Enemy;
import BoringSprites.Shooty;

import java.awt.*;

public class EnemySeeing {
    //Math
    private MathStuff m = new MathStuff();
    //Enemy
    private Enemy enemy;
    //Aim
    private Aiming a, b, c;
    private int cx, cy;
    private int x, y;
    private int cpx, cpy;
    //In sight
    double dEP;
    double angPlayer, angAim;
    double angBtwn;
    //CONSTRUCTING
    public EnemySeeing(Enemy thisGuy) {
        enemy = thisGuy;
        a = new Aiming(thisGuy);
        b = new Aiming(thisGuy);
        c = new Aiming(thisGuy);
    }
    //CALCULATING VALUES
    public void calcPoints(AliveObject player){
        a.calcPoints();
        //enemy center
        cx = a.getCx(); cy = a.getCy();
        //endpoint
        x = a.getX(); y = a.getY();
        //player center
        cpx = player.getCenterX(); cpy = player.getCenterY();
    }
    public void calcAngBtwnAP(){
        angPlayer = m.angleOfALine(cx,cy,cpx,cpy);
        angAim = m.angleOfALine(cx,cy,x,y);
        angBtwn = Math.abs(angPlayer-angAim);
        if(angBtwn>180){
            angBtwn = 360 - angBtwn; //angles are relative
        }
    }
    public void calcDistBtwnEP(){
        dEP = m.distBtwnTwoPoints(cx,cy,cpx,cpy);
    }
    public boolean checkPlayerSpotted(){
        if(angBtwn<=45&&dEP<=300){ //within 90 degree field of vision, slighly farther than shooting range
            return false;
        }
        return false;
    }
//ACCESSING VALUES
    public double getAngAim() { return angAim; }
    public double getAngPlayer() { return angPlayer; }
    public double getAngBtwn() { return angBtwn; }
    public double getdEP() { return dEP; }
    public Aiming getA() { return a; }
    public Aiming getB() { return b; }
    public Aiming getC() { return c; }
    public int getCpx() { return cpx; }
    public int getCpy() { return cpy; }

    //RENDERING
    public void draw(Graphics window) {
        int enemyDir = enemy.getDir();
        a.calcPoints();
        enemy.setDir(enemyDir+45);
        b.calcPoints();
        enemy.setDir(enemyDir);
        enemy.setDir(enemyDir-45);
        c.calcPoints();
        enemy.setDir(enemyDir);
        window.setColor(Color.RED);
        window.drawLine(cx,cy,x,y);
        window.drawLine(cx,cy,b.getX(),b.getY());
        window.drawLine(cx,cy,c.getX(),c.getY());
    }
}
