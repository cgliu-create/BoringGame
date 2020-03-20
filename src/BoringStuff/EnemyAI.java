package BoringStuff;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import BoringEffects.ParticleEffects;
import BoringObjects.AliveObject;
import BoringSprites.Particle;
import BoringSprites.Shooty;

public class EnemyAI {
//Effect
    private ParticleEffects particleEffects = new ParticleEffects();
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
    public void calcPoints(){
        a.calcPoints();
        //enemy center
        cx = a.getCx(); cy = a.getCy();
        //endpoint
        x = a.getX(); y = a.getY();
    }
//MAKING ATTACK
    public void checkEnemyInSight(ArrayList<Particle> badparticles, AliveObject player){
        calcPoints();
        //player center
        cpx = player.getCenterX(); cpy = player.getCenterY();
        double diagLimit = Math.abs(m.distBtwnTwoPoints(cx,cy,x,y)); //enemy center to end point
        double diag = Math.abs(m.distBtwnTwoPoints(cx,cy,cpx,cpy)); //enemey center to player center
        if(diag<=diagLimit){ //diag distance is in range
            if (m.distBtnPointNLine(cx,cy,x,y,cpx,cpy)<=player.getRadius()){
                particleEffects.Shoot(badparticles,enemy);
            }
            //dist from player center to diag is less than player radius
        }
    }
//RENDERING
    public void draw(Graphics window) {
        a.calcPoints();
        window.setColor(Color.RED);
        window.drawLine(cx,cy,x,y);
    }
}

//CHASING PLAYER
//SCOUTING
//LOOKING AROUND
//REACTING TO NEARBY GUNFIRE
