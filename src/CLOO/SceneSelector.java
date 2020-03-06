package CLOO;
import javax.swing.*;
import java.awt.*;

public class SceneSelector extends JFrame {
    private int curScene = 0;
    //Panels
    private Scene scene1,scene2;
    public SceneSelector(String title, int width, int height){
        super(title);
        setSize(width,height);
        setResizable(false);
        setVisible(true);
        scene1 = new Scene1(width,height);
        scene2 = new Scene2(width,height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    //tick and render
    public void sceneUpdate(){
        this.getScene().updateSprite();
    }
    public void sceneRepaint(){
        this.getScene().repaint();
    }
    //Manage scenes
    public int getCurScene() {
        return curScene;
    }
    public Scene getScene(){
        if (curScene == 0){
            return scene1;
        }
        if (curScene == 1){
            return scene2;
        }
        return scene1;
    }
    public void setScene(int scene){
        this.remove(getScene());
        if (scene == 0){
            this.add(scene1);
            this.addKeyListener(scene1.getPlayerInput());
            curScene = 0;
        }
        if (scene == 1){
            this.add(scene2);
            this.addKeyListener(scene2.getPlayerInput());
            curScene = 1;
        }
        this.revalidate();
        this.repaint();
    }
    //get scene status
    public int getStatus(){
        return 0;
    }
}
