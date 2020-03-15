package BoringSprites;

import BoringImages.BoringImage;
import BoringImages.ImageGetter;
import BoringObjects.MoveObject;
import java.awt.*;
import java.io.IOException;

public class Crate extends MoveObject {
//Image
    private ImageGetter i = new ImageGetter();
//CONSTRUCTING        
    public Crate(int x, int y, int wd, int ht) {
        super(x, y, wd, ht);
    }
//RENDERING 
    @Override
    public void draw(Graphics window) throws IOException {
        i.DrawImage(window,getXPos(),getYPos(),getWidth(),getHeight(),BoringImage.crate.getImgLoc());
    }
}
