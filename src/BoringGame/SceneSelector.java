package BoringGame;
import BoringScenes.*;
import javax.swing.*;

public class SceneSelector extends JFrame {
    private int curScene = 0;
    //Panels
    private Scene scene1,scene2;
    public SceneSelector(String title, int width, int height){
        super(title);
        setSize(width,height);
        setResizable(false);
        setVisible(true);
        scene1 = new Scene1(width,height,0);
        scene2 = new Scene2(width,height,1);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    //tick and render
    public void sceneUpdate(){
        this.getScene().updatePlayer();
        this.getScene().updateOther();
        int sn = this.getScene().getScenenum();
        if(curScene!=sn){
            this.getScene().setScenenum(curScene);
            setScene(sn);
        }
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
        if (scene == 0){
            this.add(scene1);
            this.addKeyListener(scene1.getPlayerInput());
        }
        if (scene == 1){
            this.add(scene2);
            this.addKeyListener(scene2.getPlayerInput());
        }
        this.remove(getScene());
        this.repaint();
        curScene = scene;
    }
}
