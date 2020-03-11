package BoringSprites;

import BoringImages.ImageGetter;
import BoringObjects.CollisObject;

import java.awt.*;

public class Wall extends CollisObject {
    private ImageGetter i = new ImageGetter();
    private int img;
    public Wall(int x, int y, int wd, int ht) {
        super(x, y, wd, ht);
    }
    @Override
    public void draw(Graphics window) {
        i.DrawImage(window,getXPos(),getYPos(),17,getWidth(),getHeight());
    }
}
