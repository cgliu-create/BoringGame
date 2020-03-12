package BoringScenes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;
import BoringObjects.GameObject;
import BoringObjects.MoveObject;
import BoringObjects.JustImage;
import BoringSprites.Particle;
import BoringSprites.Player;
import BoringSprites.Enemy;
import BoringSprites.Wall;
import BoringStuff.CollisionEffects;
import BoringStuff.ParticleEffects;
import BoringStuff.PlayerInput;
import javax.swing.*;
import java.awt.*;

public abstract class Scene extends JPanel {
    //Panel size
    private int W, H;
    //Player Input
    private PlayerInput playerInput = new PlayerInput();
    //Player
    private Player player = playerInput.getPlayer();
    //Enemies
    private ArrayList<Enemy> enemies = new ArrayList<>();
    //Particles
    private ArrayList<Particle> particles = playerInput.getParticles();
    private ArrayList<Particle> badparticles = new ArrayList<>();
    //Misc
    private ArrayList<MoveObject> interactables = new ArrayList<>();
    //All things to draw that change    https://www.javacodegeeks.com/2011/05/avoid-concurrentmodificationexception.html
    private CopyOnWriteArrayList<Particle>AllParticles = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<GameObject>AllStuff = new CopyOnWriteArrayList<>();
    //Effects
    private ParticleEffects particleEffects = new ParticleEffects();
    private CollisionEffects collisionEffects = new CollisionEffects();
    //Scene number
    private int scenenum;
    //Background
    private JustImage background;
    //CONSTRUCTING
    public Scene(int W, int H, int scenenum){
        setSize(W,H);
        setVisible(true);
        this.W = W;
        this.H = H;
        this.scenenum = scenenum;
    }
    //CHOOSING BACKGROUND
    public void setBackground(int img){
        background= new JustImage(0,0,getW(),getH(),img);
    }
    //CHANGING SCENES
    public int getScenenum(){return scenenum;}
    public void setScenenum(int scenenum){this.scenenum = scenenum;}
    //ADDING PLAYER INPUT
    public PlayerInput getPlayerInput(){ return playerInput;}
    //SIZING
    public int getH() { return H; }
    public int getW() { return W; }
    public void setH(int h) { H = h; }
    public void setW(int w) { W = w; }
    //CREATING A SPECIFIC SCENE
    public void setEnemies(Enemy[] myEnemies){ enemies.clear(); enemies.addAll(Arrays.asList(myEnemies));}
    public void setInteractables(MoveObject[] moveObjects){ interactables.clear(); interactables.addAll(Arrays.asList(moveObjects));}
    //UPDATING ITEMS
    public void updateStuff(){ AllStuff.clear(); AllStuff.add(player); AllStuff.addAll(enemies); AllStuff.addAll(interactables);}
    public void updateAllParticles(){ AllParticles.clear(); AllParticles.addAll(badparticles); AllParticles.addAll(particles);}
    //UPDATING SCENE
    public void updatePlayer(){
        collisionEffects.checkMovePush(AllStuff,interactables,player);
        collisionEffects.checkObstruction(AllStuff, player);
        collisionEffects.checkCollisionsBullet(badparticles,player);
        collisionEffects.checkParticlePush(AllStuff,badparticles,player);
        particleEffects.RemoveParticles(particles);
    }
    public void updateEnemies(){
        for (Enemy enemy: enemies){
            enemy.attack(badparticles,player);
            collisionEffects.checkObstruction(AllStuff, enemy);
            collisionEffects.checkCollisionsBullet(particles,enemy);
            collisionEffects.checkParticlePush(AllStuff,particles,enemy);
            particleEffects.RemoveParticles(badparticles);
        }
    }
    public void updateOther(){
        for (MoveObject item: interactables){
            collisionEffects.checkCollisionsBullet(particles, item);
            collisionEffects.checkParticlePush(AllStuff,particles,item);
            collisionEffects.checkCollisionsBullet(badparticles, item);
            collisionEffects.checkParticlePush(AllStuff,badparticles,item);
        }
    }
    //RENDERING EVERYTHING
    public void update(Graphics window){ paint(window);}
    public void paint(Graphics window){
        background.draw(window);
        updateAllParticles();
        particleEffects.DrawAllParticles(AllParticles, window);
        for (GameObject thing: AllStuff){
            thing.draw(window);
            thing.drawSuper(window);
        }
    }

}
