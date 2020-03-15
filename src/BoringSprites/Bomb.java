package BoringSprites;

import BoringImages.BoringImage;
import BoringImages.ImageGetter;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Bomb extends Bullet{
//Image
    private ImageGetter i = new ImageGetter();
//Particle trail list
    private ArrayList<Particle> trail = new ArrayList<>();
//CONSTRUCTING    
    public Bomb(int x, int y, int wd, int ht, int hp, int mp, Color c, int spd) {
        super(x, y, wd, ht, hp, mp, c, spd);
    }
//RENDERING
    @Override
    public void draw(Graphics window) throws IOException {
        for (Particle p:trail) {
            p.draw(window);
        }
        i.DrawImage(window,getXPos()-getWidth()/2, getYPos()-getHeight()/2,getWidth(),getHeight(), BoringImage.bomb.getImgLoc());
    }
}
