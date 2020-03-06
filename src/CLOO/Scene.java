package CLOO;
import javax.swing.*;
import java.awt.*;
public abstract class Scene extends JPanel {
    public Scene(int W, int H) {
        setSize(W,H);
        setBackground(Color.black);
    }
    //update data
    public abstract void ActionLeft();
    public abstract void ActionRight();
    public abstract void ActionDown();
    public abstract void ActionUp();
    //update sprites
    public abstract void updateSprite();
    //repaint methods
    //public void update(Graphics window) {}
    //public void paint(Graphics window) {}
}
