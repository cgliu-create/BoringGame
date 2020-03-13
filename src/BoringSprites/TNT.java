package BoringSprites;

import BoringImages.ImageGetter;
import BoringObjects.MoveObject;
import java.awt.*;

public class TNT extends MoveObject {
//Image
    private ImageGetter i = new ImageGetter();
//CONSTRUCTING  
    public TNT(int x, int y, int wd, int ht) {
        super(x, y, wd, ht);
    }
//RENDERING
    @Override
    public void draw(Graphics window) {
        i.DrawImage(window,getXPos(),getYPos(),27,getWidth(),getHeight());
    }
}
