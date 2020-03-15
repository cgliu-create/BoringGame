package BoringSprites;

import BoringImages.BoringImage;
import BoringImages.ImageGetter;
import BoringObjects.CollisObject;
import java.awt.*;
import java.io.IOException;

public class Wall extends CollisObject {
//Image
    private ImageGetter i = new ImageGetter();
//CONSTRUCTING 
    public Wall(int x, int y, int wd, int ht) {
        super(x, y, wd, ht);
    }
//RENDERING
    @Override
    public void draw(Graphics window) throws IOException {
        i.DrawImage(window,getXPos(),getYPos(),getWidth(),getHeight(), BoringImage.wall.getImgLoc());
    }
}
