package BoringImages;
    import javax.imageio.ImageIO;
    import java.awt.*;
    import java.awt.geom.AffineTransform;
    import java.awt.image.AffineTransformOp;
    import java.awt.image.BufferedImage;
    import java.io.IOException;
public class ImageGetter {
    //list all the images
    private BufferedImage error;
    private BufferedImage player0,player45,player90,player135,player180,player225,player270,player315;
    private BufferedImage enemy0,enemy45,enemy90,enemy135,enemy180,enemy225,enemy270,enemy315;
    private BufferedImage greenblock;
    public ImageGetter(){
        //load in all the images
        try {// https://stackoverflow.com/questions/9864267/loading-image-resource/9866659#9866659
            error = ImageIO.read(getClass().getResource("/BoringImages/error.png"));
            player0 = ImageIO.read(getClass().getResource("/BoringImages/Player0.png"));
            player45 = ImageIO.read(getClass().getResource("/BoringImages/Player45.png"));
            player90 = ImageIO.read(getClass().getResource("/BoringImages/Player90.png"));
            player135 = ImageIO.read(getClass().getResource("/BoringImages/Player135.png"));
            player180 = ImageIO.read(getClass().getResource("/BoringImages/Player180.png"));
            player225 = ImageIO.read(getClass().getResource("/BoringImages/Player225.png"));
            player270 = ImageIO.read(getClass().getResource("/BoringImages/Player270.png"));
            player315 = ImageIO.read(getClass().getResource("/BoringImages/Player315.png"));
            enemy0 = ImageIO.read(getClass().getResource("/BoringImages/Enemy0.png"));
            enemy45 = ImageIO.read(getClass().getResource("/BoringImages/Enemy45.png"));
            enemy90 = ImageIO.read(getClass().getResource("/BoringImages/Enemy90.png"));
            enemy135 = ImageIO.read(getClass().getResource("/BoringImages/Enemy135.png"));
            enemy180 = ImageIO.read(getClass().getResource("/BoringImages/Enemy180.png"));
            enemy225 = ImageIO.read(getClass().getResource("/BoringImages/Enemy225.png"));
            enemy270 = ImageIO.read(getClass().getResource("/BoringImages/Enemy270.png"));
            enemy315 = ImageIO.read(getClass().getResource("/BoringImages/Enemy315.png"));
            greenblock = ImageIO.read(getClass().getResource("/BoringImages/greenblock.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //method to retrieve images
    public BufferedImage getImage(int imgnum) {
        if (imgnum==0)
            return player0;
        if (imgnum==1)
            return player45;
        if (imgnum==2)
            return player90;
        if (imgnum==3)
            return player135;
        if (imgnum==4)
            return player180;
        if (imgnum==5)
            return player225;
        if (imgnum==6)
            return player270;
        if (imgnum==7)
            return player315;
        if (imgnum==8)
            return enemy0;
        if (imgnum==9)
            return enemy45;
        if (imgnum==10)
            return enemy90;
        if (imgnum==11)
            return enemy135;
        if (imgnum==12)
            return enemy180;
        if (imgnum==13)
            return enemy225;
        if (imgnum==14)
            return enemy270;
        if (imgnum==15)
            return enemy315;
        if (imgnum==16)
            return greenblock;
        return error;
    }
    //draw image
    public void DrawImage(Graphics window, int x, int y, int imgnum, int W, int H){
        Image img = getImage(imgnum).getScaledInstance(W, H, Image.SCALE_SMOOTH);
        window.drawImage(img,x,y, null);
    }
}
//importing classes https://stackoverflow.com/questions/28651061/how-to-import-my-own-class
