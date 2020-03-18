package BoringGame;
import BoringScenes.*;
import javax.swing.*;
import java.awt.*;

public class SceneSelector extends JFrame {
//Current scene number
    private int curScene;
//All the panels
    private Scene scene1,scene2;
//CONSTRUCTING
    public SceneSelector(String title, int width, int height){
        super(title);
        setSize(width,height);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        scene1 = new Scene1(width,height,1);
        scene2 = new Scene2(width,height,2);
        //default scene
        add(scene1);
        addKeyListener(scene1.getPlayerInput());
        repaint();
        curScene = 1;
        setVisible(true);
    }
//GETTING CURRENT SCENE NUMBER
    public int getCurScene() { return curScene;}
//ACCESSING SCENE
    public Scene getScene(){
        if (curScene == 1){ return scene1;}
        if (curScene == 2){ return scene2;}
        return null;
    }
//MAKING SCENE CHANGE
    public void setScene(int scene){
        if (scene == 1){ this.add(scene1); this.addKeyListener(scene1.getPlayerInput());}
        if (scene == 2){ this.add(scene2); this.addKeyListener(scene2.getPlayerInput());}
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
        this.getScene().updateStatus();
        this.checkScene();
    }
//RENDERING EVERYTHING
    public void sceneRepaint(){
        this.getScene().repaint();
    }
}
