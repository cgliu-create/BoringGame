package BoringSprites;

import BoringObjects.GameObject;
import java.awt.*;

public class Message extends GameObject {
    private String msg;
    private int size;
    private Color color;
    //CONSTRUCTING
    public Message (int x, int y, int size, String msg, Color color) {
        super(x,y, 0, 0);
        this.msg = msg;
        this.size = size;
        this.color = color;
    }
    //RENDERING
    @Override
    public void draw(Graphics window){
        window.setColor(color);
        window.setFont(new Font("TAHOMA",Font.BOLD,this.size));
        window.drawString(msg,getXPos(),getYPos());
    }
}
