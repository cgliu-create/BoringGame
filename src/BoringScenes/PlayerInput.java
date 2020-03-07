package BoringScenes;
import BoringSprites.Player;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class PlayerInput implements KeyListener {
    private Player player = new Player(100,100,100,100, 100,100);
    public Player getPlayer(){
        return player;
    }
    public void setPlayer(Player newplayer){
        player = newplayer;
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            int spd = player.getSpeed()-1;
            player.setSpeed(spd);
            if (spd<-3){
                player.setSpeed(-3);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            int spd = player.getSpeed();
            player.setSpeed(spd + 1);
            if (spd>3){
                player.setSpeed(3);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            int dir = player.getDir();
            player.setDir(dir - 45);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            int dir = player.getDir();
            player.setDir(dir + 45);
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
    }
}
