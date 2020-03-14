package BoringSprites;

import BoringImages.ImageGetter;

import java.awt.*;

public class Button extends TNT{
    //Image
    private ImageGetter i = new ImageGetter();
    int img;
    //CONSTRUCTING
    public Button(int x, int y, int wd, int ht, boolean yn) {
        super(x, y, wd, ht);
        img = 34;
        if(yn){img = 33;}
    }
    //RENDERING
    @Override
    public void draw(Graphics window) {
        i.DrawImage(window,getXPos(),getYPos(),img,getWidth(),getHeight());
    }
}
