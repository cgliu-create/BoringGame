package BoringScenes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;
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
//ADDING PLAYER INPUT
    public PlayerInput getPlayerInput(){ return playerInput;}
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
    public void setMessages(Message[] msgs){ somemessages.clear(); somemessages.addAll(Arrays.asList(msgs));}
    //UPDATING ITEMS
    public void updateStuff(){
        AllStuff.clear();
        AllStuff.add(player);
        AllStuff.addAll(enemies);
        AllStuff.addAll(interactables);
        AllStuff.addAll(someimages);
        AllStuff.addAll(somemessages);
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
            collisionEffects.checkObstruction(AllStuff, enemy);
            //particle collisions
            collisionEffects.checkParticleInteraction(AllStuff,particles,enemy);
        }
        //animates particles
        particleEffects.RemoveParticles(badparticles);
    }
    public void updateOther(){
        for (MoveObject item: interactables){
            collisionEffects.checkParticleInteraction(AllStuff,particles,item);
            collisionEffects.checkParticleInteraction(AllStuff,badparticles,item);
        }
    }
    //RENDERING EVERYTHING
    public void update(Graphics window){ paint(window);}
    public void paint(Graphics window){
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
            thing.drawSuper(window);
        }
        player.drawStatus(window,W-100,H-200,Color.WHITE);
    }
}
