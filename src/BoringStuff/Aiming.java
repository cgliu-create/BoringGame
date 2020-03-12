package BoringStuff;
import BoringObjects.AliveObject;
import BoringSprites.Particle;
import BoringSprites.Shooty;
import BoringStuff.MathStuff;

import java.awt.*;
import java.util.ArrayList;

public class Aiming {
    private Shooty thing;
    private MathStuff m = new MathStuff();
    private int dx,dy;
    private int cx, cy;
    private int x, y;
    public Aiming(Shooty thisThing){
        thing = thisThing;
    }
    public void setdx() {
        int dir = thing.getDir();
        dx = (int)(10 * Math.cos(Math.toRadians(dir)));
    }
    public void setdy() {
        int dir = thing.getDir();
        dy = (int)(10 * Math.sin(Math.toRadians(dir)));
    }
    public void draw(Graphics window) {
        cx = thing.getCenterX();
        cy = thing.getCenterY();
        setdx(); setdy();
        x = cx + dx*20;
        y = cy + dy*20;
        window.setColor(Color.RED);
        window.drawLine(cx,cy,x,y);
    }
    public void checkEnemyInSight(ParticleEffects particleEffects, ArrayList<Particle> badparticles, AliveObject player){
        //if diag distance is less than limit
        //if dist from center point to diag is less than limit
        int cpx = player.getCenterX();
        int cpy =player.getCenterY();
        double diagLimit = Math.abs(m.distBtwnTwoPoints(cx,cy,x,y));
        double diag = Math.abs(m.distBtwnTwoPoints(cx,cy,cpx,cpy));
        if(diag<=diagLimit){
            double a = m.angleBtwnTwoLines(cx,cy,x,y,cpx,cpy);
            if (a<10){
                if (m.distBtnPointNLine(cx,cy,x,y,cpx,cpy)<=player.getRadius()){
                    particleEffects.Shoot(badparticles,thing);
                    System.out.println(a);
                }
            }
        }
    }
}
