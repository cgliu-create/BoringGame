package BoringScenes;

import BoringImages.BoringImage;
import BoringObjects.CollisObject;
import BoringSprites.JustImage;
import BoringSprites.Message;
import BoringSprites.Wall;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;


public class Scene1 extends Scene {

    private Message[] messages = {
            new Message(50,120,80,"JAVA TANK",Color.WHITE),
            new Message(getW()/2,100,50,"HOW TO PLAY",Color.WHITE),
            new Message(50,200,30,"MOVEMENT",Color.WHITE),
            new Message(50,320,20,"accelerate",Color.WHITE),
            new Message(50,420,20,"turn",Color.WHITE),
            new Message(300,200,30,"SPACE = FIRE",Color.WHITE),

    };
    private JustImage[] images = {
            new JustImage(50,200,100,100,BoringImage.upsign.getImgLoc()),
            new JustImage(150,200,100,100,BoringImage.downsign.getImgLoc()),
            new JustImage(50,300,100,100,BoringImage.leftsign.getImgLoc()),
            new JustImage(150,300,100,100,BoringImage.rightsign.getImgLoc()),
    };
    public Scene1(int W, int H, int scenenum) {
        super(W, H, scenenum);
        setBackground(BoringImage.green.getImgLoc());
        ArrayList<CollisObject> temp = new ArrayList<>();
        for (int i = 0; i < getW()/50; i++) {
            temp.add(new Wall(i*50,0,50,50));
        }
        for (int i = 1; i < getH()/50; i++) {
            temp.add(new Wall(0,i*50,50,50));
        }
        for (int i = 1; i < getH()/50; i++) {
            temp.add(new Wall(getW()-50,i*50,50,50));
        }
        for (int i = 1; i < getW()/50-1; i++) {
            temp.add(new Wall(i*50,getH()-50,50,50));
        }
        setAdditionalImages(images);
        setMessages(messages);
        setEnvironment(temp);
        updateStuff();
    }
}
