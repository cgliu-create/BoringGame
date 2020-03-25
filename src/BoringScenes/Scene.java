package BoringScenes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;

import BoringObjects.CollisObject;
import BoringObjects.GameObject;
import BoringObjects.MoveObject;
import BoringSprites.*;
import BoringEffects.CollisionEffects;
import BoringEffects.ParticleEffects;
import javax.swing.*;
import java.awt.*;
//importing classes     https://stackoverflow.com/questions/28651061/how-to-import-my-own-class

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
    private ArrayList<CollisObject> environment = new ArrayList<>();
    private ArrayList<JustImage> someimages = new ArrayList<>();
    private ArrayList<Message> somemessages= new ArrayList<>();
//List of things to draw    https://www.javacodegeeks.com/2011/05/avoid-concurrentmodificationexception.html
    private CopyOnWriteArrayList<Particle> AllParticles = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<GameObject> AllStuff = new CopyOnWriteArrayList<>();
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
//CHANGING SCENES
    public int getScenenum(){return scenenum;}
    public void setScenenum(int scenenum){this.scenenum = scenenum;}
    public abstract void updateStatus( );
    public boolean flagCheck(Flag button){
        collisionEffects.checkCollisionsBullet(particles,button);
        return button.getType() == 2;
    }
//ADDING PLAYER INPUT
    public PlayerInput getPlayerInput(){ return playerInput;}
    //EDITING PLAYER
    public Player getPlayer(){ return player; }
//SIZING
    public int getH() { return H; }
    public int getW() { return W; }
    public void setH(int h) { H = h; }
    public void setW(int w) { W = w; }
    //CHOOSING BACKGROUND
    public void setBackground(String img){
        someimages.clear();
        background= new JustImage(0,0,getW(),getH(),img);
        someimages.add(background);
    }
//CREATING A SPECIFIC SCENE
    public void setAdditionalImages(JustImage[] imgs){ someimages.addAll(Arrays.asList(imgs)); }
    public void setEnemies(Enemy[] myEnemies){ enemies.clear(); enemies.addAll(Arrays.asList(myEnemies));}
    public void setInteractables(MoveObject[] moveObjects){ interactables.clear(); interactables.addAll(Arrays.asList(moveObjects));}
    public void setEnvironment(ArrayList<CollisObject> enviro){ environment.clear(); environment.addAll(enviro);}
    public void setMessages(Message[] msgs){ somemessages.clear(); somemessages.addAll(Arrays.asList(msgs));}

    public abstract void makeScene();
    //UPDATING ITEMS
    public void updateStuff(){
        AllStuff.clear();
        AllStuff.addAll(enemies);
        AllStuff.addAll(interactables);
        AllStuff.addAll(environment);
    }
    public void updateAllParticles(){
        AllParticles.clear();
        AllParticles.addAll(badparticles);
        AllParticles.addAll(particles);
    }
//UPDATING SCENE
    public void updatePlayer(){
        //allows player to push
        collisionEffects.checkMovePush(AllStuff,interactables,player);
        //allows player to move
        collisionEffects.checkObstruction(AllStuff, player);
        //animates particles
        particleEffects.RemoveParticles(particles);
        //particle collisions
        collisionEffects.checkParticleInteraction(AllStuff,badparticles,player);
    }
    public void updateEnemies(){
        for (Enemy enemy: enemies){
            //moves enemy
            if(collisionEffects.checkObstruction(AllStuff, enemy)){
                enemy.turn(180);
            }
            //particle collisions
            collisionEffects.checkParticleInteraction(AllStuff,particles,enemy);
            enemy.aiAction(badparticles,player);
        }
        //animates particles
        particleEffects.RemoveParticles(badparticles);
    }
    public void updateOther(){
        for (MoveObject item: interactables){
            collisionEffects.checkParticleInteraction(AllStuff,particles,item);
            collisionEffects.checkParticleInteraction(AllStuff,badparticles,item);
        }
        for (GameObject thing: environment) {
            collisionEffects.checkCollisionsBullet(particles,thing);
            collisionEffects.checkCollisionsBullet(badparticles,thing);
        }
    }
    //RENDERING EVERYTHING
    public void update(Graphics window){ paint(window);}
    public void paint(Graphics window){
        for (JustImage img: someimages) {
            try {
                img.draw(window);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for (Message message: somemessages){
            try {
                message.draw(window);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        updateAllParticles();
        try {
            particleEffects.DrawAllParticles(AllParticles, window);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (GameObject thing: AllStuff){
            try {
                thing.draw(window);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            player.draw(window);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public  void addWallH(ArrayList<CollisObject> temp , int x, int y, int n){
        for (int i = 0; i < n; i++) { temp.add(new Wall(x+i*50,y,50,50)); }
    }
    public  void addWallV(ArrayList<CollisObject> temp , int x, int y, int n){
        for (int i = 0; i < n; i++) { temp.add(new Wall(x,y+i*50,50,50)); }
    }
    public void addFourWalls(ArrayList<CollisObject> temp){
        for (int i = 0; i < getW()/50; i++) { temp.add(new Wall(i*50,0,50,50)); }
        for (int i = 0; i < getW()/50; i++) { temp.add(new Wall(i*50,getH()-50,50,50)); }
        for (int i = 0; i < getH()/50; i++) { temp.add(new Wall(0,i*50,50,50)); }
        for (int i = 0; i < getH()/50; i++) { temp.add(new Wall(getW()-50,i*50,50,50)); }
    }
    public void resetPlayer(){
        getPlayer().setDir(360);
        getPlayer().setSpeed(0);
        getPlayer().setXPos(100);
        getPlayer().setYPos(100);
        getPlayer().setHP(100);
        getPlayer().setMP(100);
    }
    public void resetOther(){
        for (Enemy enemy: enemies){
            enemy.resetEnemy();
        }
    }
}
