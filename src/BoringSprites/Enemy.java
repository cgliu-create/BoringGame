package BoringSprites;
import BoringObjects.AliveObject;
import BoringImages.ImageGetter;
import java.awt.*;
public class Enemy extends AliveObject {
    private ImageGetter i = new ImageGetter();
    public Enemy (int x, int y, int wd, int ht, int hp, int mp) {
        super(x, y, wd, ht, hp, mp);
    }
    public void drawSuper(Graphics window){
        super.draw(window);
    }
    @Override
    public void draw(Graphics window) {
        i.DrawImage(window,getXPos(),getYPos(),14,
                getWidth(),getHeight());
    }
}