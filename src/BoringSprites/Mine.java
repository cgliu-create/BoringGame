package BoringSprites;

import BoringImages.BoringImage;
import BoringImages.ImageGetter;
import BoringObjects.AliveObject;
import BoringObjects.GameObject;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Mine extends Bomb {
//Image
    private ImageGetter i = new ImageGetter();
//CONSTRUCTING
    public Mine(int x, int y, int wd, int ht, int mp) {
        super(x, y, wd, ht, 1, mp, 0);
    }
//TARGETING
    public boolean update(){
        return getHP() <=0;
    }
//RENDERING
    @Override
    public void draw(Graphics window) throws IOException {
        i.DrawImage(window,getXPos(),getYPos(),getWidth(),getHeight(), BoringImage.mine.getImgLoc());
    }
}
