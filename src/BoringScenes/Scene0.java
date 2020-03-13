package BoringScenes;

import BoringObjects.MoveObject;
import BoringSprites.Block;
import BoringSprites.Crate;
import BoringSprites.Enemy;
import BoringSprites.TNT;

public class Scene0 extends Scene{
//Scene stuff
    private Enemy[] enemies = {
        new Enemy(400,400,70,70,100,100),
        new Enemy(300,400,70,70,100,100),
        new Enemy(400,200,70,70,100,100),
        new Enemy(400,500,70,70,100,100)
    };
    private MoveObject[] moveObjects = {
        new Block(400,300,50,50),
        new Crate(500,300,50,50),
        new TNT(300,400,50,5)
    };
//ADDING STUFF
    public Scene0(int W, int H, int scenenum) {
        super(W, H, scenenum);
        setBackground(29);
        setEnemies(enemies);
        setInteractables(moveObjects);
        updateStuff();
    }
}
