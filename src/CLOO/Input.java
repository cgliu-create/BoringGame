package CLOO;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Input implements KeyListener {
    private Scene scene;
    public Input(Scene scene){
        this.scene = scene;
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            //System.out.println("D");
            scene.ActionDown();
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            //System.out.println("U");
            scene.ActionUp();
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            //System.out.println("L");
            scene.ActionLeft();
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            //System.out.println("R");
            scene.ActionRight();
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }
}
