package BoringScenes;

import BoringObjects.AliveObject;
import BoringObjects.GameObject;
import BoringObjects.JustImage;
import BoringObjects.MoveObject;
import BoringSprites.*;
import BoringStuff.CollisionEffects;
import BoringStuff.ParticleEffects;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Scene2 extends Scene {
    //Background
    private JustImage background = new JustImage(0,0, getW(), getH(),29);
    //Effects
    private ParticleEffects particleEffects = new ParticleEffects();
    private CollisionEffects collisionEffects = new CollisionEffects(getW(),getH());
    //Player
    private Player player = super.getPlayer();
    private ArrayList<Particle> particles = super.getParticles();
    //Scene
    private ArrayList<Particle> badparticles = super.getBadparticles();
    private ArrayList<GameObject> Obstructions = super.getObstructions();
    private ArrayList<GameObject> allObstructions = new ArrayList<>();
    private GameObject[] objects = {
            new Enemy(300,300,70,70,100,100),
            new Block(400,300,50,50),
            new Crate(500,300,50,50,0,0),
            new TNT(300,400,50,50),
            new Ammo(400,400,50,50,0,0),
            new Medkit(500,400,50,50,0,0),
            new Mine(300,500,50,50,Color.cyan)
    };
    //adding stuff
    public Scene2(int W, int H, int sn) {
        super(W, H, sn);
        Obstructions.clear();
        for (int i = 0; i < getW()/50; i++) {
            Obstructions.add(new Wall(50*i,0,50,50));
        }
        for (int i = 0; i < getW()/50; i++) {
            Obstructions.add(new Wall(50*i,getH()-50,50,50));
        }
        for (int i = 0; i < getH()/50; i++) {
            Obstructions.add(new Wall(0,50*i,50,50));
        }
        for (int i = 0; i < getH()/50; i++) {
            Obstructions.add(new Wall(getW()-50,50*i,50,50));
        }
        Obstructions.addAll(Arrays.asList(objects));
        //no concurrent stuff
        allObstructions.addAll(Obstructions);
        allObstructions.add(player);
        setVisible(true);
    }
    public void updatePlayer() {
        collisionEffects.checkObstruction(Obstructions, player);
        particleEffects.RemoveParticles(particles);
    }
    @Override
    public void updateOther() {
        for (GameObject o: Obstructions) {
            collisionEffects.checkObstruction(allObstructions,o);
            collisionEffects.checkCollisionsBullet(particles,o);
            collisionEffects.checkParticlePush(Obstructions,particles,o);
            collisionEffects.checkMovePush(allObstructions,player,o);
        }
        particleEffects.RemoveParticles(badparticles);
    }
    public void update(Graphics window) { paint(window); }
    public void paint(Graphics window) {
        background.draw(window);
        for (GameObject o: Obstructions) {
            o.draw(window);
            o.drawSuper(window);
        }
        particleEffects.DrawAllParticles(particles,window);
        player.draw(window);
        player.drawSuper(window);
        window.setColor(Color.WHITE);
        window.setFont(new Font("TAHOMA", Font.BOLD,20));
        window.drawString("HP:"+player.getHP(),getW()-100,getH()-130);
        window.drawString("MP:"+player.getMP(),getW()-100,getH()-100);
        window.drawString("Dir:"+(player.getDir()-360),getW()-100,getH()-70);
        window.drawString("Spd:"+(player.getSpeed()/2),getW()-100,getH()-40);
    }
}