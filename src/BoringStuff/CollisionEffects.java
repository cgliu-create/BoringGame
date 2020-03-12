package BoringStuff;

import BoringGame.Game;
import BoringObjects.AliveObject;
import BoringObjects.CollisObject;
import BoringObjects.GameObject;
import BoringObjects.MoveObject;
import BoringSprites.Bomb;
import BoringSprites.Particle;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollisionEffects {
    private CollisObject temp = new CollisObject(0,0,0,0);
    private ParticleEffects pe = new ParticleEffects();
    public void checkCollisionsBullet(ArrayList<Particle> particles, GameObject guy) {
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
    public ArrayList<GameObject> checkNear(){
    return null;
    }
    public void checkObstruction(CopyOnWriteArrayList<GameObject>Obstructions, GameObject guy){
        int x = 0; int y = 0;
        if (guy instanceof AliveObject) {
            x = guy.getXPos() + ((AliveObject) guy).getXspeed();
            y = guy.getYPos() + ((AliveObject) guy).getYspeed();
        }
        if (guy instanceof MoveObject) {
            x = guy.getXPos() + ((MoveObject) guy).getXspeed();
            y = guy.getYPos() + ((MoveObject) guy).getYspeed();
        }
            temp.setXPos(x);
            temp.setYPos(y);
            temp.setHeight(guy.getHeight());
            temp.setWidth(guy.getWidth());
            //fix
            temp.setRadius(guy.getRadius());
            boolean obstructionFree = true;
            for (GameObject gameObject : Obstructions) {
                if (!(guy.equals(gameObject))){
                    if (temp.checkAllDir(gameObject)) {
                        obstructionFree = false;
                        break;
                    }
                }
            }
            if (obstructionFree) {
                guy.setXPos(x);
                guy.setYPos(y);
            }
    }
    public void checkMovePush(CopyOnWriteArrayList<GameObject>Obstructions, ArrayList<MoveObject>moveObjects, AliveObject guy){
        for (MoveObject m: moveObjects) {
            int r = m.getRadius();
            m.setRadius(guy.getRadius()+5);
            if((m).checkAllDir(guy)){
                m.setDir(guy.getDir());
                m.setSpeed(guy.getSpeed());
                checkObstruction(Obstructions,m);
                m.setSpeed(0);
            }
            m.setRadius(r);
        }
    }
    public void checkParticlePush(CopyOnWriteArrayList<GameObject>Obstructions, ArrayList<Particle> particles,GameObject guy){
        if (guy instanceof AliveObject || guy instanceof MoveObject){
            for (int i = particles.size() - 1; i >= 0; i--) {
                Particle p = particles.get(i);
                if (p.checkAllDir(guy)){
                    if (guy instanceof AliveObject){
                        int dir = ((AliveObject)guy).getDir();
                        ((AliveObject)guy).setDir(p.getDir());
                        ((AliveObject)guy).setSpeed(5);
                        checkObstruction(Obstructions, guy);
                        ((AliveObject)guy).setDir(dir);
                        ((AliveObject)guy).setSpeed(0);
                    }
                    if (guy instanceof MoveObject){
                        int dir = ((MoveObject)guy).getDir();
                        ((MoveObject)guy).setDir(p.getDir());
                        ((MoveObject)guy).setSpeed(5);
                        checkObstruction(Obstructions, guy);
                        ((MoveObject)guy).setDir(dir);
                        ((MoveObject)guy).setSpeed(0);
                    }
                }
            }
        }

    }
   
}
