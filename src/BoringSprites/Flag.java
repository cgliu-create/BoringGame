package BoringSprites;

import BoringImages.BoringImage;
import BoringImages.ImageGetter;
import BoringObjects.CollisObject;

import java.awt.*;
import java.io.IOException;

public class Flag extends CollisObject {
    //Image
    private ImageGetter i = new ImageGetter();
    private String img;
    private int type;
    //0 = white, 1 = red, 2 = green
    //CONSTRUCTING
    public Flag(int x, int y, int wd, int ht, int type) {
        super(x, y, wd, ht);
        this.type = type;
    }
    //RENDERING
    @Override
    public void draw(Graphics window) throws IOException {
        if(type == 0){ img = BoringImage.whiteflag.getImgLoc(); }
        if(type == 1){ img = BoringImage.redflag.getImgLoc(); }
        if(type == 2){ img = BoringImage.greenflag.getImgLoc(); }
        i.DrawImage(window,getXPos(),getYPos(),getWidth(),getHeight(), img);
    }
    //CHANGING FLAGS
    public void setType(int type){ this.type = type; }
    public int getType() { return type; }
}
