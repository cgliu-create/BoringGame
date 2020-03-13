package BoringSprites;

import BoringImages.ImageGetter;
import BoringObjects.BreakObject;
import java.awt.*;

public class Ammo extends BreakObject {
//Image
    private ImageGetter i = new ImageGetter();
//CONSTRUCTING
    public Ammo(int x, int y, int wd, int ht, int hp, int mp) {
        super(x, y, wd, ht, hp, mp);
    }
//RENDERING
    @Override
    public void draw(Graphics window) {
        i.DrawImage(window,getXPos(),getYPos(),31,getWidth(),getHeight());
    }
}
