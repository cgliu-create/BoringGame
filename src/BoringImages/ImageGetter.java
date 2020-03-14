package BoringImages;
    import javax.imageio.ImageIO;
    import java.awt.*;
    import java.awt.image.BufferedImage;
    import java.io.IOException;
public class ImageGetter {
//All the images
    private BufferedImage error;
    private BufferedImage player0,player45,player90,player135,player180,player225,player270,player315;
    private BufferedImage enemy0,enemy45,enemy90,enemy135,enemy180,enemy225,enemy270,enemy315;
    private BufferedImage dead0,dead45,dead90,dead135,dead180,dead225,dead270,dead315;
    private BufferedImage greenblock,box,wall,ammo,medkit,crate;
    private BufferedImage bomb,mine,tnt;
    private BufferedImage yes, no;
//CONSTRUCTING
    public ImageGetter(){
        try { //load in all the images   https://stackoverflow.com/questions/9864267/loading-image-resource/9866659#9866659
            error = ImageIO.read(getClass().getResource("/BoringImages/error.png"));
            player0 = ImageIO.read(getClass().getResource("/BoringImages/Player/Player0.png"));
            player45 = ImageIO.read(getClass().getResource("/BoringImages/Player/Player45.png"));
            player90 = ImageIO.read(getClass().getResource("/BoringImages/Player/Player90.png"));
            player135 = ImageIO.read(getClass().getResource("/BoringImages/Player/Player135.png"));
            player180 = ImageIO.read(getClass().getResource("/BoringImages/Player/Player180.png"));
            player225 = ImageIO.read(getClass().getResource("/BoringImages/Player/Player225.png"));
            player270 = ImageIO.read(getClass().getResource("/BoringImages/Player/Player270.png"));
            player315 = ImageIO.read(getClass().getResource("/BoringImages/Player/Player315.png"));
            enemy0 = ImageIO.read(getClass().getResource("/BoringImages/Enemy/Enemy0.png"));
            enemy45 = ImageIO.read(getClass().getResource("/BoringImages/Enemy/Enemy45.png"));
            enemy90 = ImageIO.read(getClass().getResource("/BoringImages/Enemy/Enemy90.png"));
            enemy135 = ImageIO.read(getClass().getResource("/BoringImages/Enemy/Enemy135.png"));
            enemy180 = ImageIO.read(getClass().getResource("/BoringImages/Enemy/Enemy180.png"));
            enemy225 = ImageIO.read(getClass().getResource("/BoringImages/Enemy/Enemy225.png"));
            enemy270 = ImageIO.read(getClass().getResource("/BoringImages/Enemy/Enemy270.png"));
            enemy315 = ImageIO.read(getClass().getResource("/BoringImages/Enemy/Enemy315.png"));
            dead0 = ImageIO.read(getClass().getResource("/BoringImages/Dead/Dead0.png"));
            dead45 = ImageIO.read(getClass().getResource("/BoringImages/Dead/Dead45.png"));
            dead90 = ImageIO.read(getClass().getResource("/BoringImages/Dead/Dead90.png"));
            dead135 = ImageIO.read(getClass().getResource("/BoringImages/Dead/Dead135.png"));
            dead180 = ImageIO.read(getClass().getResource("/BoringImages/Dead/Dead180.png"));
            dead225 = ImageIO.read(getClass().getResource("/BoringImages/Dead/Dead225.png"));
            dead270 = ImageIO.read(getClass().getResource("/BoringImages/Dead/Dead270.png"));
            dead315 = ImageIO.read(getClass().getResource("/BoringImages/Dead/Dead315.png"));
            bomb = ImageIO.read(getClass().getResource("/BoringImages/Weapon/bomb.png"));
            mine = ImageIO.read(getClass().getResource("/BoringImages/Weapon/mine.png"));
            tnt = ImageIO.read(getClass().getResource("/BoringImages/Weapon/tnt.png"));
            greenblock = ImageIO.read(getClass().getResource("/BoringImages/Enviro/greenblock.png"));
            box = ImageIO.read(getClass().getResource("/BoringImages/Enviro/box.png"));
            wall = ImageIO.read(getClass().getResource("/BoringImages/Enviro/wall.png"));
            ammo = ImageIO.read(getClass().getResource("/BoringImages/Enviro/ammo.png"));
            medkit = ImageIO.read(getClass().getResource("/BoringImages/Enviro/medkit.png"));
            crate = ImageIO.read(getClass().getResource("/BoringImages/Enviro/crate.png"));
            yes = ImageIO.read(getClass().getResource("/BoringImages/Signs/yes.png"));
            no = ImageIO.read(getClass().getResource("/BoringImages/Signs/no.png"));
        } catch (IOException e) { e.printStackTrace();}
    }
//RETRIEVING IMAGES
    public BufferedImage getImage(int imgnum) {
        if (imgnum==0){ return player0;}
        if (imgnum==1){ return player45;}
        if (imgnum==2){ return player90;} 
        if (imgnum==3){ return player135;}
        if (imgnum==4){  return player180;}
        if (imgnum==5){ return player225;}
        if (imgnum==6){ return player270;}
        if (imgnum==7){ return player315;}
        if (imgnum==8){ return enemy0;} 
        if (imgnum==9){ return enemy45;}
        if (imgnum==10){ return enemy90;}
        if (imgnum==11){ return enemy135;}
        if (imgnum==12){ return enemy180;}       
        if (imgnum==13){ return enemy225;}
        if (imgnum==14){ return enemy270;}
        if (imgnum==15){ return enemy315;}
        if (imgnum==16){ return box;}
        if (imgnum==17){ return wall;}
        if (imgnum==18){ return dead0;}
        if (imgnum==19){ return dead45;}
        if (imgnum==20){ return dead90;}
        if (imgnum==21){ return dead135;}
        if (imgnum==22){ return dead180;}
        if (imgnum==23){ return dead225;}
        if (imgnum==24){ return dead270;}
        if (imgnum==25){ return dead315;}
        if (imgnum==26){ return mine;}
        if (imgnum==27){ return tnt;}
        if (imgnum==28){ return bomb;}
        if (imgnum==29){ return greenblock;}
        if (imgnum==30){ return crate;}
        if (imgnum==31){ return ammo;}
        if (imgnum==32){ return medkit;}
        if (imgnum==33){ return yes;}
        if (imgnum==34){ return no;}
        return error;
    }
//DRAWING IMAGE
    public void DrawImage(Graphics window, int x, int y, int imgnum, int W, int H){
        Image img = getImage(imgnum).getScaledInstance(W, H, Image.SCALE_SMOOTH);
        window.drawImage(img,x,y, null);
    }
}
//importing classes     https://stackoverflow.com/questions/28651061/how-to-import-my-own-class
