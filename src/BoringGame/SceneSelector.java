package BoringGame;
import BoringScenes.*;
import javax.swing.*;

public class SceneSelector extends JFrame {
//Current scene number
    private int curScene = 0;
//All the panels
    private Scene scene0,scene1;
//CONSTRUCTING
    public SceneSelector(String title, int width, int height){
        super(title);
        setSize(width,height);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        scene0 = new Scene0(width,height,0);
        scene1 = new Scene1(width,height,1);
    }
//GETTING CURRENT SCENE NUMBER
    public int getCurScene() { return curScene;}
//ACCESSING SCENE
    public Scene getScene(){
        if (curScene == 0){ return scene0;}
        if (curScene == 1){ return scene1;}
        return scene0;
    }
//MAKING SCENE CHANGE
    public void setScene(int scene){
        if (scene == 0){ this.add(scene0); this.addKeyListener(scene0.getPlayerInput());}
        if (scene == 1){ this.add(scene1); this.addKeyListener(scene1.getPlayerInput());}
        this.remove(getScene());
        this.repaint();
        curScene = scene;
    }
//CHANGING SCENE
    public void checkScene(){
        int scenenum = this.getScene().getScenenum();
        if(curScene!=scenenum){
            this.getScene().setScenenum(curScene);
            setScene(scenenum);
        }
    }
//UPDATING SCENE 
    public void sceneUpdate(){
        this.getScene().updatePlayer();
        this.getScene().updateEnemies();
        this.getScene().updateOther();
        this.checkScene();
    }
//RENDERING EVERYTHING
    public void sceneRepaint(){
        this.getScene().repaint();
    }
}
