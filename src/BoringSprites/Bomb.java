package BoringSprites;

import BoringImages.ImageGetter;
import java.awt.*;
import java.util.ArrayList;

public class Bomb extends Particle{
    private ImageGetter i = new ImageGetter();
    private ArrayList<Particle> trail = new ArrayList<>();
    public Bomb(int x, int y, int hp, int mp, Color c, int spd) {
        super(x, y, 50, 50, hp, mp, c, spd);
    }
    @Override
    public boolean update() {
        if( getHP()%5==0)
            trail.add(new Particle(getXPos(),getYPos(),10,10,10,0,Color.DARK_GRAY));
        return super.update();
    }
    @Override
    public void draw(Graphics window) {
        for (Particle p:trail) {
            p.draw(window);
        }
        i.DrawImage(window,getCenterX(),getCenterY(),28, getWidth(),getHeight());
    }
}
