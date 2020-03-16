package BoringSprites;

import BoringObjects.GameObject;
import java.awt.*;

public class Message extends GameObject {
    private String msg;
    private int size, x, y;
    private Color color;
    //CONSTRUCTING
    public Message (int x, int y, int size, String msg, Color color) {
        super(x,y, size, size);
        this.msg = msg;
        this.x = x;
        this.y = y;
        this.color = color;
    }
    //RENDERING
    @Override
    public void draw(Graphics window){
        window.setColor(color);
        window.setFont(new Font("TAHOMA",Font.BOLD,size));
        window.drawString(msg,x,y);
    }
}
