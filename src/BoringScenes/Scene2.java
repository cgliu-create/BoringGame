package BoringScenes;

import BoringImages.BoringImage;
import BoringObjects.CollisObject;
import BoringSprites.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Scene2 extends Scene{

    private JustImage[] images = {
            new JustImage(0,0,getW(),getH()/3,BoringImage.green.getImgLoc()),
            new JustImage(0,getH()/3,getW(),getH()/3,BoringImage.brown.getImgLoc()),
            new JustImage(0,getH()/3*2,getW(),getH()/3,BoringImage.gray.getImgLoc())
    };
    private Flag[] levels = {
            new Flag(getW()/3,getH()/3/2,50,50,0)
    };
    //ADDING STUFF
    public Scene2(int W, int H, int scenenum) {
        super(W, H, scenenum);
        //4 walls
        ArrayList<CollisObject> temp = new ArrayList<>();
        addWallT(temp); addWallB(temp); addWallL(temp); addWallR(temp);
        temp.addAll(Arrays.asList(levels));
        setAdditionalImages(images);
        setEnvironment(temp);
        updateStuff();
    }
    @Override
    public void updateStatus() {
    }
}
