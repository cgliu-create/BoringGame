package CLOO;
import java.awt.*;
public class SpriteEnemy extends Sprite{
    private ImageGetter i = new ImageGetter();
    public SpriteEnemy (int x, int y, int wid, int ht) {
        super(x, y, wid, ht);
    }
    @Override
    public void draw(Graphics window) {
        i.DrawRotatedImage(window,getXPos(),getYPos(),1,
                getWidth(),getHeight(),getDir());
    }
}