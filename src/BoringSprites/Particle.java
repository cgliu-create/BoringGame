package BoringSprites;

import BoringObjects.AliveObject;
import java.awt.*;
import java.io.IOException;

public class Particle extends AliveObject {
//CONSTRUCTING
    public Particle(int x, int y, int wd, int ht, int hp, int mp) {
        super(x, y, wd, ht, hp, mp);
    }
    public Particle(int x, int y, int wd, int ht, int hp, int mp, int spd) {
        super(x, y, wd, ht, hp, mp);
        setSpeed(spd);
    }
//TEMPORARILY MOVING
    public boolean update() {
        int x = getXPos() + getXspeed();
        int y = getYPos() + getYspeed();
        setXPos(x); setYPos(y);
        int hp = getHP() - 1;
        setHP(hp);
        return getHP() == 0;
    }
//RENDERING
    public void draw(Graphics window) throws IOException {
        window.setColor(Color.DARK_GRAY);
        window.fillRect(getXPos(), getYPos(), getWidth(), getHeight());
    }
}
