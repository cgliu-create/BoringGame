package BoringScenes;

import BoringObjects.CollisObject;
import BoringSprites.Flag;
import BoringSprites.Message;

import java.awt.*;
import java.util.ArrayList;

public class Scene5 extends Scene{
    /*
  Game win
   */
    private Message[] messages = {
            new Message(getW()/4,getH()/4,100, "YOU WIN", Color.WHITE)
    };
    private Flag levelselect = new Flag(getW()/2,getH()/2,50,50,0);

    public Scene5(int W, int H, int scenenum) {
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
