package BoringScenes;

import java.awt.*;

public class Scene1 extends Scene {
    public Scene1(int W, int H) {
        super(W, H);
        //setBackground(Color.black);
        setVisible(true);
    }

    @Override
    public void updateOther() {

    }

    public void update(Graphics window) { paint(window);}
    public void paint(Graphics window) { super.getPlayer().draw(window);}
}
