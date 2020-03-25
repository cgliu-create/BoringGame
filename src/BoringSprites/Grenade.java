package BoringSprites;

import BoringImages.BoringImage;
import BoringImages.ImageGetter;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Grenade extends Shooty{
    //Image
    private ImageGetter i = new ImageGetter();
    //Particle trail list
    private ArrayList<Particle> trail = new ArrayList<>();
    //CONSTRUCTING
    public Grenade(int x, int y, int wd, int ht, int hp, int mp, boolean thisIsThePlayer, int spd) {
        super(x, y, wd, ht, hp, mp, thisIsThePlayer);
        setSpeed(spd);
    }
    //MAKING PARTICLE TRAIL
    @Override
    public boolean update() {
        if( getHP()%5==0)
            trail.add(new Particle(getXPos(),getYPos(),10,10,10,0,Color.DARK_GRAY));
        return super.update();
    }
    //RENDERING
    @Override
    public void draw(Graphics window) throws IOException {
        for (Particle p:trail) {
            p.draw(window);
        }
        i.DrawImage(window,getXPos()-getWidth()/2, getYPos()-getHeight()/2,getWidth(),getHeight(), BoringImage.grenade.getImgLoc());
    }
}
