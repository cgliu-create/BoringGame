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
    //CONSTRUCTING
    public EnemyAI(Enemy thisGuy) {
        enemy = thisGuy;
        enemyTargeting = new EnemyTargeting(thisGuy);
    }
    public void checktargeting(ArrayList<Particle> badparticles, Player player){
        enemyTargeting.checkEnemyInSight(badparticles,player);
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
