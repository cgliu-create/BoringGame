package BoringSprites;
import BoringObjects.GameObject;
import BoringImages.ImageGetter;
import java.awt.*;
public class JustImage extends GameObject {
    private ImageGetter i = new ImageGetter();
    private int img;
    public JustImage (int x, int y, int wd, int ht, int img) {
        super(x,y, wd, ht);
        this.img = img;
    }
    @Override
    public void draw(Graphics window) {
        i.DrawImage(window, getXPos(), getYPos(), img, getWidth(), getHeight());
    }
}
