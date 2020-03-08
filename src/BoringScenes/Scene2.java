package BoringScenes;
import BoringObjects.GameObject;
import BoringSprites.Enemy;
import BoringSprites.JustImage;
import BoringSprites.Particle;
import BoringSprites.Player;

import java.awt.*;
import java.util.ArrayList;

public class Scene2 extends Scene {
    private Player player = super.getPlayer();
    private ArrayList<Particle> particles = super.getParticles();
    private ParticleEffects particleEffects = super.getParticleEffects();
    private Enemy enemy = new Enemy(300,100,100,100, 100, 100);
    private JustImage background = new JustImage(0,0, getW(), getH(),16);
    public Scene2(int W, int H) {
        super(W, H);
        //setBackground(Color.black);
        setVisible(true);
    }
    @Override
    public void updateOther() {
        particleEffects.RemoveParticles(particles);
    }
    public void update(Graphics window) { paint(window); }
    public void paint(Graphics window) {
        background.draw(window);
        enemy.draw(window);
        particleEffects.DrawAllParticles(particles,window);
        super.getPlayer().draw(window);
        window.setFont(new Font("TAHOMA", Font.BOLD,20));
        window.drawString("HP:"+player.getHP(),getW()-100,getH()-130);
        window.drawString("MP:"+player.getMP(),getW()-100,getH()-100);
        window.drawString("Dir:"+(player.getDir()-360),getW()-100,getH()-70);
        window.drawString("Spd:"+(player.getSpeed()/2),getW()-100,getH()-40);

    }
}