package BoringSprites;

import BoringImages.ImageGetter;
import BoringObjects.GameObject;
import java.awt.*;

public class Mine extends Bomb {
//Image
    private ImageGetter i = new ImageGetter();
//Enemy
    private GameObject enemy;
//CONSTRUCTING
    public Mine(int x, int y, int wd, int ht, int hp, int mp, Color c) {
        super(x, y, wd, ht, hp, mp, c, 0);
    }
//TARGETING
    public GameObject getEnemy() { return enemy; }
    public void setEnemy(GameObject enemy) { this.enemy = enemy; }
    public boolean update() {
        return this.checkAllDir(enemy);
    }
//RENDERING
    @Override
    public void draw(Graphics window) {
        i.DrawImage(window,getXPos(),getYPos(),26,getWidth(),getHeight());
    }
}
