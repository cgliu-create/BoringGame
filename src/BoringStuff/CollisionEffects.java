package BoringStuff;

import BoringObjects.AliveObject;
import BoringObjects.CollisObject;
import BoringObjects.GameObject;
import BoringObjects.MoveObject;
import BoringSprites.Bomb;
import BoringSprites.Particle;

import java.awt.*;
import java.util.ArrayList;

public class CollisionEffects {
    private int W, H;
    public CollisionEffects(int W, int H){
        this.W = W;
        this.H = H;
    }
    private CollisObject temp = new CollisObject(0,0,0,0);
    private ParticleEffects pe = new ParticleEffects();
    // have a separate list for player particles and enemy particles
    public void checkCollisionsBullet(ArrayList<Particle> particles, AliveObject guy) {
        for (int i = particles.size() - 1; i >= 0; i--) {
            Particle p = particles.get(i);
            if (p.getColor()!=Color.RED&&p.getColor()!=Color.ORANGE&&p.getColor()!=Color.YELLOW&&p.getColor()!=Color.DARK_GRAY){
                if (p.checkAllDir(guy)){
                    if (p instanceof Bomb){
                        pe.KaBoom(particles,p.getXPos(),p.getYPos(),Color.DARK_GRAY,10);
                        pe.KaBoom(particles,p.getXPos(),p.getYPos()+p.getHeight()/2);
                        pe.KaBoom(particles,p.getXPos(),p.getYPos()-p.getHeight()/2);
                        pe.KaBoom(particles,p.getXPos()+p.getWidth()/2,p.getYPos());
                        pe.KaBoom(particles,p.getXPos()-p.getWidth()/2,p.getYPos());
                        particles.remove(i);
                    } else {
                        pe.KaBoom(particles,p.getXPos(),p.getYPos(),Color.DARK_GRAY,10);
                        particles.remove(i);
                    }
                }
            }
        }
    }
    public void checkObstruction(ArrayList<GameObject>Obstructions, AliveObject guy){
        int x = guy.getXPos()+guy.getXspeed();
        int y = guy.getYPos()+guy.getYspeed();
        if (x>=0&&x<=W-guy.getWidth()&&y>=0&&y<H-guy.getHeight()) {
            temp.setXPos(x);temp.setYPos(y);temp.setHeight(guy.getHeight());temp.setWidth(guy.getWidth());
            boolean obstructionFree = true;
            for (GameObject gameObject : Obstructions) {
                if(temp.checkAllDir(gameObject)){
                    obstructionFree = false;
                    break;
                }
            }
            if(obstructionFree){
                guy.setXPos(x);
                guy.setYPos(y);
            }
        }
    }
    public void checkPush(ArrayList<MoveObject>blocks, AliveObject guy){
        for (MoveObject moveObject : blocks) {
            int x = moveObject.getXPos() + guy.getXspeed();
            int y = moveObject.getDir() + guy.getYPos();
            if(moveObject.checkAllDir(guy)){
                moveObject.setXPos(x);
                moveObject.setYPos(y);
            }
        }
    }
   
}
