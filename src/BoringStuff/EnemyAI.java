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
    private int scoutDistance;
    //Effect
    private ParticleEffects particleEffects = new ParticleEffects();
    //CONSTRUCTING
    public EnemyAI(Enemy thisGuy, int scoutDir, int scoutDistance) {
        enemy = thisGuy;
        enemyTargeting = new EnemyTargeting(thisGuy);
        enemyScouting = new EnemyScouting(thisGuy,scoutDir,scoutDistance);
        this.scoutDistance = scoutDistance;
    }
    public void aiBehavior(ArrayList<Particle> badparticles,Player player){
        enemyScouting.calcSeeing(player);
        enemyTargeting.calcSeeing(player);
        if (enemyScouting.checkAndPatrol(player)){
            enemyTargeting.lineUpShot();
            if (enemyTargeting.checkEnemyInSight(player)){
                if(player.checkIfAlive()) {
                    particleEffects.Shoot(badparticles, enemy);
                }
            }
            if (enemyTargeting.checkOutOfRange()){
                enemyScouting.calcPointsAndDirections(enemyTargeting.getAimDir(),scoutDistance,enemy.getXPos(),enemy.getYPos());
                enemyScouting.checkAndPatrol(player);
            }
        }
    }
    //RENDERING
    public void draw(Graphics window) {
            enemyScouting.draw(window);
            enemyTargeting.draw(window);
    }
}

//CHASING PLAYER
//SCOUTING
//LOOKING AROUND
//TARGETING AND ATTACKING