package BoringScenes;

import BoringImages.BoringImage;
import BoringObjects.CollisObject;
import BoringSprites.Flag;
import BoringSprites.JustImage;
import BoringSprites.Message;
import BoringSprites.Wall;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

/*
instructions
 */
public class Scene1 extends Scene {

    private Message[] messages = {
            new Message(getW()/2-450,120,80,"JAVA TANK",Color.WHITE),
            new Message(getW()/2,100,50,"HOW TO PLAY",Color.WHITE),
            new Message(getW()/2-450,200,30,"MOVEMENT",Color.WHITE),
            new Message(getW()/2-450,240,20,"accelerate",Color.WHITE),
            new Message(getW()/2-450,340,20,"turn",Color.WHITE),
            new Message(getW()/2-200,200,30,"SPACE = FIRE",Color.WHITE),
            new Message(getW()/2-200,240,20,"bullets",Color.WHITE),
            new Message(getW()/2-200,300,20,"1             2              3",Color.WHITE),
            new Message(getW()/2-200,400,20,"4             5              6",Color.WHITE),
            new Message(getW()/2+100,200,30,"DEFEAT",Color.WHITE),
            new Message(getW()/2+100,240,30,"ENEMIES", Color.WHITE),
            new Message(getW()/2+300,200,30,"SHOOT", Color.WHITE),
            new Message(getW()/2+300,240,30,"TARGETS", Color.WHITE),
            new Message(getW()/2,500,80,"PLAY",Color.WHITE),
    };
    private JustImage[] images = {
            new JustImage(getW()/2-450,220,100,100,BoringImage.upsign.getImgLoc()),
            new JustImage(getW()/2-350,220,100,100,BoringImage.downsign.getImgLoc()),
            new JustImage(getW()/2-450,320,100,100,BoringImage.leftsign.getImgLoc()),
            new JustImage(getW()/2-350,320,100,100,BoringImage.rightsign.getImgLoc()),
            new JustImage(getW()/2-200,250,50,50,BoringImage.cannonball.getImgLoc()),
            new JustImage(getW()/2-100,250,50,50,BoringImage.bomb.getImgLoc()),
            new JustImage(getW()/2,250,50,50,BoringImage.grenade.getImgLoc()),
            new JustImage(getW()/2-200,350,50,50,BoringImage.mine.getImgLoc()),
            new JustImage(getW()/2-100,350,50,50,BoringImage.lavaball.getImgLoc()),
            new JustImage(getW()/2,350,50,50,BoringImage.bombA.getImgLoc()),
            new JustImage(getW()/2+100, 250, 50,50, BoringImage.enemy0.getImgLoc()),
            new JustImage(getW()/2+300, 250, 50,50, BoringImage.redflag.getImgLoc())
    };
    private Flag playbutton = new Flag(getW()/2-60,450,50,50,0);
    public Scene1(int W, int H, int scenenum) {
        super(W, H, scenenum);
        makeScene();
        getPlayer().setXPos(200);
        getPlayer().setYPos(500);
    }

    @Override
    public void updateStatus() {
       if (flagCheck(playbutton)){
           setScenenum(2);
           playbutton.setType(0);
       }
    }

    @Override
    public void makeScene() {
        setBackground(BoringImage.green.getImgLoc());
        ArrayList<CollisObject> temp = new ArrayList<>();
        addFourWalls(temp);
        temp.add(playbutton);
        setAdditionalImages(images);
        setMessages(messages);
        setEnvironment(temp);
        updateStuff();
    }
}

