package BoringScenes;

import BoringObjects.GameObject;
import BoringObjects.JustImage;
import BoringSprites.*;
import BoringStuff.CollisionEffects;
import BoringStuff.ParticleEffects;

import java.awt.*;
import java.util.ArrayList;

public class Scene2 extends Scene {
    private JustImage background = new JustImage(0,0, getW(), getH(),29);
    private ParticleEffects particleEffects = new ParticleEffects();
    private CollisionEffects collisionEffects = new CollisionEffects(getW(),getH());
    //player
    private Player player = super.getPlayer();
    private ArrayList<Particle> particles = super.getParticles();
    //Enemy
    private Enemy enemy = new Enemy(300,300,100,100, 100, 100);
    private TNT tnt = new TNT(600,600,100,100);
    private Wall wall = new Wall(500,600,100,100);
    private Block block = new Block(700,600,100,100);
    private Mine mine = new Mine(400,600,0,0,Color.black);
    //Obstructions
    ArrayList<GameObject>Obstructions = new ArrayList<>();
    public Scene2(int W, int H, int sn) {
        super(W, H, sn);
        Obstructions.add(enemy);
        setVisible(true);
    }
    public void updatePlayer() {
        //collisionEffects.checkCollisionsBullet(otherparticles, player);
        collisionEffects.checkObstruction(Obstructions, player);
    }
    @Override
    public void updateOther() {
        collisionEffects.checkCollisionsBullet(particles, enemy);
        particleEffects.RemoveParticles(particles);
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
        tnt.draw(window);
        wall.draw(window);
        block.draw(window);
        mine.draw(window);
        enemy.draw(window);
        particleEffects.DrawAllParticles(particles,window);
        player.draw(window);
    }
}