package BoringStuff;

import java.awt.Color;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import BoringObjects.AliveObject;
import BoringObjects.CollisObject;
import BoringObjects.GameObject;
import BoringObjects.MoveObject;
import BoringSprites.Bomb;
import BoringSprites.Particle;

public class CollisionEffects {
//Effects
    private CollisObject temp = new CollisObject(0,0,0,0);
    private ParticleEffects pe = new ParticleEffects();
//REMOVING
    public void checkCollisionsBullet(ArrayList<Particle> particles, GameObject guy) {
        ArrayList<Particle> toRemove = new ArrayList<>();
        for (int i = particles.size() - 1; i >= 0; i--) {
            Particle p = particles.get(i);
            if (p.getColor()!=Color.RED&&p.getColor()!=Color.ORANGE&&p.getColor()!=Color.YELLOW&&p.getColor()!=Color.DARK_GRAY){
                if (p.checkAllDir(guy)){ 
                    pe.KaBoom(particles,p.getXPos(),p.getYPos(),Color.DARK_GRAY,10); 
                    toRemove.add(p);
                    if (p instanceof Bomb) { pe.BigKaBoom(particles, p.getXPos(), p.getYPos(), p.getWidth(), p.getHeight());}
                }
            }
        }
        particles.removeAll(toRemove);
    }
    public ArrayList<GameObject> checkNear(){
    return null;
    }
//MOVING
    public void checkObstruction(CopyOnWriteArrayList<GameObject>Obstructions, GameObject guy){
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
        boolean obstructionFree = true;
        for (GameObject gameObject : Obstructions) {
            if (!(guy.equals(gameObject))&&temp.checkAllDir(gameObject)) { obstructionFree = false; break;}
        }
        if (obstructionFree) {guy.setXPos(x); guy.setYPos(y);}
    }
    public void setTemp(int x, int y, GameObject guy){
        temp.setXPos(x);temp.setYPos(y);
        temp.setHeight(guy.getHeight());temp.setWidth(guy.getWidth());
        temp.setRadius(guy.getRadius());
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
//PUSHING WITH EXPLOSIONS
    public void checkParticlePush(CopyOnWriteArrayList<GameObject>Obstructions, ArrayList<Particle> particles, AliveObject guy){
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
}
