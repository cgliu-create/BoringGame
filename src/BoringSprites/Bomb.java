package BoringSprites;

import BoringImages.ImageGetter;

import java.awt.*;

public class Bomb extends Particle{
    private ImageGetter i = new ImageGetter();
    public Bomb(int x, int y, int wd, int ht, int hp, int mp, Color c, int spd) {
        super(x, y, wd, ht, hp, mp, c, spd);
    }
    @Override
    public void draw(Graphics window) {
        i.DrawImage(window,getXPos(),getYPos(),17,
                getWidth(),getHeight());
    }
}
