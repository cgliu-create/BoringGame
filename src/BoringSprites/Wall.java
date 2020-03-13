package BoringSprites;

import BoringImages.ImageGetter;
import BoringObjects.CollisObject;
import java.awt.*;

public class Wall extends CollisObject {
//Image
    private ImageGetter i = new ImageGetter();
//CONSTRUCTING 
    public Wall(int x, int y, int wd, int ht) {
        super(x, y, wd, ht);
    }
//RENDERING
    @Override
    public void draw(Graphics window) {
        i.DrawImage(window,getXPos(),getYPos(),17,getWidth(),getHeight());
    }
}
