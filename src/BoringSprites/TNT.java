package BoringSprites;

import BoringImages.ImageGetter;
import BoringObjects.AliveObject;
import BoringObjects.MoveObject;

import java.awt.*;

public class TNT extends MoveObject {
    private ImageGetter i = new ImageGetter();
    private int img;
    public TNT(int x, int y, int wd, int ht) {
        super(x, y, wd, ht);
    }
    @Override
    public void draw(Graphics window) {
        i.DrawImage(window,getXPos(),getYPos(),27,getWidth(),getHeight());
    }
}
