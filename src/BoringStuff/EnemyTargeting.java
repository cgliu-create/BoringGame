package BoringStuff;

import BoringObjects.AliveObject;
import BoringSprites.Enemy;
import BoringSprites.Particle;
import BoringSprites.Shooty;

import java.awt.*;
import java.util.ArrayList;

public class EnemyTargeting {
    //Math
    private MathStuff m = new MathStuff();
    //Enemy
    private Enemy enemy;
    //Aim
    private Aiming a;
    private int cx, cy;
    private int x, y;
    private int cpx, cpy;
    //In sight
    double dEP;
    double angPlayer, angAim;
    double angBtwn;
    double dAP;
    //CONSTRUCTING
    public EnemyTargeting(Enemy thisGuy) {
       enemy = thisGuy;
       a = new Aiming(thisGuy);
    }
    public void calcPoints(AliveObject player){
        a.calcPoints();
        //enemy center
        cx = a.getCx(); cy = a.getCy();
        //endpoint
        x = a.getX(); y = a.getY();
        //player center
        cpx = player.getCenterX(); cpy = player.getCenterY();
    }
    public boolean checkEnemyInSight(ArrayList<Particle> badparticles, AliveObject player){
        calcPoints(player);
        dEP = m.distBtwnTwoPoints(cx,cy,cpx,cpy);
        angPlayer = m.angleOfALine(cx,cy,cpx,cpy);
        angAim = m.angleOfALine(cx,cy,x,y);
        angBtwn = Math.abs(angPlayer-angAim);
        if(angBtwn>180){
            angBtwn = 360 - angBtwn;
        }
        dAP = Math.sin(Math.toRadians(angBtwn))*dEP;
        //in line with shot
        return dAP <= player.getRadius()+10&&angBtwn<45&&dEP<=250; //can hit and is not behind and in range
    }
    public void lineUpShot(AliveObject player){
        if (dAP> player.getRadius()+10&&dEP<=250){
           //enemy.turnLeft();
        }

    }
    //RENDERING
    public void draw(Graphics window) {
        a.calcPoints();
        window.setColor(Color.RED);
        window.setFont(new Font("TAHOMA",Font.BOLD,20));
        window.drawString("DistEP:"+(int)dEP+"/Ang:"+(int)angBtwn+"/DistAP:"+(int)dAP,100,100);
        window.drawString("/AngPlayer:"+(int)angPlayer+"/AngAim:"+(int)angAim,100,150);
        window.drawLine(cx,cy,x,y);
        window.drawOval(cx-250,cy-250,500,500);
        window.setColor(Color.CYAN);
        window.drawPolygon(new int[] {cx, x, x}, new int[] {cy, y, cy}, 3);
        window.setColor(Color.GREEN);
        window.drawPolygon(new int[] {cx, cpx, cpx}, new int[] {cy, cpy, cy}, 3);
    }

}
