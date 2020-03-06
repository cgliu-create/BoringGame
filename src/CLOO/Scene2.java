package CLOO;
import java.awt.*;
public class Scene2 extends Scene{
    private SpritePlayer player = super.getPlayer();
    private SpriteEnemy enemy = new SpriteEnemy(300,100,100,100);
    public Scene2(int W, int H) {
        super(W, H);
        setBackground(Color.black);
        setVisible(true);
    }
    public void updateSprite() {
        super.updateSprite();
        player=super.getPlayer();
    }
    public void update(Graphics window) { paint(window);}
    public void paint(Graphics window) { player.draw(window); enemy.draw(window);}
}