package BoringScenes;

import BoringImages.BoringImage;
import BoringObjects.CollisObject;
import BoringSprites.Enemy;
import BoringSprites.Flag;
import BoringSprites.Message;
import BoringSprites.Status;

import java.awt.*;
import java.util.ArrayList;

public class Scene3 extends Scene{
    /*
    level one
     */
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
    }
}
