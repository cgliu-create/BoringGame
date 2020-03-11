package BoringSprites;

import BoringImages.ImageGetter;
import BoringObjects.AliveObject;
import BoringObjects.MoveObject;

import java.awt.*;

public class Crate extends MoveObject {
    private ImageGetter i = new ImageGetter();
    public Crate(int x, int y, int wd, int ht, int hp, int mp) {
        super(x, y, wd, ht);
    }
    @Override
    public void draw(Graphics window) {
        i.DrawImage(window,getXPos(),getYPos(),30,getWidth(),getHeight());
    }
}
