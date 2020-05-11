package BoringScenes;

import BoringImages.BoringImage;
import BoringObjects.CollisObject;
import BoringObjects.MoveObject;
import BoringSprites.*;

import java.awt.*;
import java.util.ArrayList;

public class Scene3 extends Scene{
    /*
    level one
     */
    private MoveObject[] interactables ={
            new Crate(200,200,50,50),
            new Block(300,300,50,50),
            new TNT(500,500,50,50)
    };
    private Message[] messages = {
            new Status(100,100,"Player",Color.WHITE,getPlayer())
    };
    private Enemy[] enemies = {
            new Enemy(400,400,50,50,100,100,45,300)
    };
    private Flag target = new Flag(getW()-100,getH()-100,50,50,1);
    public Scene3(int W, int H, int scenenum) {
        super(W, H, scenenum);
        makeScene();
    }

    @Override
    public void updateStatus() {
        if (flagCheck(target)){
            resetOther();
            resetPlayer();
            setScenenum(2);
            target.setType(1);
        }
        if(!(getPlayer().checkIfAlive())){
            resetOther();
            resetPlayer();
            setScenenum(4);
            target.setType(1);
        }
    }

    @Override
    public void makeScene() {
        setBackground(BoringImage.green.getImgLoc());
        ArrayList<CollisObject> temp = new ArrayList<>();
        temp.add(target);
        addFourWalls(temp);
        setEnvironment(temp);
        setMessages(messages);
        setEnemies(enemies);
        updateStuff();
        setInteractables(interactables);
    }
}
