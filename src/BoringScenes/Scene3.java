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
    private Message[] messages = {
            new Status(100,100,"Player",Color.WHITE,getPlayer())
    };
    private Flag target = new Flag(getW()-100,getH()-100,50,50,1);
    public Scene3(int W, int H, int scenenum) {
        super(W, H, scenenum);
        makeScene();
    }
    @Override
    public void updateStatus() {
        if (flagCheck(target)){
            setScenenum(2);
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
        setEnemies(getTestEnemy());
        updateStuff();
    }
}
