package CLOO;

import javax.swing.*;

public class Game extends JFrame implements Runnable{
    //Main Frame
    private static final  int width = 600;
    private static final int height = 600;
    private final String title = "Chris Game";
    //Panels
    private Scene1 scene1;

    //Frame Constructor
    public Game(){
        super();
        setTitle(title);
        setSize(width,height);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        scene1 = new Scene1(width,height);
        getContentPane().add(scene1);
    }
    //Running
    private boolean running = false;
    private Thread thread; // https://youtu.be/gHh_96Ss1AI?list=PLWms45O3n--6KCNAEETGiVTEFvnqA7qCi
    private synchronized void startGame(){
        if(running) //already started
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    private synchronized void stopGame(){
        if(!(running))
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(1);
    }
    //Game Loop
    public void run() { // https://youtu.be/TNVHWROwYuM?list=PLWms45O3n--6KCNAEETGiVTEFvnqA7qCi
        long last = System.nanoTime();
        final double amountOfTicks = 60.0; //Fps
        double timePerTick = 1000000000/amountOfTicks;
        double delta = 0;
        int updates = 0;
        int frames = 0;
        long timer = System.currentTimeMillis();
        while (running){
            long now = System.nanoTime();
            delta += (now - last)/timePerTick;
            last = now;
            if (delta>=1){
                tick();
                updates++;
                delta--;
                render();
            }
            frames++;
            if (System.currentTimeMillis() - timer > 1000){
                timer+=1000;
                System.out.println("Fps:"+updates+";"+"MaxFps" + frames);
                updates = 0;
                frames = 0;
            }
        }
        stopGame();
    }
    private void tick(){ //update data
        scene1.movePlayer();
    }
    private void render(){ //paint
        scene1.repaint();
    }
    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }

}
