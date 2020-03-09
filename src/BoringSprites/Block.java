package BoringSprites;

import BoringImages.ImageGetter;
import BoringObjects.MoveObject;

import java.awt.*;

public class Block extends MoveObject {
    private ImageGetter i = new ImageGetter();
    private int img;
    public Block(int x, int y, int wd, int ht) {
        super(x, y, wd, ht);
    }
    @Override
    public void draw(Graphics window) {
        i.DrawImage(window,getXPos(),getYPos(),16,getWidth(),getHeight());
    }
}
