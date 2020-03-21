package BoringStuff;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import BoringEffects.ParticleEffects;
import BoringObjects.AliveObject;
import BoringSprites.Particle;
import BoringSprites.Shooty;

public class EnemyAI {
//Math
    private MathStuff m = new MathStuff();
//Shooty
    private Shooty enemy;
//Aim
    private Aiming a;
    private int cx, cy;
    private int x, y;
    private int cpx, cpy;
//CONSTRUCTING   
    public EnemyAI(Shooty thisGuy){
        enemy = thisGuy;
        a = new Aiming(thisGuy);
    }
//CALCULATING POINTS
    public void calcPoints(AliveObject player){
        a.calcPoints();
        //enemy center
        cx = a.getCx(); cy = a.getCy();
        //endpoint
        x = a.getX(); y = a.getY();
        //player center
        cpx = player.getCenterX(); cpy = player.getCenterY();
    }
    public boolean checkInFront(AliveObject player){
        if(Math.abs(enemy.getDir())%360==0){
            if (player.getXPos() > enemy.getXPos()) { //to the right
                return true;
            }
        }
        if(Math.abs(enemy.getDir())%360==45){
            if (player.getXPos() > enemy.getXPos() && player.getYPos() > enemy.getYPos()) { //to the right and bottom
                return true;
            }
        }
        if(Math.abs(enemy.getDir())%360==90){
            if (player.getYPos() > enemy.getYPos()) { //to the bottom
                return true;
            }
        }
        if(Math.abs(enemy.getDir())%360==135){
            if (player.getXPos() < enemy.getXPos() && player.getYPos() > enemy.getYPos()) { //to the left and bottom
                return true;
            }
        }
        if(Math.abs(enemy.getDir())%360==180){
            if (player.getXPos() < enemy.getXPos()) { //to the left
                return true;
            }
        }
        if(Math.abs(enemy.getDir())%360==225){
            if (player.getXPos() < enemy.getXPos() && player.getYPos() < enemy.getYPos()) { //to the left and top
                return true;
            }
        }
        if(Math.abs(enemy.getDir())%360==270){
            if (player.getYPos() < enemy.getYPos()) { //to the top
                return true;
            }
        }
        if(Math.abs(enemy.getDir())%360==315){
            if (player.getXPos() > enemy.getXPos() && player.getYPos() < enemy.getYPos()) { //to the
                return true;
            }
        }
        return false;
    }
    //MAKING ATTACK
    public boolean checkEnemyInSight(ArrayList<Particle> badparticles, AliveObject player){
        calcPoints(player);
        double dEP = m.distBtwnTwoPoints(cx,cy,cpx,cpy);
        double ang = m.angleBtwnTwoLines(cx,cy,x,y,cpx,cpy);
        double dBtwn = Math.sin(Math.toRadians(ang))*dEP;
        boolean inFront = checkInFront(player);
        if(dBtwn<=player.getRadius() //in line with shot
                &&dEP<=250 //in range
                &&inFront
        ){ return true; }
        return false;
    }
    public void turnToPlayer(AliveObject player){
        /*
        //turn left
            player.setDir(player.getDir() - 45);
            if(player.getDir()==0){ player.setDir(360);}
        //turn right
            player.setDir(player.getDir() + 45);
            if(player.getDir()==720){ player.setDir(360);}

         */
    }
//RENDERING
    public void draw(Graphics window) {
        a.calcPoints();
        window.setColor(Color.RED);
        window.drawLine(cx,cy,x,y);
        window.drawOval(cx-250,cy-250,500,500);
    }
}

//CHASING PLAYER
//SCOUTING
//LOOKING AROUND
//REACTING TO NEARBY GUNFIRE
