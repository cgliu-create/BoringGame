package BoringSprites;

import java.awt.*;
import java.util.ArrayList;

public class Bullet extends Particle{
    private ArrayList<Particle> trail = new ArrayList<>();
    public Bullet(int x, int y, int wd, int ht, int hp, int mp, Color c, int spd) {
        super(x, y, wd, ht, hp, mp, c, spd);
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
        window.setColor(getColor());
        window.fillOval(getXPos() - (getWidth() / 2), getYPos() - (getHeight() / 2), getWidth(), getHeight());
    }
}