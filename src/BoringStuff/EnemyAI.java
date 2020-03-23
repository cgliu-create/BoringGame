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
    private EnemyScouting enemyScouting;
    //Effect
    private ParticleEffects particleEffects = new ParticleEffects();
    //CONSTRUCTING
    public EnemyAI(Enemy thisGuy, int scoutDir, int scoutDistance) {
        enemy = thisGuy;
        enemyTargeting = new EnemyTargeting(thisGuy);
        enemyScouting = new EnemyScouting(thisGuy,scoutDir,scoutDistance);
    }
    public void checktargeting(ArrayList<Particle> badparticles, Player player){
        enemyTargeting.lineUpShot();
        if (enemyTargeting.checkEnemyInSight(player)){
            particleEffects.Shoot(badparticles,enemy);
        }
    }
    public void scoutTarget(ArrayList<Particle> badparticles, Player player){
        if (enemyScouting.patrol(player)){
            checktargeting(badparticles, player);
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
//uhhh