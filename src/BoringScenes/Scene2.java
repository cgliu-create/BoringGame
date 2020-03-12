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
    private Enemy[] enemies = {
            new Enemy(200,300,70,70,100,100),
            new Enemy(200,400,70,70,100,100),
            new Enemy(500,600,70,70,100,100),
            new Enemy(600,600,70,70,100,100),

            new Enemy(500,200,70,70,100,100),
            new Enemy(500,300,70,70,100,100),
            new Enemy(600,200,70,70,100,100),
            new Enemy(600,300,70,70,100,100),
    };
    private MoveObject[] moveObjects = {
            //new Block(400,300,50,50),
            //new Crate(500,300,50,50,0,0),
            //new TNT(300,400,50,50),
    };

    private ArrayList<GameObject>Obstructions = new ArrayList<>();
    //adding stuff
    public Scene2(int W, int H, int sn) {
        super(W, H, sn);
        setVisible(true);
        enemies[0].setDir(270);
        enemies[1].setDir(90);
        enemies[2].setDir(180);
        enemies[3].setDir(0);
        enemies[4].setDir(225);
        enemies[5].setDir(135);
        enemies[6].setDir(315);
        enemies[7].setDir(45);
        Obstructions.addAll(Arrays.asList(enemies));
        Obstructions.addAll(Arrays.asList(moveObjects));
        Obstructions.add(player);
        //borders
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
    }
    @Override
    public void updatePlayer() {
        for (GameObject entity: Obstructions) {
            collisionEffects.checkMovePush(Obstructions, player, entity);
        }
        collisionEffects.checkObstruction(Obstructions, player);
        particleEffects.RemoveParticles(particles);
    }
    @Override
    public void updateEnemies() {
        for (GameObject enemy: enemies) {
            collisionEffects.checkObstruction(Obstructions, enemy);
            particleEffects.RemoveParticles(badparticles);
        }
    }
    @Override
    public void updateOther() {
        for (Enemy enemy: enemies) {
            enemy.attack(particleEffects,badparticles,player);
            collisionEffects.checkCollisionsBullet(particles,enemy);
            collisionEffects.checkParticlePush(Obstructions,particles,enemy);
        }
        for (MoveObject item: moveObjects) {
            collisionEffects.checkCollisionsBullet(particles,item);
            collisionEffects.checkParticlePush(Obstructions,particles,item);
            collisionEffects.checkCollisionsBullet(badparticles,item);
            collisionEffects.checkParticlePush(Obstructions,badparticles,item);
        }
        collisionEffects.checkCollisionsBullet(badparticles,player);
        collisionEffects.checkParticlePush(Obstructions,badparticles,player);
    }
    public void update(Graphics window) { paint(window); }
    public void paint(Graphics window) {
        background.draw(window);
        for (GameObject o: Obstructions) {
            o.draw(window);
            o.drawSuper(window);
        }
        particleEffects.DrawAllParticles(particles,window);
        particleEffects.DrawAllParticles(badparticles,window);
        window.setColor(Color.WHITE);
        window.setFont(new Font("TAHOMA", Font.BOLD,20));
        window.drawString("HP:"+player.getHP(),getW()-100,getH()-130);
        window.drawString("MP:"+player.getMP(),getW()-100,getH()-100);
        window.drawString("Dir:"+(player.getDir()-360),getW()-100,getH()-70);
        window.drawString("Spd:"+(player.getSpeed()/2),getW()-100,getH()-40);
    }
}