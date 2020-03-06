package CLOO;
import java.awt.*;
public class Scene2 extends Scene{
    private SpriteEnemy enemy = new SpriteEnemy(300,100,100,100);
    public Scene2(int W, int H) {
        super(W, H);
        //setBackground(Color.black);
        setVisible(true);
    }
    public void update(Graphics window) { paint(window);}
    public void paint(Graphics window) { super.getPlayer().draw(window); enemy.draw(window);}
}