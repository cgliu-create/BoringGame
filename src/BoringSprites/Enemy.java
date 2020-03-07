package BoringSprites;
import BoringObjects.*;
import images.ImageGetter;
import java.awt.*;
public class Enemy extends GameObject {
    private ImageGetter i = new ImageGetter();
    private Colliding c = new Colliding();
    private Moving m = new Moving();
    private Living l = new Living();
    public Enemy (int x, int y, int wid, int ht) {
        super(x, y, wid, ht);
    }
    @Override
    public void draw(Graphics window) {
        i.DrawRotatedImage(window,getXPos(),getYPos(),1,
                getWidth(),getHeight(),m.getDir());
    }
}