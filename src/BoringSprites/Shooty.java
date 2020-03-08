package BoringSprites;

import BoringObjects.AliveObject;
import BoringStuff.Aiming;

import java.awt.*;

public abstract class Shooty extends AliveObject {
    private Aiming a = new Aiming(this);
    public Shooty(int x, int y, int wd, int ht, int hp, int mp) {
        super(x, y, wd, ht, hp, mp);
    }
    public void drawAim(Graphics window){ a.draw(window);}
    public void drawSuper(Graphics window){
        super.draw(window);
    }
    public abstract Particle getParticle();
}
