package BoringStuff;

import BoringObjects.AliveObject;
import BoringSprites.Enemy;
import BoringSprites.Particle;

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
    //CONSTRUCTING
    public EnemyScouting(Enemy thisGuy, int scoutDir, int scoutDistance) {
        enemy = thisGuy;
        //starting pos
        x1 = thisGuy.getXPos(); y1 = thisGuy.getYPos();
        if(scoutDir%45==0){ thisGuy.setDir(scoutDir); } //valid 8 dir movement
        else {thisGuy.setDir(360);}
        //other end pos
        x2 = (int)(scoutDistance * Math.cos(Math.toRadians(thisGuy.getDir())));
        y2 = (int)(scoutDistance * Math.sin(Math.toRadians(thisGuy.getDir())));
        dirA = thisGuy.getDir();
        dirB = thisGuy.getDir()+180;
        enemySeeing = new EnemySeeing(thisGuy);
    }
    public boolean checkEnemySpotted(AliveObject player) {
        enemySeeing.calcPoints(player);
        enemySeeing.calcAngBtwnAP();
        enemySeeing.calcDistBtwnEP();
        double angBtwn = enemySeeing.getAngBtwn();
        double dEP = enemySeeing.getdEP();
        return angBtwn<=45 &&dEP<=300;
        //within 90degree vision and at least slightly farther than shooting range
    }
    public boolean lookAround(AliveObject player){
        int enemyDir = enemy.getDir();
        enemy.setDir(enemyDir+45);
        if (checkEnemySpotted(player)){return true;}
        enemy.setDir(enemyDir+90);
        if (checkEnemySpotted(player)){return true;}
        enemy.setDir(enemyDir+45);
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
    public boolean patrol(AliveObject player){
        if (atCheckpointOne()){
            enemy.setSpeed(0);
            if(lookAround(player)){return true;}
            enemy.setDir(dirB);
            enemy.setSpeed(2);
        }
        if (atCheckpointTwo()){
            enemy.setSpeed(0);
            if(lookAround(player)){return true;};
            enemy.setDir(dirA);
            enemy.setSpeed(2);
        }
        return false;
    }

}
