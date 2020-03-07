package CLOO;
import BoringObjects.Sprite;
import images.ImageGetter;
import java.awt.*;
public class SpritePlayer extends Sprite {
    private ImageGetter i = new ImageGetter();
    public SpritePlayer(int x, int y, int wid, int ht) {
        super(x, y, wid, ht);
    }
    @Override
    public void draw(Graphics window) {
        i.DrawRotatedImage(window,getXPos(),getYPos(),0,
                getWidth(),getHeight(),getDir());
    }
}
