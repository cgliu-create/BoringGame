package BoringStuff;

import BoringObjects.AliveObject;
import BoringSprites.Enemy;

public class EnemyTurning {
    private Enemy enemy;
    public EnemyTurning(Enemy enemy){
        this.enemy = enemy;
    }
    public boolean checkDir0(AliveObject player){ //target is to the right
        return player.getXPos() > enemy.getXPos();
    }
    public boolean checkDir45(AliveObject player){ //target is to the right and bottom
        return player.getXPos() > enemy.getXPos() && player.getYPos() > enemy.getYPos();
    }
    public boolean checkDir90(AliveObject player){ //target is to the bottom
        return player.getYPos() > enemy.getYPos();
    }
    public boolean checkDir135(AliveObject player){  //target is to the left and bottom
        return player.getXPos() < enemy.getXPos() && player.getYPos() > enemy.getYPos();
    }
    public boolean checkDir180(AliveObject player){  //target is to the left
        return player.getXPos() < enemy.getXPos() && player.getYPos() > enemy.getYPos();
    }
    public boolean checkDir225(AliveObject player){  //target is to the left and top
        return player.getXPos() < enemy.getXPos() && player.getYPos() < enemy.getYPos();
    }
    public boolean checkDir270(AliveObject player){  //target is to the top
        return player.getYPos() < enemy.getYPos();
    }
    public boolean checkDir315(AliveObject player){  //target is to the right and top
        return player.getXPos() > enemy.getXPos() && player.getYPos() < enemy.getYPos();
    }
    public boolean checkToLeft(int enemyDir, AliveObject player){
        if(enemyDir == 0){ return checkDir0(player)||checkDir315(player)||checkDir270(player)||checkDir225(player)||checkDir180(player);}
        if(enemyDir == 45){ return checkDir45(player)||checkDir0(player)||checkDir315(player)||checkDir270(player)||checkDir225(player);}
        if(enemyDir == 90){ return checkDir90(player)||checkDir45(player)||checkDir0(player)||checkDir315(player)||checkDir270(player);}
        if(enemyDir == 135){ return checkDir135(player)||checkDir90(player)||checkDir45(player)||checkDir0(player)||checkDir315(player);}
        if(enemyDir == 180){ return checkDir180(player)||checkDir135(player)||checkDir90(player)||checkDir45(player)||checkDir0(player);}
        if(enemyDir == 225){ return checkDir225(player)||checkDir180(player)||checkDir135(player)||checkDir90(player)||checkDir45(player);}
        if(enemyDir == 270){ return checkDir270(player)||checkDir225(player)||checkDir180(player)||checkDir135(player)||checkDir90(player);}
        if(enemyDir == 315){ return checkDir315(player)||checkDir270(player)||checkDir225(player)||checkDir180(player)||checkDir135(player);}
        return false;
    }
    public boolean checkToRight(int enemyDir, AliveObject player){
        if(enemyDir == 0){ return checkDir0(player)||checkDir45(player)||checkDir90(player)||checkDir135(player)||checkDir180(player);}
        if(enemyDir == 45){ return checkDir45(player)||checkDir90(player)||checkDir135(player)||checkDir180(player)||checkDir225(player);}
        if(enemyDir == 90){ return checkDir90(player)||checkDir135(player)||checkDir180(player)||checkDir225(player)||checkDir270(player);}
        if(enemyDir == 135){ return checkDir135(player)||checkDir180(player)||checkDir225(player)||checkDir270(player)||checkDir315(player);}
        if(enemyDir == 180){ return checkDir180(player)||checkDir225(player)||checkDir270(player)||checkDir315(player)||checkDir0(player);}
        if(enemyDir == 225){ return checkDir225(player)||checkDir270(player)||checkDir315(player)||checkDir0(player)||checkDir45(player);}
        if(enemyDir == 270){ return checkDir270(player)||checkDir315(player)||checkDir0(player)||checkDir45(player)||checkDir90(player);}
        if(enemyDir == 315){ return checkDir315(player)||checkDir0(player)||checkDir45(player)||checkDir90(player)||checkDir135(player);}
        return false;
    }
    public void makeTurn(int enemyDir, AliveObject player){
        if(checkToLeft(enemyDir,player)){
            enemy.turnLeft();
        }
        if(checkToRight(enemyDir,player)){
            enemy.turnRight();
        }
    }
    public void turnToPlayer(AliveObject player){
        if(Math.abs(enemy.getDir())%360==0){
            makeTurn(0,player);
        }
        if(Math.abs(enemy.getDir())%360==45){
            makeTurn(45,player);
        }
        if(Math.abs(enemy.getDir())%360==90){
            makeTurn(90,player);
        }
        if(Math.abs(enemy.getDir())%360==135){
            makeTurn(135,player);
        }
        if(Math.abs(enemy.getDir())%360==180){
            makeTurn(180,player);
        }
        if(Math.abs(enemy.getDir())%360==225){
            makeTurn(225,player);
        }
        if(Math.abs(enemy.getDir())%360==270){
            makeTurn(270,player);
        }
        if(Math.abs(enemy.getDir())%360==315){
            makeTurn(315,player);
        }
    }
}
