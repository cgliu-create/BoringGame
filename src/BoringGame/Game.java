package BoringGame;

public class Game implements Runnable{
    //Frame
    private static final  int width = 600;
    private static final int height = 600;
    private final String title = "Chris Game";
    private SceneSelector sceneSelector = new SceneSelector(title,width,height);
    //Running
    private boolean running = false;
    private Thread thread;
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
    //https://youtu.be/TNVHWROwYuM?list=PLWms45O3n--6KCNAEETGiVTEFvnqA7qCi
    public void run() {
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
    //update data
    private void tick(){ sceneSelector.sceneUpdate();}
    //update graphics
    private void render(){ sceneSelector.sceneRepaint();}
    public static void main(String[] args) {
        Game game = new Game();
        game.sceneSelector.setScene(1);
        game.startGame();

    }
}
