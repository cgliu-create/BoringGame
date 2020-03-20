package BoringScenes;

import BoringImages.BoringImage;
import BoringObjects.CollisObject;
import BoringSprites.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Scene2 extends Scene{

    private JustImage[] images = {
            new JustImage(0,0,getW(),getH()/3,BoringImage.green.getImgLoc()),
            new JustImage(0,getH()/3,getW(),getH()/3,BoringImage.brown.getImgLoc()),
            new JustImage(0,getH()/3*2,getW(),getH()/3,BoringImage.gray.getImgLoc())
    };
    private Flag[] level = {
            new Flag(getW()/3,getH()/3/2,50,50,1)
    };
    private Message[] messages = {
            new Message(getW() / 2, 100, 50, "LEVEL SELECT", Color.WHITE),
    };
    //ADDING STUFF
    public Scene2(int W, int H, int scenenum) {
        super(W, H, scenenum);
        makeScene();
    }
    @Override
    public void updateStatus() {
        if (flagCheck(level[0])){
            setScenenum(3);
            level[0].setType(0);
        }
    }

    @Override
    public void makeScene() {
        ArrayList<CollisObject> temp = new ArrayList<>();
        addFourWalls(temp);
        temp.addAll(Arrays.asList(level));
        setAdditionalImages(images);
        setMessages(messages);
        setEnvironment(temp);
        updateStuff();
    }
}
