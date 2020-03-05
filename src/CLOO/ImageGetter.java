package CLOO;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
public class ImageGetter {
    //list all the images
    private Image error;
    private Image snow0;
    public ImageGetter(){
        //load in all the images
        try {// https://stackoverflow.com/questions/9864267/loading-image-resource/9866659#9866659
            snow0 = ImageIO.read(getClass().getResource("/images/snow.png"));
            error = ImageIO.read(getClass().getResource("/images/error.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //method to retrieve images
    public Image getImage(int imgnum, int W, int H) {
        if (imgnum==0){
            return snow0.getScaledInstance(W, H, Image.SCALE_SMOOTH);
        }
        return error.getScaledInstance(W, H, Image.SCALE_SMOOTH);
    }
    //draw image
    public void DrawImage(Graphics window, int x, int y, int imgnum, int W, int H){
        Image img = getImage(imgnum,W,H);
        window.drawImage(img,x,y, null);
    }
    public void DrawRotatedImage(Graphics window, int x, int y, int imgnum, int W, int H, double rot){
        Image img = getImage(imgnum,W,H);
        double r = Math.toRadians(rot);
        double cx = W/2.0;
        double cy = H/2.0;
        AffineTransform tx = AffineTransform.getRotateInstance(r, cx, cy);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
        Graphics2D g2d = (Graphics2D)window;
        g2d.drawImage(op.filter((BufferedImage) img, null), x, y, null);
    } //https://stackoverflow.com/questions/8639567/java-rotating-images
}
