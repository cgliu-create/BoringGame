package BoringEffects;

import java.awt.Color;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import BoringObjects.AliveObject;
import BoringObjects.CollisObject;
import BoringObjects.GameObject;
import BoringObjects.MoveObject;
import BoringSprites.*;

public class CollisionEffects {
//Effects
    private CollisObject temp = new CollisObject(0,0,0,0);
    private ParticleEffects pe = new ParticleEffects();
//MOVING
public void setTemp(int x, int y, GameObject guy){
    temp.setXPos(x);temp.setYPos(y);
    temp.setHeight(guy.getHeight());temp.setWidth(guy.getWidth());
    temp.setRadius(guy.getRadius());
}
    public boolean checkObstruction(CopyOnWriteArrayList<GameObject>Obstructions, GameObject guy){
        int x = 0; int y = 0;
        if (guy instanceof AliveObject) {
            x = guy.getXPos() + ((AliveObject)guy).getXspeed();
            y = guy.getYPos() + ((AliveObject)guy).getYspeed();
        }
        if (guy instanceof MoveObject) {
            x = guy.getXPos() + ((MoveObject)guy).getXspeed();
            y = guy.getYPos() + ((MoveObject)guy).getYspeed();
        }
        setTemp(x, y, guy);
        boolean obstruction = false;
        for (GameObject gameObject : Obstructions) {
            if (!(guy.equals(gameObject))&&temp.checkAllDir(gameObject)) { obstruction = true; break;}
        }
        if (!obstruction) {
            guy.setXPos(x); guy.setYPos(y);
        }
        return obstruction;
    }
//PUSHING FROM PLAYER
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
//REMOVING BULLETS
    public void checkCollisionsBullet(ArrayList<Particle> particles, GameObject guy) {
        ArrayList<Particle> toRemove = new ArrayList<>();
        for (int i = particles.size() - 1; i >= 0; i--) {
            Particle p = particles.get(i);
            if (p.getColor()!=Color.RED&&p.getColor()!=Color.ORANGE&&p.getColor()!=Color.YELLOW&&p.getColor()!=Color.DARK_GRAY){
                if (p.checkAllDir(guy)){
                    pe.KaBoom(particles,p.getXPos(),p.getYPos(),Color.DARK_GRAY,10);
                    toRemove.add(p);
                    int mp = 1;
                    if (p instanceof LavaBall) { pe.BigKaBoom(particles, p.getCenterX(), p.getCenterY(), p.getWidth(), p.getHeight()); mp = 10;}
                    if (p instanceof Bomb) { pe.BigKaBoom(particles, p.getXPos(), p.getYPos(), p.getWidth(), p.getHeight()); mp = 10;}
                    if (p instanceof Grenade) { pe.ShootAllDir(particles, (Grenade)p); mp = 10;}
                    if (p instanceof Bomba) { pe.ShootAllDir(particles, (Bomba)p); mp = 10;}
                    if (p instanceof LavaBall) { pe.BigKaBoom(particles, p.getCenterX(), p.getCenterY(), p.getWidth(), p.getHeight()); mp = 10;}
                    if (guy instanceof AliveObject) { ((AliveObject)guy).changeHP(-mp);}
                    if (guy instanceof Flag){ ((Flag) guy).setType(2);}
                }
            }
        }
        particles.removeAll(toRemove);
    }

//PUSHING WITH EXPLOSIONS
    public void checkParticlePush(CopyOnWriteArrayList<GameObject>Obstructions, ArrayList<Particle> particles, MoveObject guy){
        for (int i = particles.size() - 1; i >= 0; i--){
            Particle p = particles.get(i);
            if (p.getColor()==Color.RED||p.getColor()==Color.ORANGE||p.getColor()==Color.YELLOW) {
                if (p.checkAllDir(guy)) { // collision
                    int dir = guy.getDir();
                    guy.setDir(p.getDir());  guy.setSpeed(5); //move away from particle
                    checkObstruction(Obstructions, guy);
                    guy.setDir(dir); guy.setSpeed(0); // reset dir and spd
                }
            }
        }
    }
//CHECKING PARTICLE INTERACTION
    public void checkParticleInteraction(CopyOnWriteArrayList<GameObject>Obstructions, ArrayList<Particle> particles, MoveObject guy){
        checkCollisionsBullet(particles, guy);
        checkParticlePush(Obstructions,particles,guy);
    }
}
