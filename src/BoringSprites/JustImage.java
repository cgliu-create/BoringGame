package BoringSprites;

import BoringObjects.GameObject;
import BoringImages.ImageGetter;
import java.awt.*;
import java.io.IOException;

public class JustImage extends GameObject {
//Image
    private ImageGetter i = new ImageGetter();
    private String img;
//CONSTRUCTING 
    public JustImage (int x, int y, int wd, int ht, String img) {
        super(x,y, wd, ht);
        this.img = img;
    }
//RENDERING 
    @Override
    public void draw(Graphics window) throws IOException {
        i.DrawImage(window, getXPos(), getYPos(), getWidth(), getHeight(), img);
    }
}
