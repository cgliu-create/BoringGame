package BoringSprites;

import BoringImages.ImageGetter;
import BoringObjects.AliveObject;

import java.awt.*;

public class Crate extends AliveObject {
    private ImageGetter i = new ImageGetter();
    public Crate(int x, int y, int wd, int ht, int hp, int mp) {
        super(x, y, wd, ht, hp, mp);
    }
    @Override
    public void draw(Graphics window) {
        i.DrawImage(window,getXPos(),getYPos(),16,getWidth(),getHeight());
    }
}
