package BoringScenes;
import BoringObjects.CollisObject;
import BoringSprites.Enemy;
import BoringObjects.JustImage;
import BoringSprites.Particle;
import BoringSprites.Player;
import BoringStuff.ParticleEffects;

import java.awt.*;
import java.util.ArrayList;

public class Scene2 extends Scene {
    private Player player = super.getPlayer();
    private CollisObject temp = new CollisObject(0,0,player.getWidth(),player.getHeight());
    private ArrayList<Particle> particles = super.getParticles();
    private ParticleEffects particleEffects = super.getParticleEffects();
    private Enemy enemy = new Enemy(300,300,100,100, 100, 100);
    private JustImage background = new JustImage(0,0, getW(), getH(),16);
    public Scene2(int W, int H) {
        super(W, H);
        //setBackground(Color.black);
        setVisible(true);
    }
    public void updatePlayer() {
        int x = player.getXPos()+player.getXspeed();
        int y = player.getYPos()+player.getYspeed();
        temp.setXPos(x);temp.setYPos(y);
        if (!(temp.checkAllDir(enemy))){
            if (x>=0&&x<=getW()-player.getWidth()) //x bounds
                player.setXPos(x);
            if (y>=0&&y<=getH()-player.getHeight()) //y bounds
                player.setYPos(y);
        }
    }
    @Override
    public void updateOther() {
        particleEffects.checkCollisionsDamage(particles,enemy);
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
        enemy.draw(window);
        enemy.drawSuper(window);
        particleEffects.DrawAllParticles(particles,window);
        player.draw(window);
        player.drawSuper(window);
        temp.draw(window);

    }
}