package BoringGame;
import BoringScenes.*;
import javax.swing.*;
import java.awt.*;

public class SceneSelector extends JFrame {
//Current scene number
    private int curScene;
//All the panels
    private Scene[]  scenes;
    //CONSTRUCTING
    public SceneSelector(String title, int width, int height){
        super(title);
        setSize(width,height);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        scenes = new Scene[]{
                new Scene1(width, height, 1),
                new Scene2(width, height, 2),
                new Scene3(width, height, 3)
        };
        //default scene
        add(scenes[0]);
        addKeyListener(scenes[0].getPlayerInput());
        repaint();
        curScene = 1;
        setVisible(true);
    }
    //GETTING CURRENT SCENE NUMBER
    public int getCurScene() { return curScene;}
//ACCESSING SCENE
    public Scene getScene(){
        if (curScene == 1){ return scenes[0];}
        if (curScene == 2){ return scenes[1];}
        if (curScene == 3){ return scenes[2];}
        return null;
    }
//MAKING SCENE CHANGE
    public void setScene(int scene){
        this.remove(getScene());
        removeKeyListener(getScene().getPlayerInput());
        if (scene == 1){ this.add(scenes[0]); addKeyListener(scenes[0].getPlayerInput());}
        if (scene == 2){ this.add(scenes[1]); addKeyListener(scenes[1].getPlayerInput());}
        if (scene == 3){ this.add(scenes[2]); addKeyListener(scenes[2].getPlayerInput());}
        this.repaint();
        curScene = scene;
    }
//CHANGING SCENE
    public void checkScene(){
        int scenenum = this.getScene().getScenenum();
        if(curScene!=scenenum){
            this.getScene().setScenenum(curScene);
            setScene(scenenum);
            getScene().getPlayerInput().resetPlayer();
        }
    }
//UPDATING SCENE 
    public void sceneUpdate(){
        this.checkScene();
        this.getScene().updatePlayer();
        this.getScene().updateEnemies();
        this.getScene().updateOther();
        this.getScene().updateStatus();

    }
//RENDERING EVERYTHING
    public void sceneRepaint(){
        this.getScene().repaint();
    }
}
