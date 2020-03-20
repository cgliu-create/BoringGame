package BoringGame;

public class Game implements Runnable{
//Frame 
    private SceneSelector sceneSelector = new SceneSelector("TANK",1000,800);
//Running
    private boolean running = false;
    private Thread thread;
//STARTING GAME
    private synchronized void startGame(){
        if(running){ return;}
        running = true;
        thread = new Thread(this);
        thread.start();
    }
//STOPPING GAME
    private synchronized void stopGame(){
        if(!(running)){ return;}
        running = false;
        try { thread.join();
        } catch (InterruptedException e) { e.printStackTrace();}
        System.exit(1);
    }
//GAME LOOP    https://youtu.be/TNVHWROwYuM?list=PLWms45O3n--6KCNAEETGiVTEFvnqA7qCi
    public void run() {
        long last = System.nanoTime();
        final double amountOfTicks = 60.0; //Fps
        double timePerTick = 1000000000/amountOfTicks;
        double change = 0;
        int updates = 0;
        int frames = 0;
        long timer = System.currentTimeMillis();
        while (running){
            long now = System.nanoTime();
            change += (now - last)/timePerTick;
            last = now;
            if (change>=1){ tick();render(); updates++; change--;}
            frames++;
            if (System.currentTimeMillis() - timer > 1000){
               // System.out.println("Fps:"+updates+";"+"MaxFps" + frames);
                timer+=1000; updates = 0; frames = 0;
            }
        }
        stopGame();
    }
//UPDATING DATA
    private void tick(){ sceneSelector.sceneUpdate();}
//UPDATING GRAPHICS
    private void render(){ sceneSelector.sceneRepaint();}
//RUNNER
    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }
}
