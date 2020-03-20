package BoringSprites;

import BoringObjects.GameObject;
import java.awt.*;
import java.io.IOException;

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

    public Color getColor() { return color; }
    public int getSize() { return size; }
    public String getMsg() { return msg; }

    //RENDERING
    @Override
    public void draw(Graphics window) throws IOException {
        window.setColor(getColor());
        window.setFont(new Font("TAHOMA",Font.BOLD,getSize()));
        window.drawString(getMsg(),getXPos(),getYPos());
    }
}
