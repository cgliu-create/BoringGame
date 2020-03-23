package BoringStuff;

import BoringObjects.AliveObject;
import BoringSprites.Enemy;
import BoringSprites.Particle;

import java.awt.*;
import java.util.ArrayList;

public class EnemyTargeting {
    //Enemy
    private Enemy enemy;
    private EnemySeeing enemySeeing;
    //value in question
    private double dAP;
    //CONSTRUCTING
    public EnemyTargeting(Enemy thisGuy) {
       enemy = thisGuy;
       enemySeeing = new EnemySeeing(thisGuy);
    }
    public boolean checkEnemyInSight(AliveObject player){
        enemySeeing.calcPoints(player);
        enemySeeing.calcAngBtwnAP();
        enemySeeing.calcDistBtwnEP();
        double angBtwn = enemySeeing.getAngBtwn();
        double dEP = enemySeeing.getdEP();
        dAP = Math.sin(Math.toRadians(angBtwn))*dEP;
        //in line with shot
        return dAP <= player.getRadius()+10&&angBtwn<45&&dEP<=250; //can hit and is not behind and in range
    }
    public void lineUpShot(){
        double angBtwn = enemySeeing.getAngBtwn();
        double dEP = enemySeeing.getdEP();
        double angPlayer = enemySeeing.getAngPlayer();
        double angAim = enemySeeing.getAngAim();
        if (angBtwn>=45&&dEP<=250){
            if(angPlayer>angAim)
                enemy.turnLeft();
            if(angPlayer<angAim)
                enemy.turnRight();
        }
    }
    //RENDERING
    public void draw(Graphics window) {
        int cx = enemySeeing.getA().getCx();
        int cy = enemySeeing.getA().getCy();
        int x = enemySeeing.getA().getX();
        int y = enemySeeing.getA().getY();
        int cpx = enemySeeing.getCpx();
        int cpy = enemySeeing.getCpy();
        window.setColor(Color.RED);
        window.setFont(new Font("TAHOMA",Font.BOLD,20));
        window.drawLine(cx,cy,x,y);
        window.drawOval(cx-250,cy-250,500,500);
        window.setColor(Color.CYAN);
        window.drawPolygon(new int[] {cx, x, x}, new int[] {cy, y, cy}, 3);
        window.setColor(Color.GREEN);
        window.drawPolygon(new int[] {cx, cpx, cpx}, new int[] {cy, cpy, cy}, 3);
        enemySeeing.draw(window);
    }

}
