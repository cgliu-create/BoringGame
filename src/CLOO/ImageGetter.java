package CLOO;
import javax.imageio.ImageIO;
import java.awt.*;
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
}
