package BoringStuff;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import BoringEffects.ParticleEffects;
import BoringObjects.AliveObject;
import BoringSprites.Enemy;
import BoringSprites.Particle;
import BoringSprites.Player;
import BoringSprites.Shooty;

public class EnemyAI {
    private Enemy enemy;
    private EnemyTargeting enemyTargeting;
    //Effect
    private ParticleEffects particleEffects = new ParticleEffects();
    //CONSTRUCTING
    public EnemyAI(Enemy thisGuy) {
        enemy = thisGuy;
        enemyTargeting = new EnemyTargeting(thisGuy);
    }
    public void checktargeting(ArrayList<Particle> badparticles, Player player){
        enemyTargeting.lineUpShot(player);
        if (enemyTargeting.checkEnemyInSight(badparticles,player)){
            particleEffects.Shoot(badparticles,enemy);
        }
    }
    //RENDERING
    public void draw(Graphics window) {
       enemyTargeting.draw(window);
    }
}

//CHASING PLAYER
//SCOUTING
//LOOKING AROUND
//REACTING TO NEARBY GUNFIRE
