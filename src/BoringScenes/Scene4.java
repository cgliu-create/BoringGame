package BoringScenes;

import BoringEffects.CollisionEffects;
import BoringImages.BoringImage;
import BoringObjects.CollisObject;
import BoringSprites.Flag;
import BoringSprites.Message;
import BoringSprites.Status;

import java.awt.*;
import java.util.ArrayList;

public class Scene4 extends Scene{
    /*
    Game Over
     */
    private Message[] messages = {
            new Message(getW()/4,getH()/4,100, "YOU LOSE",Color.WHITE)
    };
    private Flag levelselect = new Flag(getW()/2,getH()/2,50,50,0);

    public Scene4(int W, int H, int scenenum) {
        super(W, H, scenenum);
        makeScene();
    }

    @Override
    public void updateStatus() {
        if (flagCheck(levelselect)){
            setScenenum(2);
            levelselect.setType(0);
        }
    }

    @Override
    public void makeScene() {
        setBackground(Color.BLACK);
        ArrayList<CollisObject> temp = new ArrayList<>();
        temp.add(levelselect);
        addFourWalls(temp);
        setEnvironment(temp);
        setMessages(messages);
        updateStuff();
    }
}