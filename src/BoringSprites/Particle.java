package BoringSprites;

import BoringObjects.AliveObject;
import BoringObjects.GameObject;

import java.awt.*;

public class Particle extends AliveObject {
    private Color color;
    public Particle(int x, int y, int wd, int ht, int hp, int mp, Color c) {
        super(x, y, wd, ht, hp, mp);
        color = c;
    }
    public Particle(int x, int y, int wd, int ht, int hp, int mp, Color c, int spd) {
        super(x, y, wd, ht, hp, mp);
        color = c;
        setSpeed(spd);
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public boolean update(){
        int x = getXPos() + getXspeed();
        int y = getYPos() + getYspeed();
        setXPos(x);
        setYPos(y);
        int hp = getHP() -1;
        setHP(hp);
        return getHP() == 0;
    }
    public void draw(Graphics window){
        window.setColor(color);
        window.fillRect(getXPos()-(getWidth()/2), getYPos()-(getHeight()/2), getWidth(), getHeight());
    }
    @Override
    public Particle getParticle() {
        return this;
    }
}
