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
    private Enemy e1 = new Enemy(300,300,100,100,100,100);
    private Block b = new Block(400,300,100,100);
    private Crate c = new Crate(500,300,100,100,0,0);
    private TNT t = new TNT(300,400,100,100);

    //adding stuff
    public Scene2(int W, int H, int sn) {
        super(W, H, sn);
        Obstructions.add(b);
        Obstructions.add(c);
        Obstructions.add(t);
        Obstructions.add(e1);
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
            collisionEffects.checkObstruction(allObstructions, o);
            collisionEffects.checkCollisionsBullet(particles, o);
            collisionEffects.checkParticlePush(particles,Obstructions,o);
            collisionEffects.checkMovePush(allObstructions,o,player);
        }
        particleEffects.RemoveParticles(badparticles);
    }
    public void update(Graphics window) { paint(window); }
    public void paint(Graphics window) {
        background.draw(window);
        window.setColor(Color.WHITE);
        window.setFont(new Font("TAHOMA", Font.BOLD,20));
        window.drawString("HP:"+player.getHP(),getW()-100,getH()-130);
        window.drawString("MP:"+player.getMP(),getW()-100,getH()-100);
        window.drawString("Dir:"+(player.getDir()-360),getW()-100,getH()-70);
        window.drawString("Spd:"+(player.getSpeed()/2),getW()-100,getH()-40);
        for (GameObject o: Obstructions) {
            o.draw(window);
            o.drawSuper(window);
        }
        particleEffects.DrawAllParticles(particles,window);
        player.draw(window);
        player.drawSuper(window);
    }
}