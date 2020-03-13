package BoringSprites;

import BoringObjects.AliveObject;
import java.awt.*;

public class Particle extends AliveObject {
//Color
    private Color color;
//CONSTRUCTING
    public Particle(int x, int y, int wd, int ht, int hp, int mp, Color c) {
        super(x, y, wd, ht, hp, mp);
        color = c;
    }
    public Particle(int x, int y, int wd, int ht, int hp, int mp, Color c, int spd) {
        super(x, y, wd, ht, hp, mp);
        color = c;
        setSpeed(spd);
    }
//IDENTIFYING PARTICLE
    public Color getColor() { return color;}
    public void setColor(Color color) { this.color = color;}
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
    public void draw(Graphics window) {
        window.setColor(color);
        window.fillRect(getXPos(), getYPos(), getWidth(), getHeight());
    }
}
