package BoringImages;
    import javax.imageio.ImageIO;
    import java.awt.*;
    import java.awt.image.BufferedImage;
    import java.io.IOException;
public class ImageGetter {
    //load in images   https://stackoverflow.com/questions/9864267/loading-image-resource/9866659#9866659
    //RETRIEVING IMAGES
    public BufferedImage getImage(String imgLoc) throws IOException {
        return ImageIO.read(getClass().getResource(imgLoc));
    }
    //DRAWING IMAGE
    public void DrawImage(Graphics window, int x, int y, int W, int H, String imgLoc) throws IOException {
        Image img = getImage(imgLoc).getScaledInstance(W, H, Image.SCALE_SMOOTH);
        window.drawImage(img, x, y, null);
    }
}
