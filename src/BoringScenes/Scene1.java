package BoringScenes;

import BoringImages.BoringImage;
import BoringObjects.CollisObject;
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
            new Message(getW()/2+100,200,30,"ENEMY",Color.WHITE),
            new Message(getW()/2+300,200,30,"TARGET", Color.WHITE),
            new Message(getW()/2-100,500,80,"PLAY",Color.WHITE),
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
    public Scene1(int W, int H, int scenenum) {
        super(W, H, scenenum);
        setBackground(BoringImage.green.getImgLoc());
        //4 walls
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
        getPlayer().setXPos(getW()/2-350);
        getPlayer().setYPos(500);
        setAdditionalImages(images);
        setMessages(messages);
        setEnvironment(temp);
        updateStuff();
    }
}
