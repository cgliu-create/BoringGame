package BoringSprites;

import BoringImages.BoringImage;

import java.awt.*;
import java.io.IOException;

public class Status extends Message{
    private JustImage heart = new JustImage(0,0,50,50, BoringImage.heart.getImgLoc());
    private JustImage bullets = new JustImage(0,0,50,50, BoringImage.bullets.getImgLoc());
    private JustImage gold = new JustImage(0,0,50,50, BoringImage.gold.getImgLoc());
    private Shooty guy;
    //CONSTRUCTING
    public Status(int x, int y, String msg, Color color, Shooty guy) {
        super(x, y, 0, msg, color); this.guy = guy;
    }
    //RENDERING
    @Override
    public void draw(Graphics window) throws IOException {
        int x = getXPos(); int y = getYPos();
        window.setColor(Color.WHITE);
        window.setFont(new Font("TAHOMA",Font.BOLD,20));
        heart.setXPos(x); heart.setYPos(y);
        heart.draw(window);
        window.drawString(""+guy.getHP(),x+60,y+30);
        bullets.setXPos(x+120); bullets.setYPos(y);
        bullets.draw(window);
        window.drawString(""+guy.getMP(),x+170,y+30);
        gold.setXPos(x+230); gold.setYPos(y);
        gold.draw(window);
        window.drawString("ehhh",x+290,y+30);
    }

}
