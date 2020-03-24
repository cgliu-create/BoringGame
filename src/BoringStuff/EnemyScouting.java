package BoringStuff;

import BoringObjects.AliveObject;
import BoringSprites.Enemy;
import BoringSprites.Particle;

import java.awt.*;
import java.util.ArrayList;

public class EnemyScouting {
    //Enemy
    private Enemy enemy;
    private EnemySeeing enemySeeing;
    //Checkpoint 1
    private int x1, y1;
    //Checkpoint 2
    private int x2, y2;
    //Turning
    private int dirA,dirB;
    public void calcPointsAndDirections(int scoutDir, int scoutDistance, int x , int y){
        //starting pos
        x1 = x; y1 = y;
        if(scoutDir%45==0){ enemy.setDir(scoutDir); } //valid 8 dir movement
        else {enemy.setDir(360);}
        //other end pos
        x2 = (int)(scoutDistance * Math.cos(Math.toRadians(enemy.getDir())));
        y2 = (int)(scoutDistance * Math.sin(Math.toRadians(enemy.getDir())));
        dirA = enemy.getDir();
        dirB = enemy.getDir()+180;
    }
    //CONSTRUCTING
    public EnemyScouting(Enemy thisGuy, int scoutDir, int scoutDistance) {
        enemy = thisGuy;
        calcPointsAndDirections(scoutDir,scoutDistance,thisGuy.getXPos(),thisGuy.getYPos());
        enemySeeing = new EnemySeeing(thisGuy);
    }
    public boolean checkEnemySpotted(AliveObject player) {
        calcSeeing(player);
        double angBtwn = enemySeeing.getAngBtwn();
        double dEP = enemySeeing.getdEP();
        return angBtwn<=45 &&dEP<=300;
        //within 90degree vision and at least slightly farther than shooting range
    }
    public void calcSeeing(AliveObject player){
        enemySeeing.calcSeeing(player);
    }
    public boolean lookAround(AliveObject player){
        int enemyDir = enemy.getDir();
        enemy.setDir(enemyDir+45);
        if (checkEnemySpotted(player)){return true;}
        enemy.setDir(enemyDir-45);
        if (checkEnemySpotted(player)){return true;}
        enemy.setDir(enemyDir);
        if (checkEnemySpotted(player)){return true;}
        enemy.setDir(enemyDir-45);
        if (checkEnemySpotted(player)){return true;}
        enemy.setDir(enemyDir-90);
        if (checkEnemySpotted(player)){return true;}
        enemy.setDir(enemyDir-45);
        if (checkEnemySpotted(player)){return true;}
        enemy.setDir(enemyDir);
        if (checkEnemySpotted(player)){return true;}
        return false;
    }
    public boolean atCheckpointOne(){
        return enemy.getXPos()==x1&&enemy.getYPos()==y1;
    }
    public boolean atCheckpointTwo(){
        return enemy.getXPos()==x2&&enemy.getYPos()==y2;
    }
    public boolean checkAndPatrol(AliveObject player){
        if(lookAround(player)){return true;}
        if (atCheckpointOne()){
            enemy.setSpeed(0);
            enemy.setDir(dirB);
            enemy.setSpeed(2);
        }
        if (atCheckpointTwo()){
            enemy.setSpeed(0);
            enemy.setDir(dirA);
            enemy.setSpeed(2);
        }
        return false;
    }
    //RENDERING
    public void draw(Graphics window) {
        enemySeeing.draw(window);
    }
}
